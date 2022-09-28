FROM openjdk:8

ADD target/miniproject_1-phonebook_Application-0.0.1-SNAPSHOT.war DockerProject.war

ENTRYPOINT ["java", "-jar", "DockerProject.war"]

EXPOSE 8080


