FROM maven:3-amazoncorretto-17
WORKDIR /app
COPY . .
RUN mvn clean package
CMD ["java", "-cp", "higher-priority:lower-priority:target/spring-properties-wrong-order-1.0-SNAPSHOT-jar-with-dependencies.jar", "com.databasesandlife.propertieswrongorder.Main"]
