FROM eclipse-temurin:17-jdk-alpine

ADD rest-service-complete-0.0.1-SNAPSHOT.jar webapp.jar

EXPOSE 8080

CMD ["java","-jar","webapp.jar"]
