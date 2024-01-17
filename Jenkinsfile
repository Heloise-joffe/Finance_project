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
        stage('Compilation & jar'){
            steps {
                bat "ant jar"
            }
        }
        stage('Tests'){
            steps {
                bat "ant junitreport"
                bat "ant mutation_test"
            }
        }
        stage('Bugs'){
            steps {
                bat "ant spotbugs"
            }
        }
        stage('Metrics'){
            steps {
                bat "ant metrics"
            }
        }
    }
}
