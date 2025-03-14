FROM openjdk:21-jdk-slim as build

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
COPY --from=build /app/target/fruitvegetableshop-0.0.1-SNAPSHOT.jar /app/fruitvegetableshop.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/fruitvegetableshop.jar"]
