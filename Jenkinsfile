pipeline {
    agent any 
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('git clean') {
            steps {
                bat "ant clean"
            }
        }
    }
}
