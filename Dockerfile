
FROM maven:3.5.4-jdk-8 as builder
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN mvn package

FROM java:8-jdk
COPY --from=builder /usr/src/app/target/docker-spring-boot.war /usr/src/app/docker-spring-boot.war
EXPOSE 3000

CMD ["java", "-jar", "/usr/src/app/docker-spring-boot.war"]

