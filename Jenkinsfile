pipeline {
  agent {
    node {
      label 'node1'
    }

  }
  stages {
    stage('install') {
      steps {
        sh 'mvn clean install'
      }
    }

  }
}