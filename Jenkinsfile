pipeline {
  agent any
  stages {
    stage('install') {
      steps {
        sh 'printenv'
        sh 'mvn clean install'
      }
    }

  }
}