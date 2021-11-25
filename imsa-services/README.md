# imsa-services


## run dev mode
mvn clean compile quarkus:dev

## package imsa-saga  
```mvn
 mvn clean package
```
## run imsa-services orchestrator
```java
 java -jar target/quarkus-app/quarkus-run.jar 
```
## package and push image on quay
```shell
mvn clean package -Dquarkus.container-image.build=true -Dquarkus.container-image.image=quay.io/mouachan/imsa-services:1.0.0-SNAPSHOT -Dquarkus.container-image.push=true 
```


## deploy imsa-services on openshift
```
oc apply -f ./manifest/imsa-services.yml 
```
## get order-services endpoint 
```
oc get route imsa-services --template={{.spec.host}}
```