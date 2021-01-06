FROM openjdk:8-jre-alpine
EXPOSE 7001
RUN pwd
RUN ls -al
COPY /build/libs/*.jar app.jar
CMD ["java","-jar","app.jar"]