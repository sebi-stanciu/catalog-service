# Catalog Service
This project aims to facilitate learning about the proper construction of cloud-native applications using __Spring framework__.

The application solely features a REST endpoint, with a GET request on the "/" path, which returns a straightforward __hello world__ message.

The goal of the application is to practice Docker containerization and employ Kubernetes(K8s) to execute the container within a pod.

### Run the application
The application can be run either using the IDE or with a gradle command:

`./gradlew bootRun`

### Run the application as a container
Out-of-the-box integration of Spring Boot with Cloud Native Buildpacks:

`./gradlew bootBuildImage` (containerize the app with Cloud Native Buildpacks)

`docker run --rm --name catalog-service -p 8080:8080 catalog-service:0.0.1-SNAPSHOT`

### Run the application on Kubernetes

Minikube typically utilizes the Docker Hub registry for image retrieval by default, lacking access to your locally stored images.

Manually import the image into the local cluster:

`minikube image load catalog-service:0.0.1-SNAPSHOT` 

K8s command to create a Deployment from a container image:

`kubectl create deployment catalog-service --image=catalog-service:0.0.1-SNAPSHOT`

By default, applications running in Kubernetes are not accessible.

Expose Catalog Service to the cluster through a Service resource by running the following command:

`kubectl expose deployment catalog-service --name=catalog-service --port=8080`

Then you can forward the traffic from a local port of your computer to the port exposed by the Service:

`kubectl port-forward service/catalog-service 8000:8080`
