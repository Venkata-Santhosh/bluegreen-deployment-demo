node {
  stage("clone") {
    echo "cloning demo project"
    checkout scm

  }
  stage("build") {
    echo "building demo project"
    docker.image('maven:3.3.9-jdk-8-alpine').inside() {
                sh 'mvn -B clean install'
    }
  }
  stage("deploy") {
    echo "deploying demo project"
  }
}