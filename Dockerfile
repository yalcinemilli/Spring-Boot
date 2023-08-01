FROM eclipse-temurin:17-jdk-jammy
VOLUME /tmp
WORKDIR /rauchboxapiv1
COPY target/rauchboxapiv1.jar /rauchboxapiv1//app.jar
EXPOSE 8080
#RUN mvn clean install
ENTRYPOINT ["java", "-jar", "app.jar"]
