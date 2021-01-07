FROM openjdk:8-jre-alpine
WORKDIR app
EXPOSE 7001
RUN pwd
RUN ls -al
COPY ./math/build/libs/*.jar app.jar
CMD ["java","-jar","app.jar"]