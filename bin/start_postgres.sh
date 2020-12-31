#! /bin/sh

docker run --name spring-microservice-postgres -e POSTGRES_PASSWORD=p0stgr@s -e POSTGRES_DB=eagle_eye_local  postgres
