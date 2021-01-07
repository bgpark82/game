FROM openjdk:8-jre-alpine
WORKDIR app
EXPOSE 7002
COPY ./score/build/libs/*.jar app.jar
CMD ["java","-jar","app.jar"]