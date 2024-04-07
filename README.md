# Microsserviços Java com Spring Boot e Spring Cloud

### Atenção: Versão Java 11 e Spring Boot 2.3.4

### Modelo conceitual:
![image](https://github.com/gsoaresdz/ms-course/assets/69989654/fbb8694e-3d24-4a8f-9547-bb3aa9d0bc44)

### Arquitetura implementada:
![image](https://github.com/gsoaresdz/ms-course/assets/69989654/e875ee4e-266a-4992-8739-47bcc33c8b82)

### Autenticação e Autorização com Oauth e JWT:
![image](https://github.com/gsoaresdz/ms-course/assets/69989654/b67f2d9a-6d1f-4cd2-a118-75068ba813a9)

### Checklist baixar e executar projeto pronto

- JDK 11, variáveis PATH e JAVA_HOME
- Configurar IDE para pegar Java 11
- Importar projetos na IDE
- Configurar credenciais do config server
- Preparar Postman (collection e environment)
- Subir projetos em ordem:
  - Config server
  - Eureka server
  - Outros

### Postman:

Variáveis:
- api-gateway: http://localhost:8765
- config-host: http://localhost:8888
- client-name: CLIENT-NAME
- client-secret: CLIENT-SECRET
- username: leia@gmail.com
- password: 123456
- token: 

Script para atribuir token à variável de ambiente do Postman:
```js
if (responseCode.code >= 200 && responseCode.code < 300) {
    var json = JSON.parse(responseBody);
    postman.setEnvironmentVariable('token', json.access_token);
}
```



