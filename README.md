# Criptografia Backend

  Este é um projeto em Spring Boot desenvolvido como um dos exercícios para backend propostos [nesse repositório](https://github.com/backend-br/desafios/tree/master/cryptography), onde deve-se criar uma API que guarde dados sensíveis em um banco de dados de forma criptografada sem afetar a resposta dos usuários
## Screenshots

Objeto retornado pela API 

![Captura de tela 2024-03-06 091807](https://github.com/Svaan1/backend-challenge-cryptography/assets/86506395/2d11be9d-b294-40db-8f23-12ceddcfb95d)

Mesmo objeto salvo no banco de dados

![Captura de tela 2024-03-06 091826](https://github.com/Svaan1/backend-challenge-cryptography/assets/86506395/64e3d01a-c0c5-4065-8693-be972220761f)

## Uso
### Pré-requisitos  
Antes de começar, certifique-se de ter instalado em sua máquina:  

- Java JDK (20.0.2)  
### Configuração do Ambiente  
1. Clone este repositório em sua máquina local  
2. Preencha os campos necessários em `application.properties`  
### Executando o Projeto  
1. Compile o projeto usando o Maven  
```
mvn clean install
```
2. Execute o aplicativo
```
mvn spring-boot:run
````

O aplicativo estará disponível em `localhost:8080` após a inicialização.
