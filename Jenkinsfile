node {
  stage("Checkout") {
    echo "cloning demo project"
    checkout scm

  }
  stage("Build") {
    echo "building demo project"
     docker.image('maven').inside() {
                sh 'mvn -B clean install'
     }
  }
  stage("Deploy") {
    echo "deploying demo project"

  }
}