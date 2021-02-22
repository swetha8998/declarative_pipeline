pipeline{
agent any 
stages{
stage('git'){
  step{
git branch: 'branch1', url: 'https://github.com/swetha8998/declarative_pipeline.git'
  }
}
stage('Build'){
  step{
sh 'echo "in building stage"'
  }
}
stage('Approval'){
  step{
sh 'echo "in approval stage" '
  timeout(time: 15, unit: "MINUTES") {
    input message: 'Do you want to approve the deploy in production?', ok: 'Yes'
}
  }
}
stage('Deploy'){
  step{
sh 'echo "in deployment stage" '
 }
}
 }
 }
