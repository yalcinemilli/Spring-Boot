FROM eclipse-temurin:17-jdk-jammy
WORKDIR /rauchboxapiv1
COPY target/rauchboxapiv1.jar /rauchboxapiv1/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
