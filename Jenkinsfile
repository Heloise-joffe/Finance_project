pipeline {
    agent any 
    stages {
        stage('Git clone & clean') {
            steps {
                bat "git clone https://github.com/Heloise-joffe/Finance_project.git" 
                bat "ant clean -f Finance_project/build.xml"
            }
        }
    }
}
