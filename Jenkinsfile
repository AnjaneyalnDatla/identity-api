pipeline{
	agent any
	  stages {

		   // cloning code into the container
        stage('CLONE'){
         environment {
                BITBUCKET_COMMON_CREDS = credentials('anj-bitbucket')
            }
            //removing old code if there is any, initializing new local repo and cloning into it.
            steps{
                sh 'rm -rf identity-api && git init && git clone https://$BITBUCKET_COMMON_CREDS_USR:$BITBUCKET_COMMON_CREDS_PSW@bitbucket.org/a2ninesrkr/identity-api.git'
                // setting up gradle wrapper as an exe
                sh 'chmod +x gradlew'
            }
        }
		stage("BUILD"){
			steps{
				// skipping test temporarily. Unit and integration tests are run separately.
                sh './gradlew build -x test'
			}
		}
		stage("IMAGE"){
			steps{
					sh 'whoami'
					sh 'docker stop ${JOB_NAME} || true && docker rm ${JOB_NAME} || true docker rmi $(docker images |grep ${JOB_NAME}) || true'				
					sh 'docker build -t ${JOB_NAME}:${BUILD_NUMBER} .'
					
			}
		}
		 // creating runnable jar
        stage('PUBLISH'){
        	environment {
				DOCKER_NEXUS_CREDS = credentials('nexus')
            }
            steps{
                sh './gradlew bootJar -x test'
                sh './gradlew uploadBootArchives -x test'
                //commenting out temporarily
                //sh 'docker login --username $DOCKER_NEXUS_CREDS_USR --password $DOCKER_NEXUS_CREDS_PSW ${NEXUS_REPO_URL}'
				//sh 'docker push ${NEXUS_REPO_URL}/${JOB_NAME}:${BUILD_NUMBER}'
            }
        }
		
		stage("RUN"){
			steps{
					sh 'docker run -d --name ${JOB_NAME} -p 8081:8080 ${NEXUS_REPO_URL}/${JOB_NAME}:${BUILD_NUMBER}'
			}
		}
	}
}


