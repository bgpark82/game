FROM openjdk:8-jre-alpine
WORKDIR app
EXPOSE 80
COPY ./gateway/build/libs/*.jar app.jar
CMD ["java","-jar","app.jar"]