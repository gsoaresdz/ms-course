<h1 align="center">Microsserviços Java com Spring Boot e Spring Cloud</h1>
<p align="center">
  <img alt="Github top language" src="https://img.shields.io/github/languages/top/gsoaresdz/ms-course?color=56BEB8">
  <img alt="Github language count" src="https://img.shields.io/github/languages/count/gsoaresdz/ms-course?color=56BEB8">
  <img alt="Repository size" src="https://img.shields.io/github/repo-size/gsoaresdz/ms-course?color=56BEB8">
</p>
<p align="center">
  <a href="#dart-sobre">Sobre</a> &#xa0; | &#xa0; 
  <a href="#memo-estrutura-do-projeto">Estrutura do Projeto</a> &#xa0; | &#xa0;
  <a href="#sparkles-features">Features</a> &#xa0; | &#xa0;
  <a href="#rocket-tecnologias">Tecnologias</a> &#xa0; | &#xa0;
  <a href="#white_check_mark-requerimentos">Requerimentos</a> &#xa0; | &#xa0;
  <a href="#checkered_flag-execução">Execução</a> &#xa0; | &#xa0;
  <a href="#memo-licença">Licença</a> &#xa0; | &#xa0;
  <a href="https://github.com/gsoaresdz" target="_blank">Autor</a>
</p>
<br>

## **:dart: Sobre**

Este projeto visa demonstrar a implementação de microsserviços em Java utilizando Spring Boot e Spring Cloud. O foco é na comunicação entre serviços, balanceamento de carga, tolerância a falhas, roteamento dinâmico e segurança.

## **:memo: Estrutura do Projeto**

O projeto é dividido em várias fases, cada uma abordando aspectos específicos do desenvolvimento de microsserviços:

- **Fase 1: Comunicação Simples, Feign, Ribbon**
    - Projeto **hr-worker**
    - Projeto **hr-payroll**
- **Fase 2: Eureka, Hystrix, Zuul**
    - Projeto **hr-eureka-server**
    - Configurações de clientes Eureka e tolerância a falhas
- **Fase 3: Configuração Centralizada**
    - Projeto **hr-config-server**
    - Clientes de configuração centralizada
- **Fase 4: Autenticação e Autorização**
    - Projeto **hr-user**
    - Projeto **hr-oauth**

## **:sparkles: Features**

:heavy_check_mark: **Comunicação entre microsserviços usando RestTemplate e Feign**

:heavy_check_mark: **Balanceamento de carga com Ribbon**

:heavy_check_mark: **Registro e descoberta de serviços com Eureka**

:heavy_check_mark: **Tolerância a falhas com Hystrix**

:heavy_check_mark: **Gateway de API com Zuul**

:heavy_check_mark: **Configuração centralizada com Spring Cloud Config**

:heavy_check_mark: **Autenticação e autorização com OAuth2 e JWT**

## **:rocket: Tecnologias**

As seguintes ferramentas foram usadas neste projeto:

- [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Cloud](https://spring.io/projects/spring-cloud)
- [H2 Database](https://h2database.com/html/main.html)
- [Feign](https://spring.io/projects/spring-cloud-openfeign)
- [Eureka](https://spring.io/projects/spring-cloud-netflix)
- [Hystrix](https://github.com/Netflix/Hystrix)
- [Zuul](https://github.com/Netflix/zuul)
- [OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)

## **:white_check_mark: Requerimentos**

Antes de iniciar :checkered_flag:, você precisa ter [Git](https://git-scm.com/) e [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) instalados.

## **:checkered_flag: Execução**

### **Checklist para baixar e executar o projeto pronto**

1. Instalar o JDK 11, configurar variáveis PATH e JAVA_HOME
2. Configurar IDE para utilizar Java 11
3. Importar projetos na IDE
4. Configurar credenciais do config server
5. Preparar Postman (coleção e ambiente)
6. Subir projetos na seguinte ordem:
    - Config server
    - Eureka server
    - Outros serviços

### **Fase 1: Comunicação simples, Feign, Ribbon**

### **1.1 Criar projeto hr-worker**

### **1.2 Implementar projeto hr-worker**

Script SQL:

```Sql
INSERT INTO tb_worker (name, daily_Income) VALUES ('Bob', 200.0);
INSERT INTO tb_worker (name, daily_Income) VALUES ('Maria', 300.0);
INSERT INTO tb_worker (name, daily_Income) VALUES ('Alex', 250.0);
```

application.properties:

```bash
spring.application.name=hr-worker
server.port=8001

# Database configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

### **1.3 Criar projeto hr-payroll**

application.properties:

```bash
spring.application.name=hr-payroll
server.port=8101
```

### **1.4 Implementar projeto hr-payroll (mock)**

### **1.5 RestTemplate**

### **1.6 Feign**

### **1.7 Ribbon load balancing**

Run configuration:

```bash
-Dserver.port=8002
```

### **Fase 2: Eureka, Hystrix, Zuul**

### **2.1 Criar projeto hr-eureka-server**

### **2.2 Configurar hr-eureka-server**

Porta padrão: 8761

Acessar o dashboard no navegador: `http://localhost:8761`

### **2.3 Configurar clientes Eureka**

Eliminar o Ribbon de hr-payroll:

- Dependência Maven
- Annotation no programa principal
- Configuração em application.properties

Atenção: aguardar um pouco depois de subir os microsserviços

### **2.4 Random port para hr-worker**

```bash
server.port=${PORT:0}

eureka.instance.instance-id=${spring.application.name}:${spring.application.instance_id:${random.value}}
```

Atenção: deletar as configurações múltiplas de execução de hr-worker

### **2.5 Tolerância a falhas com Hystrix**

### **2.6 Timeout de Hystrix e Ribbon**

Atenção: testar antes sem a annotation do Hystrix

```bash
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=60000
ribbon.ConnectTimeout=10000
ribbon.ReadTimeout=20000
```

### **2.7 Criar projeto hr-zuul-server**

### **2.8 Configurar hr-zuul-server**

Porta padrão: 8765

### **2.9 Random port para hr-payroll**

### **2.10 Zuul timeout**

Mesmo o timeout de Hystrix e Ribbon configurado em um microsserviço, se o Zuul não tiver seu timeout configurado, para ele será um problema de timeout. Então precisamos configurar o timeout no Zuul.

Se o timeout estiver configurado somente em Zuul, o Hystrix vai chamar o método alternativo no microsserviço específico.

### **Fase 3: Configuração centralizada**

### **3.1 Criar projeto hr-config-server**

### **3.2 Configurar projeto hr-config-server**

Quando um microsserviço é levantado, antes de se registrar no Eureka, ele busca as configurações no repositório central de configurações.

hr-worker.properties:

```bash
test.config=My config value default profile
```

hr-worker-test.properties:

```bash
test.config=My config value test profile
```

Teste:

```bash
http://localhost:8888/hr-worker/default
http://localhost:8888/hr-worker/test
```

### **3.3 hr-worker como cliente do servidor de configuração, profiles ativos**

No arquivo bootstrap.properties configuramos somente o que for relacionado com o servidor de configuração, e também o profile do projeto.

Atenção: as configurações do bootstrap.properties tem prioridade sobre as do application.properties

### **3.4 Actuator para atualizar configurações em runtime**

Atenção: colocar @RefreshScope em toda classe que possua algum acesso às configurações

### **3.5 Repositório Git privativo**

Atenção: reinicie a IDE depois de adicionar as variáveis de ambiente

### **Fase 4: Autenticação e autorização**

### **4.1 Criar projeto hr-user**

### **4.2 Configurar projeto hr-user**

### **4.3 Entidades User, Role e associação N-N**

### **4.4 Carga inicial do banco de dados**

```Sql
INSERT INTO tb_user (name, email, password) VALUES ('Nina Brown', 'nina@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');
INSERT INTO tb_user (name, email, password) VALUES ('Leia Red', 'leia@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');

INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
```

### **4.5 UserRepository, UserResource, Zuul config**

### **4.6 Criar projeto hr-oauth**

### **4.7 Configurar projeto hr-oauth**

### **4.8 UserFeignClient**

### **4.9 Login e geração do Token JWT**

Source -> Override -> configure(AuthenticationManagerBuilder)

Source -> Override -> authenticationManager()

Basic authorization = "Basic " + Base64.encode(client-id + ":" + client-secret)

### **4.10 Autorização de recursos pelo gateway Zuul**

### **4.11 Deixando o Postman top**

Variáveis:

- api-gateway: `http://localhost:8765`
- config-host: `http://localhost:8888`
- client-name: CLIENT-NAME
- client-secret: CLIENT-SECRET
- username: leia@gmail.com
- password: 123456
- token:

Script para atribuir token à variável de ambiente do Postman:

```bash
if (responseCode.code >= 200 && responseCode.code < 300) {
    var json = JSON.parse(responseBody);
    postman.setEnvironmentVariable('token', json.access_token);
}
```

### **4.12 Configuração de segurança para o servidor de configuração**

### **4.13 Configurando CORS**

Teste no navegador:

```bash
fetch("http://localhost:8765/hr-worker/workers", {
  "headers": {
    "accept": "*/*",
    "accept-language": "en-US,en;q=0.9,pt-BR;q=0.8,pt;q=0.7",
    "sec-fetch-dest": "empty",
    "sec-fetch-mode": "cors",
    "sec-fetch-site": "cross-site"
  },
  "referrer": "http://localhost:3000",
  "referrerPolicy": "no-referrer-when-downgrade",
  "body": null,
  "method": "GET",
  "mode": "cors",
  "credentials": "omit"
});
```

## **:memo: Licença**

Este projeto está sob licença do MIT. Para obter mais detalhes, consulte o arquivo [LICENSE](LICENSE).

Feito com :heart: by <a href="https://github.com/gsoaresdz" target="_blank">gsoaresdz</a>

&#xa0;

<a href="#top">De volta ao topo</a>
