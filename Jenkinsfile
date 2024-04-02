pipeline {
    
    agent any

    environment {
        PATH = "$PATH:/usr/local/bin:/opt/homebrew/bin/"
    }
    
    stages {
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage(‘Build’) {
            steps {
                sh 'docker-compose build --no-cache'
                sh 'docker-compose --project-name springboot up -d'
                sh 'docker image prune -fa'
            }
        }
    }
    post {
        always {
            junit testResults: 'target/surefire-reports/*.xml', skipPublishingChecks: true
        }
    }
}