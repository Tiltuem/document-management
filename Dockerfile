FROM openjdk:21 as builder
COPY target/*.jar document-management.jar
RUN java -Djarmode=layertools -jar document-management.jar extract

FROM openjdk:21
COPY --from=builder dependencies/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]