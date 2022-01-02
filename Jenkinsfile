def project
def host
def port
pipeline {
   agent any
    parameters {
        choice(
            description: "选择部署的服务",
            name: "project",
            choices: ['ecommerce-user-web:ecommerce:80', 'ecommerce-product-service:ecommerce-product:8080', 'ecommerce-order-service:ecommerce-order:8080']
        )
    }

   environment {
           DOCKER_REG = "registry.cn-chengdu.aliyuncs.com/lura"
           DOCKER_REPOSITORY = "${DOCKER_REG}/${PROJECT}"
           DOCKER_IMAGE = "${DOCKER_REPOSITORY}:build-${BUILD_NUMBER}"
       }
   stages {
          stage("parse parameters") {
             steps {
                 script {
                     project = "${params.project}".split(":")[0]
                     host = "${params.project}".split(":")[1]
                     port = "${params.project}".split(":")[2]
                 }
             }
          }
          stage("dockerize") {
              environment {
                     DOCKER_REG = "registry.cn-chengdu.aliyuncs.com/lura"
                     DOCKER_REPOSITORY = "${DOCKER_REG}/${project}"
                     DOCKER_IMAGE = "${DOCKER_REPOSITORY}:build-${BUILD_NUMBER}"
              }
              steps {
                  withCredentials([usernamePassword(credentialsId: 'aliyun', passwordVariable: 'password', usernameVariable: 'username')]) {
                          sh "echo ${password} |sudo docker login --username=${username}  registry.cn-chengdu.aliyuncs.com --password-stdin"
                          sh "sudo docker build -t ${DOCKER_IMAGE} -f ${project}/Dockerfile ."
                          sh "sudo docker push ${DOCKER_IMAGE}"
                          sh "sudo docker rmi ${DOCKER_IMAGE}"
                  }
              }
          }

          stage('Deploy') {
              steps {
                  sh "export PROJECT=${project};export HOST=${host};export PORT=${port}; envsubst < deployment.yml"
                  sh "export PROJECT=${project};export HOST=${host};export PORT=${port}; envsubst < deployment.yml | sudo kubectl apply -f -"
             }
          }
     }
}
