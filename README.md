# Workshop Spring Boot + MongoDB

Repositório de exemplo para um workshop/prática com Spring Boot e MongoDB.

> **Objetivo:** Projeto didático que mostra como criar uma API REST com Spring Boot usando MongoDB como banco de dados, com operações CRUD para entidade `User`.

---

## Conteúdo deste README

* Visão geral do projeto
* Pré-requisitos
* Estrutura do projeto
* Como rodar localmente
* Configurações do MongoDB
* Endpoints principais
* Comandos úteis (Maven)
* Testes
* Como contribuir
* Licença

---

## Visão geral

Este projeto contém uma aplicação Spring Boot que expõe uma API REST para gerenciar usuários. Foi pensado como material para estudo e prática — fácil de entender e extender.

## Pré-requisitos

* Java 17 (ou versão compatível usada no `pom.xml`)
* Maven 3.6+
* MongoDB (local ou remoto)
* Git (para clonar o repositório)

## Estrutura do repositório

Padrão Maven com fontes em `src/` e arquivos de configuração:

```
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/       # código-fonte Java
│   │   └── resources/  # application.properties / application.yml
│   └── test/           # testes automatizados
├── mvnw
├── pom.xml
└── .gitignore
```

> Observação: ajuste os caminhos e nomes das packages conforme a organização do seu código.

## Como rodar localmente

1. Clone o repositório:

```bash
git clone https://github.com/JeffersonTeodoro/workshop-spring-boot-mongodb.git
cd workshop-spring-boot-mongodb
```

2. Configure o MongoDB (ex.: rodando localmente na porta padrão 27017) ou a URL de conexão no arquivo `src/main/resources/application.properties` ou `application.yml`.

Exemplo mínimo em `application.properties`:

```
spring.data.mongodb.uri=mongodb://localhost:27017/workshop
server.port=8080
```

3. Build e execute com Maven:

```bash
./mvnw clean package
./mvnw spring-boot:run
```

Ou executar o jar gerado:

```bash
java -jar target/*.jar
```

A API ficará disponível por padrão em `http://localhost:8080`.

## Configurações do MongoDB

* Se estiver usando MongoDB Atlas ou outro serviço remoto, substitua `spring.data.mongodb.uri` por sua string de conexão completa.
* Para ambientes de desenvolvimento, usar um banco separado (ex.: `workshop-dev`) evita poluir dados de produção.

## Endpoints principais (exemplos)

> Estes endpoints são exemplos — verifique as controllers reais no código do projeto para confirmar rotas e modelos.

* `GET /users` — listar todos os usuários
* `GET /users/{id}` — obter usuário por id
* `POST /users` — criar novo usuário (JSON no body)
* `PUT /users/{id}` — atualizar usuário
* `DELETE /users/{id}` — deletar usuário

Exemplo `curl` para criar um usuário:

```bash
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"name":"João","email":"joao@example.com"}'
```

## Comandos úteis (Maven)

* `./mvnw clean install` — build e testes
* `./mvnw spring-boot:run` — rodar aplicação no modo desenvolvimento
* `./mvnw test` — executar testes

## Testes

Verifique a pasta `src/test` para exemplos de testes unitários e de integração. Configure um perfil de testes se for necessário usar um banco embutido ou mock de MongoDB.

## Como contribuir

1. Faça um fork deste repositório.
2. Crie uma branch com a feature/bugfix: `git checkout -b feat/minha-feature`.
3. Commit e push: `git commit -m "Minha contribuição" && git push origin feat/minha-feature`.
4. Abra um Pull Request descrevendo as mudanças.

## Boas práticas / Sugestões de melhorias

* Adicionar `DTOs` e `Mapper` (ex.: MapStruct) para separar camadas.
* Tratar exceções com `@ControllerAdvice` para respostas padronizadas.
* Adicionar validação com `javax.validation` (ex.: `@Valid`).
* Configurar profiles (`application-dev.yml`, `application-prod.yml`).
* Adicionar Swagger / OpenAPI para documentação automática das APIs.

## Licença

Coloque aqui a licença do projeto (ex.: MIT). Se você não quiser uma licença, remova esta seção.

---
