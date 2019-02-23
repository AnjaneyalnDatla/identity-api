pipeline{
	agent any
	  stages {

		stage("BUILD"){
			steps{
				// skipping test temporarily. Unit and integration tests are run separately.
                sh './gradlew build -x test'
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


