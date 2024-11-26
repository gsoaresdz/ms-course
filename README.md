<h1 align="center">Java Microservices with Spring Boot and Spring Cloud</h1> <p align="center"> <img alt="Github top language" src="https://img.shields.io/github/languages/top/gsoaresdz/ms-course?color=56BEB8"> <img alt="Github language count" src="https://img.shields.io/github/languages/count/gsoaresdz/ms-course?color=56BEB8"> <img alt="Repository size" src="https://img.shields.io/github/repo-size/gsoaresdz/ms-course?color=56BEB8"> </p> <p align="center"> <a href="#dart-about">About</a> &#xa0; | &#xa0; <a href="#memo-project-structure">Project Structure</a> &#xa0; | &#xa0; <a href="#sparkles-features">Features</a> &#xa0; | &#xa0; <a href="#rocket-technologies">Technologies</a> &#xa0; | &#xa0; <a href="#white_check_mark-requirements">Requirements</a> &#xa0; | &#xa0; <a href="#checkered_flag-execution">Execution</a> &#xa0; | &#xa0; <a href="#memo-license">License</a> &#xa0; | &#xa0; <a href="https://github.com/gsoaresdz" target="_blank">Author</a> </p> <br>

## **:dart: About**

This project demonstrates the implementation of microservices in Java using Spring Boot and Spring Cloud. The focus is on communication between services, load balancing, fault tolerance, dynamic routing, and security.

## **:memo: Project Structure**

The project is divided into several phases, each addressing specific aspects of microservices development:

- **Phase 1: Simple Communication, Feign, Ribbon**
    - Project **hr-worker**
    - Project **hr-payroll**
- **Phase 2: Eureka, Hystrix, Zuul**
    - Project **hr-eureka-server**
    - Configuration of Eureka clients and fault tolerance
- **Phase 3: Centralized Configuration**
    - Project **hr-config-server**
    - Centralized configuration clients
- **Phase 4: Authentication and Authorization**
    - Project **hr-user**
    - Project **hr-oauth**

## **:sparkles: Features**

:heavy_check_mark: **Service communication using RestTemplate and Feign**

:heavy_check_mark: **Load balancing with Ribbon**

:heavy_check_mark: **Service registration and discovery with Eureka**

:heavy_check_mark: **Fault tolerance with Hystrix**

:heavy_check_mark: **API Gateway with Zuul**

:heavy_check_mark: **Centralized configuration with Spring Cloud Config**

:heavy_check_mark: **Authentication and authorization with OAuth2 and JWT**

## **:rocket: Technologies**

The following tools were used in this project:

- [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Cloud](https://spring.io/projects/spring-cloud)
- [H2 Database](https://h2database.com/html/main.html)
- [Feign](https://spring.io/projects/spring-cloud-openfeign)
- [Eureka](https://spring.io/projects/spring-cloud-netflix)
- [Hystrix](https://github.com/Netflix/Hystrix)
- [Zuul](https://github.com/Netflix/zuul)
- [OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)

## **:white_check_mark: Requirements**

Before starting :checkered_flag:, ensure you have [Git](https://git-scm.com/) and [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) installed.

## **:checkered_flag: Execution**

### **Checklist to download and run the project**

1. Install JDK 11, configure PATH and JAVA_HOME variables
2. Set your IDE to use Java 11
3. Import projects into the IDE
4. Configure credentials for the config server
5. Prepare Postman (collection and environment)
6. Start the projects in the following order:
    - Config server
    - Eureka server
    - Other services

### **Phase 1: Simple Communication, Feign, Ribbon**

### **1.1 Create the hr-worker project**

### **1.2 Implement the hr-worker project**

SQL script:

```sql
INSERT INTO tb_worker (name, daily_Income) VALUES ('Bob', 200.0);
INSERT INTO tb_worker (name, daily_Income) VALUES ('Maria', 300.0);
INSERT INTO tb_worker (name, daily_Income) VALUES ('Alex', 250.0);
```

application.properties:

```
spring.application.name=hr-worker
server.port=8001

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

### **1.3 Create the hr-payroll project**

application.properties:

```
spring.application.name=hr-payroll
server.port=8101
```

### **1.4 Implement hr-payroll project (mock)**

### **1.5 RestTemplate**

### **1.6 Feign**

### **1.7 Ribbon Load Balancing**

Run configuration:

```bash
-Dserver.port=8002
```

### **Phase 2: Eureka, Hystrix, Zuul**

### **2.1 Create hr-eureka-server project**

### **2.2 Configure hr-eureka-server**

Default port: 8761

Access the dashboard at **`http://localhost:8761`**

### **2.3 Configure Eureka clients**

Remove Ribbon from hr-payroll:

- Maven dependency
- Annotation in the main program
- Configuration in application.properties

Wait a moment after starting the microservices to ensure proper registration.

### **2.4 Random port for hr-worker**

```
server.port=${PORT:0}

eureka.instance.instance-id=${spring.application.name}:${spring.application.instance_id:${random.value}}
```

Delete multiple execution configurations for hr-worker.

### **2.5 Fault tolerance with Hystrix**

### **2.6 Hystrix and Ribbon Timeout**

```
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=60000
ribbon.ConnectTimeout=10000
ribbon.ReadTimeout=20000
```

### **2.7 Create hr-zuul-server project**

### **2.8 Configure hr-zuul-server**

Default port: 8765


### **Phase 3: Centralized Configuration**

### **3.1 Create hr-config-server project**

### **3.2 Configure hr-config-server project**

When a microservice starts, it fetches configuration from the centralized repository before registering with Eureka.


### **Phase 4: Authentication and Authorization**

### **4.1 Create hr-user project**

### **4.2 Configure hr-user project**

### **4.3 User, Role entities and N-N association**

SQL script for initial data:

```sql
INSERT INTO tb_user (name, email, password) VALUES ('Nina Brown', 'nina@gmail.com', '$2a$10$...');
INSERT INTO tb_user (name, email, password) VALUES ('Leia Red', 'leia@gmail.com', '$2a$10$...');

INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
```

### **4.4 Configure OAuth and JWT**

Use Postman to test login and authorization.


## **:memo: License**

This project is under the MIT license. For more details, see the [LICENSE](LICENSE) file.

Made with :heart: by <a href="https://github.com/gsoaresdz" target="_blank">gsoaresdz</a>

<a href="#top">Back to top</a>
