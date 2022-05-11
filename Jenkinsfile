pipeline {
    agent any
    	    environment {
                registry1 = "simranrawat/react_client"
                registry2 = "simranrawat/spring_server"
                registryCredential = 'dockerhub'
                dockerImage = ''
            }

    stages {
        stage("Git clone") {
            steps {
                git url: 'https://github.com/simranrawat/DevOps_ppmtool.git', branch: 'master', credentialsId: 'GitCredential' 
            }
        }
        stage("Frontend prerequisite installations") {
            steps{
                dir('ppmtool-react-client'){
                    sh 'npm install'
                }
            }
        }

        stage('Maven Build'){
            steps {
                dir('PPMToolFullStack'){

                    sh 'mvn clean install'

                }
            }
        }

        stage('Building the images'){
            steps {
                dir('ppmtool-react-client'){
                    sh 'docker build -t simranrawat/react_client .'
                }
                dir('PPMToolFullStack'){
                    sh 'docker build -t simranrawat/spring_server .'
                }
            }
        }

        stage('Pushing the images to DockerHub'){
            steps{
                script {
                    withDockerRegistry([ credentialsId: registryCredential, url: "" ])
                    {sh 'docker push $registry1'}

                    withDockerRegistry([ credentialsId: registryCredential, url: "" ])
                    {sh 'docker push $registry2'}
                }
            }
        }

        stage('Ansible Deploy') {
             steps {
                  ansiblePlaybook colorized: true,credentialsId: "container_access_key", disableHostKeyChecking: true, installation: 'Ansible', inventory: 'inventory', playbook: 'play.yml'
             }
        }
    }
}
