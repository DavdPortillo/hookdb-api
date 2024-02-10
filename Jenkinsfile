pipeline {
    agent any

    environment {
        sshCredentials = 'ORACLE-SERVER'
        DOCKER_CREDENTIALS = 'API-DOCKER'
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
        stage('Build and Push Docker Images') {
            steps {
                script {
                    String gitCommit = sh(script: 'git rev-parse HEAD', returnStdout: true).trim()
                    docker.withRegistry('https://hub.docker.com', DOCKER_CREDENTIALS) {
                        sh """
                            docker buildx create --name multi-arch-builder --use
                            docker buildx build --builder multi-arch-builder --platform linux/amd64,linux/arm64 -t davdportillo/winning-station:$gitCommit --build-arg GIT_COMMIT=$gitCommit --push .
                            docker buildx imagetools create --tag davdportillo/winning-station:latest davdportillo/winning-station:$gitCommit
                            docker buildx imagetools push davdportillo/winning-station:$gitCommit
                            docker buildx imagetools push davdportillo/winning-station:latest
                            docker buildx rm multi-arch-builder
                        """
                    }
                }
            }
        }

        stage('Deploy to Server') {
            steps {
                withCredentials([usernamePassword(credentialsId: '2e9cf125-4d0e-4899-bef2-66231d695e96', passwordVariable: 'GIT_PASSWORD', usernameVariable: 'GIT_USERNAME')]) {
                    sshagent(credentials: [sshCredentials]) {
                        sh '''
                    ssh opc@158.179.219.214 <<EOF
                    git clone https://$GIT_USERNAME:$GIT_PASSWORD@github.com/DavdPortillo/WinningStation.git
                    mv WinningStation/docker-compose.yml .
                    rm -rf WinningStation
                    docker compose pull
                    docker compose up -d
EOF
                    '''
                    }
                }
            }
        }
    }
}
