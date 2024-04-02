pipeline {
    agent any

    stages {
        stage('Trigger Spring_Docker/Spring_jenkins') {
            steps {
                script {
                    build(job: 'Spring_Docker/Spring_jenkins')
                }
            }
        }
    }
}