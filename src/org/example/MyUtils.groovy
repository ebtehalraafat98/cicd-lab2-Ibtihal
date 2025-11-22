package org.example

class MyUtils implements Serializable {

    def steps  // Jenkins pipeline context

    MyUtils(steps) {
        this.steps = steps
    }

    def compileJava() {
        steps.echo "Compiling Java files..."
        steps.sh 'javac *.java'
    }

    def runJava(String mainClass) {
        steps.echo "Running Java program..."
        steps.sh "java ${mainClass}"
    }

    def packageApp(String jarName = 'app.jar') {
        steps.echo "Packaging application into ${jarName}..."
        steps.sh "jar cf ${jarName} *.class"
    }

    def greet(String name = 'Ebtehal') {
        steps.echo "Hello, ${name}! This message is from MyUtils.groovy."
    }
}