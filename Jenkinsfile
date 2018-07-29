node {
  stage("clone") {
    echo "cloning demo project"
    checkout scm

  }
  stage("build") {
    echo "building demo project"
    withCredentials([usernameColonPassword(credentialsId: '64d2a5dd-641e-499b-9bfb-d2f0225bfed8', variable: 'hi')]) {
        // some block
        echo '$hi'
    }

  }
  stage("deploy") {
    echo "deploying demo project"
  }
}