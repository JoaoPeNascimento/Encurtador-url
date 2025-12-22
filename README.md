# Encurtador de URL

API REST desenvolvida em Java com Spring Boot para encurtar URLs. O sistema utiliza MongoDB para armazenamento e possui uma funcionalidade de expiração automática (TTL), onde os links gerados deixam de existir após 10 minutos.

## 🚀 Tecnologias Utilizadas

* **Java 21**
* **Spring Boot**
* **MongoDB**
* **Docker & Docker Compose**
* **Apache Commons Lang**

## 📋 Pré-requisitos

Para executar este projeto, você precisará ter instalado:

* [Java JDK 21](https://adoptium.net/)
* [Docker](https://www.docker.com/) e Docker Compose

## 🛠️ Como Executar

Siga os passos abaixo para colocar a aplicação no ar.

### 1. Iniciar o Banco de Dados

O projeto utiliza o Docker Compose para subir uma instância do MongoDB.

1.  Navegue até a pasta `docker`:
    ```bash
    cd docker
    ```
2.  Inicie o container:
    ```bash
    docker-compose up -d
    ```

Isso iniciará o MongoDB na porta `27017` com o usuário `admin` e senha `123`.

### 2. Executar a Aplicação

Volte para a raiz do projeto e execute o comando abaixo para iniciar a API:

**Linux / macOS:**
```bash
./mvnw spring-boot:run
```
**Windows:**
```bash
mvnw.cmd spring-boot:run
```
A aplicação será iniciada na porta 8080.

## 🔌 Documentação da API
### ✂️ Encurtar URL
Gera um link encurtado com um código aleatório de 5 a 10 caracteres.

- Endpoint: POST /shorten-url

- URL: http://localhost:8080/shorten-url

- Body (JSON):
```JSON
{
"url": "[https://www.exemplo.com.br/link-muito-longo](https://www.exemplo.com.br/link-muito-longo)"
}
```

Resposta de Sucesso (200 OK):

```JSON
{
"url": "http://localhost:8080/Xy7z9"
}
```
- Nota: O link gerado expirará automaticamente após 10 minutos.

### 🔗 Redirecionar
Acessar o link encurtado redireciona o usuário para a URL original.

- Endpoint: GET /{id}

- URL Exemplo: http://localhost:8080/Xy7z9

- Comportamento:

    - Sucesso (302 Found): Redireciona para o site original.

    - Erro (404 Not Found): Se o ID não existir ou o link já tiver expirado.

## ⚙️ Configuração
As configurações do banco de dados estão definidas no arquivo src/main/resources/application.properties. Caso precise alterar as credenciais ou o host do banco, edite este arquivo:

```Properties

spring.mongodb.host=localhost
spring.mongodb.port=27017
spring.mongodb.database=urlshortener
spring.mongodb.username=admin
spring.mongodb.password=123
```
