FROM openjdk:latest
ENV MYSQL_ROOT_PASSWORD example
COPY ./target/seMethods.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "seMethods.jar", "db:3306"]
