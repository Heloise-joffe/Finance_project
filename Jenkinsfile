pipeline {
    agent any 
    stages {
        stage('Git clone & clean') {
            steps {
                bat "ant clean -f Finance_project/build.xml"
            }
        }
    }
}
