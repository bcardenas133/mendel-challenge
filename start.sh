#!/bin/bash
mvn clean install
cp target/app-0.0.1-SNAPSHOT.jar docker
cd docker
docker-compose up