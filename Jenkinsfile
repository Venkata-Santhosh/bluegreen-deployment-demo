node {
  stage("clone") {
    echo "cloning demo project"
    checkout scm

  }
  stage("build") {
    echo "building demo project"
    docker.image('node:7-alpine').inside {
            stage('Test') {
                sh 'node --version'
            }
        }
  }
  stage("deploy") {
    echo "deploying demo project"
  }
}