pipeline {
    agent any

    environment {
        sshCredentials = 'ORACLE-SERVER'
        DOCKER_CREDENTIALS = 'API-DOCKER'
        SONAR_TOKEN = 'sonar-token'
    }

    tools {
        maven 'maven'
    }

    triggers {
        githubPush()
    }

    stages {
        stage('SSH Test') {
            steps {
                sshagent(credentials: [sshCredentials]) {
                    sh 'ssh -o StrictHostKeyChecking=no opc@158.179.219.214 echo Conexión exitosa'
                }
            }
        }
        stage('Checkout') {
            steps {
                git branch: 'main',
                credentialsId: '2e9cf125-4d0e-4899-bef2-66231d695e96',
                url: 'https://github.com/DavdPortillo/WinningStation.git'
            }
        }
        stage('Build App') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('SonarQube analysis') {
            steps {
                withCredentials([string(credentialsId: SONAR_TOKEN, variable: 'SONAR_TOKEN')]) {
                    withSonarQubeEnv('Sonarqube') {
                        sh '''
                            mvn sonar:sonar \
                            -Dsonar.projectKey=winning-station-api \
                            -Dsonar.projectName='winning-station-api' \
                            -Dsonar.host.url=http://158.179.219.214:9000 \
                            -Dsonar.login=$SONAR_TOKEN \
                            -Dsonar.java.binaries=target/classes
                        '''
                    }
                }
            }
        }
        stage('Build and Push Docker Images') {
            steps {
                script {
                    String gitCommitFull = sh(script: 'git rev-parse HEAD', returnStdout: true).trim()
                    String gitCommit = gitCommitFull.substring(0, 7)
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_CREDENTIALS) {
                        sh """
                            docker buildx create --name multi-arch-builder --use
                            docker buildx build --builder multi-arch-builder --platform linux/amd64,linux/arm64 -t davdportillo/winning-station:$gitCommit --build-arg GIT_COMMIT=$gitCommit --push .
                            docker buildx imagetools create --tag davdportillo/winning-station:latest davdportillo/winning-station:$gitCommit
                            docker buildx imagetools push davdportillo/winning-station:latest
                            docker buildx imagetools push davdportillo/winning-station:$gitCommit
                            docker buildx rm multi-arch-builder
                        """
                    }
                }
            }
        }
        stage('Cleanup') {
            steps {
                sh 'rm -rf *'
            }
        }
        stage('Test API') {
            steps {
                withCredentials([
        usernamePassword(credentialsId: '2e9cf125-4d0e-4899-bef2-66231d695e96', passwordVariable: 'GIT_PASSWORD', usernameVariable: 'GIT_USERNAME'),
        usernamePassword(credentialsId: DOCKER_CREDENTIALS, passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')
        ]) {
                    sshagent(credentials: [sshCredentials]) {
                        sh '''
                ssh opc@158.179.219.214 <<EOF
                git clone https://$GIT_USERNAME:$GIT_PASSWORD@github.com/DavdPortillo/WinningStation.git
                mv WinningStation/docker-compose.yml .
                mv WinningStation/docker-compose.test.yml .
                rm -rf WinningStation

                # Iniciar sesión en Docker Hub
                echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
                docker compose -f docker-compose.test.yml pull
                docker compose -f docker-compose.test.yml -p test-api up -d
EOF
                '''
                    }
                    timeout(time: 1, unit: 'MINUTES') {
                        waitUntil {
                        script {
                               echo "About to run curl command..."
                                def response = sh(script: 'curl -s http://158.179.219.214:1010/actuator/health | grep -q UP', returnStatus: true)
                                echo "Curl command finished. Response: $response"
                                return response == 0
                        }
                    }
                }
            }
        }
            post {
                success {
                    sshagent(credentials: [sshCredentials]) {
                        sh '''
                            ssh opc@158.179.219.214 <<EOF
                            docker compose -f docker-compose.test.yml -p test-api down
                            rm docker-compose.test.yml
EOF
                '''
                    }
                }
                failure {
                    echo 'Las pruebas fallaron.'
                }
            }
        }
        stage('Deploy to Server') {
            steps {
                    withCredentials([
                    usernamePassword(credentialsId: DOCKER_CREDENTIALS, passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')
                    ]) {
                    sshagent(credentials: [sshCredentials]) {
                        sh '''
                            ssh opc@158.179.219.214 <<EOF
                            cd k8s
                            cp app-deployment-template.yaml app-deployment.yaml
                            sed -i 's|davdportillo/winning-station:latest|davdportillo/winning-station:'${GIT_COMMIT}'|' app-deployment.yaml
                            kubectl apply -f deployment.yaml
EOF

                    '''

                    //                             # Iniciar sesión en Docker Hub
                    //                             echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
                    //                             docker compose down
                    //                             docker compose pull
                    //                             docker compose up -d
                    //                             rm docker-compose.yml
                    }
                    }
            }
        }
        stage('Cleanup Docker Images on Server') {
            steps {
                sshagent(credentials: [sshCredentials]) {
                    sh '''
                        ssh opc@158.179.219.214 <<EOF

                         # Eliminar las imágenes antiguas de Docker
                        docker image prune -a -f
EOF
                    '''
                }
            }
        }
    }
        post {
            failure {
                emailext(
                    to: '88davd@gmail.com',
                    subject: "Fallo en la Pipeline: ${currentBuild.fullDisplayName}",
                    body: """Algo salió mal con la Pipeline: ${env.BUILD_URL}
                    """,
                    attachLog: true
            )
            }
        }
}
