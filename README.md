# Jenkins Shared Library (cicd-lab2-Ibtihal)

This repository is structured as a Jenkins Pipeline Shared Library. It includes:

- `vars/helloWorld.groovy`: A simple step you can call as `helloWorld('Name')`.
- `src/org/example/MyUtils.groovy`: A utility class you can instantiate and use from scripted blocks.
- `Jenkinsfile`: Example pipeline that demonstrates consuming the library utilities.
- `HelloWorld.java`: Sample Java file for build/run demonstration.

## Structure

```
vars/
  helloWorld.groovy
src/
  org/example/MyUtils.groovy
Jenkinsfile
HelloWorld.java
```

## Configure in Jenkins

1. Manage Jenkins → System → Global Pipeline Libraries → Add
2. Name: `my-shared-lib` (must match the `@Library('my-shared-lib')` usage)
3. Default version: `main` (or your chosen branch/tag)
4. Retrieval method: Modern SCM → Git → URL of this repository
5. Save

## Use in a consumer pipeline

Declarative Pipeline example:

```groovy
@Library('my-shared-lib') _
import org.example.MyUtils

pipeline {
  agent any
  stages {
    stage('Hello via vars step') {
      steps {
        helloWorld('YourName')
      }
    }
    stage('Using MyUtils') {
      steps {
        script {
          def utils = new MyUtils(this)
          utils.greet('YourName')
          // Example Java build/run if your repo has Java sources
          // utils.compileJava()
          // utils.runJava('HelloWorld')
          // utils.packageApp('HelloWorld.jar')
        }
      }
    }
  }
}
```

## Notes

- Shell steps: `MyUtils` uses `sh`, which requires a Linux/Unix agent. On Windows agents use `bat`, or update the library to switch based on `isUnix()`.
- Library repo vs consumer repo: This repository can serve as the Shared Library source. A separate application repository typically consumes the library using `@Library('my-shared-lib') _`.
- Optional folders: You can add `resources/` for template files and `test/` if you set up unit tests for library code.

## Quick test (this repo)

If you run this repository as a Jenkins job with the library configured to the same repo, the included `Jenkinsfile` demonstrates `MyUtils` usage.
