# First stage: complete build environment
FROM maven:3.5.0-jdk-8-alpine AS builder
# add pom.xml and source code
ADD ./pom.xml pom.xml
ADD ./src src/
# package jar
RUN mvn clean package
# Second stage: minimal runtime environment
FROM openjdk:8-jre-alpine
# copy jar from the first stage
COPY --from=builder target/docx4jExample-0.0.1.jar docx4j-docker-demo.jar
# run jar
CMD ["java", "-jar", "docx4j-docker-demo.jar"]