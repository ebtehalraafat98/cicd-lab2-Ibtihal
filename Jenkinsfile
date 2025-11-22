pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '3'))
    }

    parameters {
        string(name: 'ENVIRONMENT', defaultValue: 'dev', description: 'Target environment')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/ebtehalraafat98/cicd-lab2-Ibtihal.git'
            }
        }

        stage('Compile') {
            steps {
                sh 'echo "Step 1: Compiling Java project..."'
                sh 'javac HelloWorld.java'
            }
        }

        stage('Test') {
            steps {
                sh 'echo "Step 2: Running tests..."'
                sh 'java HelloWorld'
            }
        }

        stage('Package') {
            steps {
                sh 'echo "Step 3: Packaging application..."'
                sh 'jar cf HelloWorld.jar HelloWorld.class'
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
