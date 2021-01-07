FROM openjdk:8-jre-alpine
WORKDIR app
EXPOSE 8761
COPY ./eureka-server/build/libs/*.jar app.jar
CMD ["java","-jar","app.jar"]