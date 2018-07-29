node {
  stage("clone") {
    echo "cloning demo project"
    checkout scm

  }
  stage("build") {
    echo "building demo project"
     docker.image('maven').inside() {
                sh 'mvn -B clean install'
     }
  }
  stage("deploy") {
    echo "deploying demo project"
  }
}