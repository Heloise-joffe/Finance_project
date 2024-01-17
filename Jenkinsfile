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
        stage('Compilation & run'){
            steps {
                bat "ant run"
            }
        }
    }
}
