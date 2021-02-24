#!/bin/bash

# gradle build
./gradlew build

# build up
docker-compose up --build
