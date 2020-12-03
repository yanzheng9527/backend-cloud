pipeline {
  agent any
  stages {
    stage('install') {
      steps {
        sh 'pwd'
        sh 'printenv'
        sh 'mvn clean install'
        sh 'ls'
      }
    }

  }
}