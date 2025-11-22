@Library('my-shared-lib') _
import org.example.MyUtils

pipeline {
    agent any

    stages {
        stage('Use SharedLib') {
            steps {
                script {
                    def utils = new MyUtils(this)
                    utils.greet('Ebtehal')
                    utils.compileJava()
                    utils.runJava('HelloWorld')
                    utils.packageApp('HelloWorld.jar')
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}