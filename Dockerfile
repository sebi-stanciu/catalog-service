FROM eclipse-temurin:17
WORKDIR workspace
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} catalog-service.jar
ENTRYPOINT ["java", "-jar", "catalog-service.jar"]

#❶ Ubuntu base image with the Eclipse Temurin distribution of the JRE pre-installed
#❷ Changes the current working directory to “workspace”
#❸ Builds argument specifying the location of the application JAR file in your project
#❹ Copies the application JAR file from the local machine into the image
#❺ Sets the container entry point to run the application