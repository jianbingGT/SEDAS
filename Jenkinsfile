#! groovy

pipeline {

  agent any

  stages{
        stage('Deploy'){
            steps{
                script{
                  docker.withRegistry('https://build.hdap.gatech.edu'){
                    def SedationAssist = docker.build("sedation-assistant-spring-boot:1.0", "-f Dockerfile .")
                    SedationAssist.push("latest")
                    }
                }
            }
        }
        // Define stage to notify rancher
        stage('Notify') {
            steps {
                script {
                    rancher confirm: true, credentialId: 'rancher-server', endpoint: 'https://rancher.hdap.gatech.edu/v2-beta', environmentId: '1a7', environments: '', image: 'build.hdap.gatech.edu/sedation-assistant-spring-boot:latest', ports: '', service: 'Sedation/sedation-assistant-spring-boot', timeout: 50
                }
            }
        }
    }
}
