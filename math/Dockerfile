FROM openjdk:8-jre-alpine
WORKDIR app
EXPOSE 7001
RUN pwd
RUN ls -al
COPY * /
RUN ls -al
CMD ["java","-jar","app.jar"]