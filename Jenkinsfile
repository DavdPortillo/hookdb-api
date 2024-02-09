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
        stage('Print current directory') {
            steps {
                sh 'ls'
            }
        }
        stage('Build and Push Docker Images') {
            steps {
                script {
                    def gitCommit = sh(script: 'git rev-parse HEAD', returnStdout: true).trim()
                    docker.withRegistry('https://registry-1.docker.io', DOCKER_CREDENTIALS) {
                        sh """
                docker buildx create --name multi-arch-builder --use
                docker buildx build --builder multi-arch-builder --platform linux/amd64,linux/arm64 -t davdportillo/winning-station:$gitCommit --build-arg GIT_COMMIT=$gitCommit --load .
                docker tag davdportillo/winning-station:$gitCommit davdportillo/winning-station:latest
                docker push davdportillo/winning-station:$gitCommit
                docker push davdportillo/winning-station:latest
                """
                    }
                }
            }
        }

        stage('Deploy to Server') {
            steps {
                sshagent(credentials: [sshCredentials]) {
                    sh '''
                    ssh opc@158.179.219.214 <<EOF
                    docker pull davdportillo/winning-station:latest
                    docker run -d -p 8080:8080 davdportillo/winning-station:latest
                    EOF
                    '''
                }
            }
        }
    }
}
