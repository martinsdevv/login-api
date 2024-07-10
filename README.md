# Documentação da API de login/registro de usuários

## Introdução

Esta documentação descreve os endpoints da API e como utilizá-los, os parâmetros esperados e as respectivas respostas.

## Endpoints

### POST /auth/register

#### Descrição
Registra um usuário no banco de dados.

#### Respostas

- "200 OK": Sucesso no cadastro.
- "400": Parâmetros da requisição incorretos.
- "403 Forbidden": Não autorizado a fazer esta requisição.
- "404 not found": URL incorreta. Revise se está utilizando a URL e os endpoints corretos.

#### Exemplo de requisição
```http
http://localhost:8080
Content-Type: application/json

POST /auth/register

Corpo da requisição:
```

```json
{
    "name": "teste",
    "username": "teste_01",
    "email": "teste@gmail.com",
    "password": "1234"
}
```
Resposta esperada: 

``` json
{
    "username": "teste_01",
    "token": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
}
```

### POST /auth/login

#### Descrição
Faz login no sistema a partir de um usuário cadastrado no banco de dados.

#### Repostas

- "200 OK": Sucesso no login.
- "400 bad request": Informações de requisição incorretas.
- "403 Forbidden": Algo deu errado. Revisar:
    - Você possui permissão para fazer esta requisição? Revise as configurações de segurança.
    - Verifique se inseriu corretamente as informações de login
- "404 not found": URL incorreta. Revise se está utilizando a URL e os endpoints corretos.

#### Exemplo de requisição
```http
http://localhost:8080
Content-Type: application/json

POST /auth/login

Corpo da requisição:
```

```json
{
    "email": "teste@gmail.com",
    "password": "1234"
}
```
Resposta esperada: 

``` json
{
    "username": "teste_01",
    "token": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
}
```

### GET /user

#### Descrição
Retorna uma string "Hello World". Serve para testar se a autenticação foi bem sucedida.

#### Repostas

- "200 OK": Sucesso na requisição.
- "403 forbiden": Usuário não fez login
- "404 not found": URL incorreta. Revise se está utilizando a URL e os endpoints corretos.

#### Exemplo de requisição
```http
http://localhost:8080
Content-Type: application/json

GET /user

Corpo da requisição: Não Há

Inserir o token em Auth -> Type: Bearer Token
```

Resposta esperada: 

``` bash
Hello World
```
