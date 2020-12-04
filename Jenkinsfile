pipeline {
  agent any
  stages {
    stage('choose env') {
      steps {
        input(message: 'select env', id: '1', ok: '2')
      }
    }

  }
}