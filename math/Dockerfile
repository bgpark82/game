FROM openjdk:8-jre-alpine
WORKDIR app
EXPOSE 7001
COPY ./math/build/libs/*.jar app.jar
CMD ["java","-jar","app.jar"]