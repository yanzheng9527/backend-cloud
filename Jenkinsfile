pipeline {
  agent any
  stages {
    stage('install') {
      parallel {
        stage('install') {
          agent any
          environment {
            test = '38080'
            dev = '48080'
            prod = '28080'
          }
          steps {
            sh 'pwd'
            sh 'printenv'
            sh 'mvn clean install'
            sh 'ls'
          }
        }

        stage('error') {
          steps {
            input(message: 'select env', id: '1', ok: '2')
          }
        }

      }
    }

  }
}