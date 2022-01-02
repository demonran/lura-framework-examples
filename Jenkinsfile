pipeline {
   agent any
    parameters {
        choice(
            description: "选择部署的服务",
            name: "project",
            choices: ['ecommerce-user-web', 'ecommerce-product-service', 'ecommerce-order-service']
        )
    }

   environment {
           DOCKER_REG = "registry.cn-chengdu.aliyuncs.com/lura"
           DOCKER_REPOSITORY = "${DOCKER_REG}/${PROJECT}"
           DOCKER_IMAGE = "${DOCKER_REPOSITORY}:build-${BUILD_NUMBER}"
       }
   stages {
         stage("dockerize") {
            steps {
                dir("${params.project}"){
                    withCredentials([usernamePassword(credentialsId: 'aliyun', passwordVariable: 'password', usernameVariable: 'username')]) {
                            sh 'echo ${password} |sudo docker login --username=${username}  registry.cn-chengdu.aliyuncs.com --password-stdin'
                            sh 'sudo docker build -t ${DOCKER_IMAGE} .'
                            sh 'sudo docker push ${DOCKER_IMAGE}'
                            sh 'sudo docker rmi ${DOCKER_IMAGE}'
                    }
                }
            }
        }


        stage('Deploy') {
            steps {
                sh "export PROJECT=${params.project} && envsubst < deployment.yml | sudo kubectl apply -f -"

           }
        }
   }
}
