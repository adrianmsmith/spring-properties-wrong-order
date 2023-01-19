FROM maven:3-amazoncorretto-17
COPY . .
RUN mvn package
CMD ["java", "-cp", "higher-priority:lower-priority:target/spring-properties-wrong-order-1.0-SNAPSHOT-jar-with-dependencies.jar", "com.databasesandlife.propertieswrongorder.Main"]
