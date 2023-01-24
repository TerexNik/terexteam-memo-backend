# build the project
FROM maven:3 as jarfile
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

# the first stage of our build will extract the layers
FROM eclipse-temurin:17 as builder
WORKDIR workspace
COPY --from=jarfile /usr/src/app/target/memo-0.0.1.jar application.jar
RUN java -Djarmode=layertools -jar application.jar extract

# the second stage of our build will copy the extracted layers
FROM eclipse-temurin:17
WORKDIR workspace
COPY --from=builder /workspace/dependencies/ ./
RUN true
COPY --from=builder /workspace/spring-boot-loader/ ./
RUN true
COPY --from=builder /workspace/snapshot-dependencies/ ./
RUN true
COPY --from=builder /workspace/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
