
# mp-news-feed
MicroProfile example using Helidon

It´s a simple news feed where you post news and retrieve them.

## Build

```
mvn package
```

## Start the application

```
java -jar target/mp-newsfeed.jar
```

## Exercise the application

```
curl -X GET http://localhost:8080/greet
{"message":"Hello World!"}

curl -X GET http://localhost:8080/greet/Joe
{"message":"Hello Joe!"}

curl -X PUT http://localhost:8080/greet/greeting/Hola
{"gretting":"Hola"}

curl -X GET http://localhost:8080/greet/Jose
{"message":"Hola Jose!"}
```

## Build the Docker Image

```
docker build -t mp-newsfeed target
```

## Start the application with Docker

```
docker run --rm -p 8080:8080 mp-newsfeed:latest
```

Exercise the application as described above

## Deploy the application to Kubernetes

```
kubectl cluster-info                         # Verify which cluster
kubectl get pods                             # Verify connectivity to cluster
kubectl create -f target/app.yaml               # Deploy application
kubectl get service mp-newsfeed  # Verify deployed service
```
