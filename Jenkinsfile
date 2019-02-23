pipeline{
	agent any
	  stages {

		stage("BUILD"){
			steps{
				// skipping test temporarily. Unit and integration tests are run separately.
                sh './gradlew build -x test'
			}
		}
		// creating runnable jar
        stage('PUBLISH'){
        	environment {
				DOCKER_NEXUS_CREDS = credentials('nexus')
            }
            steps{
                sh './gradlew bootJar -x test'
                //sh './gradlew uploadBootArchives -x test'
                //commenting out temporarily
                //sh 'docker login --username $DOCKER_NEXUS_CREDS_USR --password $DOCKER_NEXUS_CREDS_PSW ${NEXUS_REPO_URL}'
				//sh 'docker push ${NEXUS_REPO_URL}/${JOB_NAME}:${BUILD_NUMBER}'
            }
        }
		stage("IMAGE"){
			steps{
					sh 'whoami'
					sh 'docker stop identity-api || true && docker rm identity-api || true docker rmi $(docker images |grep identity-api) || true'				
					sh 'docker build -t identity-api:${BUILD_NUMBER} .'
					
			}
		}
		stage("RUN"){
			steps{
					sh 'docker run -d --name identity-api -p 8085:8080 identity-api:${BUILD_NUMBER}'
			}
		}
	}
}


