# Mendel Java Challenge Rest API.

![image](https://bookface-images.s3.amazonaws.com/logos/6fcbf5ae5690bccf19db87fc25fe21d5b2a12c81.png)

**The main technologies used to implement this Rest API are:**
- Java 17.
- SpringBoot.
- MongoDB.
- Docker

Please make sure you have Java 17, Docker and MongoDB installed.

**Running this Rest API:**

In order to run this Rest API in your machine, you need to follow next steps:
1. Clone this repository
```
$ git clone https://github.com/bcardenas133/mendel-challenge.git
```
2. Run ./start.sh script in root path.


3. Now your application would be running on docker.

This is a postman collection you could use to interact with the app:

https://www.getpostman.com/collections/ade7123cbdfcbe08c334


**FUTURE IMPROVEMENTS**

There are different technologies which could be implemented in order to accomplish with micro-services architecture best practices:
- Since there is an endpoint which is retrieving certain information, that would be a great idea to implement a cache so we could improve response time.
- We could make use of a message broker in order to establish an asynchronous communication between others components that could be hitting this api endpoint/s in the future.
- In case this application receives considerable amount of traffic and maybe some of the external systems that would be queried by the application in the future could be not available, we could implement a circuit-breaker in order to be fault-tolerant and keep instances healthy. With a circuit-breaker we could detect that external systems are not available and configure a fallback url to return any appropiate response.

## Questions

Please, don't hesistate to contact me in case you have any questions.

* [bcardenas133@gmail.com](bcardenas133@gmail.com)
