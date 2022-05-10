FROM openjdk:11.0.15-alpine
COPY ./target/ppmtool-0.0.1-SNAPSHOT.jar ./
WORKDIR /
EXPOSE 9000
CMD ["java", "jar", "ppmtool-0.0.1-SNAPSHOT.jar"]
