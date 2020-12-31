FROM adoptopenjdk/openjdk11:jre-11.0.9.1_1-alpine

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE
COPY target/${JAR_FILE} cfgservice.jar
ENTRYPOINT ["java","-jar","cfgservice.jar"]
