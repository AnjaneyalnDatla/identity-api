# Using openjdk version 8 as base image
FROM openjdk:8

WORKDIR "/identity-api"

# Creating a temporary volume directory, this is used to store logs
VOLUME /tmp

# Retriving the latest jar from nexus and copying into the docker container
ADD http://206.189.197.225:8081/repository/a2nine-maven-jars/com/mapfre/identity-api/1.0.0/identity-api-1.0.0.jar identity-api-1.0.0.jar


# Running the app
ENTRYPOINT ["sh","-c","exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar identity-api-1.0.0.jar"]
