# Mendel Java Challenge Rest API.

![image](https://tenpo.cl/blog/wp-content/uploads/2021/01/logo-tenpo-white-1.png)

This is a REST API that exposes endpoints which allows user to:
- Sing Up
- Sign In
- Sign Out
- Add two numbers
- Get api calls history

**The main technologies used to implement this Rest API are:**
- Java 15.
- SpringBoot.
- PostgreSQL.
- JWT (lib used for authentication logic)
- Docker

Please make sure you have Java 15, Docker and PostgreSQL installed.

**Running this Rest API:**

In order to run this Rest API in your machine, you need to follow next steps:
1. Clone this repository
```
$ git clone https://github.com/bcardenas133/tenpo-challenge.git
```
2. Generate JAR file using the next maven command on root project folder:
```
$ mvn clean install
```
3. Go to src/main/docker folder to run this project on docker through this command:
```
$ docker-compose up
```
4. Now your application would be running on docker.
5. Go to http://localhost:8080/swagger-ui.html in order to interact with all exposed api endpoints. You could also use this postman collection link: https://www.getpostman.com/collections/b4d46fed2da040e2a922



**FUTURE IMPROVEMENTS**

There are different technologies which could be implemented in order to accomplish with micro-services architecture best practices:
- Since there is an endpoint which is retrieving certain information, that would be a great idea to implement a cache so we could improve response time.
- We could make use of a message broker in order to establish an asynchronous communication between others components that could be hitting this api endpoint/s in the future.
- In case this application receives considerable amount of traffic and maybe some of the external systems that would be queried by the application in the future could be not available, we could implement a circuit-breaker in order to be fault-tolerant and keep instances healthy. With a circuit-breaker we could detect that external systems are not available and configure a fallback url to return any appropiate response.

## Questions

Please, don't hesistate to contact me in case you have any questions.

* [bcardenas133@gmail.com](bcardenas133@gmail.com)
