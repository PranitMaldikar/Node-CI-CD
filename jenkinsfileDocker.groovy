pipeline {
    agent any
    
    tools {
        nodejs 'node21'
    }
    environment {
        SCANNER_HOME= tool 'sonar-scanner'
    }
    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/PranitMaldikar/3-Tier-Full-Stack.git'
            }
        }
        stage('Install Dependencies') {
            steps {
                sh "npm install"
            }
        }
        stage('Unit Tests') {
            steps {
                sh "npm test"
            }
        }
        stage('Trivy fs scan') {
            steps {
                sh "trivy fs --format table -o fs-report.html ."
            }
        }
        stage('SonarQube') {
            steps {
                
                withSonarQubeEnv('sonar') {
    
                sh "$SCANNER_HOME/bin/sonar-scanner -Dsonar.projectKey=Campground -Dsonar.projectName=Campground"
                
                }
                
            }
        }
        stage('Docker Build and Tag') {
            steps {
                script {
                    withDockerRegistry(credentialsId: 'docker-cred', toolName: 'docker') {
                        sh "docker build -t ppm5404/camp:latest ."
                    }
                }
            }
        }
        stage('Trivy Image scan') {
            steps {
                sh "trivy image --format table -o fs-report.html ppm5404/camp:latest"
            }
        }
        
        stage('Docker Push Image') {
            steps {
                script {
                    withDockerRegistry(credentialsId: 'docker-cred', toolName: 'docker') {
                        sh "docker push ppm5404/camp:latest"
                    }
                }
            }
        }
        stage('Docker Deploy to Dev') {
            steps {
                script {
                    withDockerRegistry(credentialsId: 'docker-cred', toolName: 'docker') {
                        sh "docker run -d -p 3000:3000 ppm5404/camp:latest"
                    }
                }
            }
        }
    
        
    }
    
}
