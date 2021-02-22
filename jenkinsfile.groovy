pipeline{
agent any 
stages{
stage('git'){
  steps{
git branch: 'branch1', url: 'https://github.com/swetha8998/declarative_pipeline.git'
  }
}
stage('Build'){
  steps{
sh 'echo "in building stage"'
  }
}
stage('Approval'){
  steps{
sh 'echo "in approval stage" '
  timeout(time: 15, unit: "MINUTES") {
    input message: 'Do you want to approve the deploy in production?', ok: 'Yes'
}
  }
}
stage('Deploy'){
  steps{
sh 'echo "in deployment stage" '
 }
}
 }
 }
