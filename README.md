# CRUD de Pizzaria

Este é um projeto de exemplo que implementa um CRUD (Create, Read, Update, Delete) básico para uma aplicação de pizzaria.

## Objetivo do Projeto

O objetivo deste projeto é fornecer um exemplo simples de como criar um sistema de gerenciamento de pedidos em uma pizzaria, utilizando operações CRUD para manipulação dos dados.

## Funcionalidades Implementadas

- **Criar Pizza:** Adiciona uma nova pizza ao sistema.
- **Listar Pizzas:** Lista todas as pizzas disponíveis no sistema.
- **Buscar Pizza por ID:** Busca uma pizza específica pelo seu ID.
- **Atualizar Pizza:** Atualiza as informações de uma pizza existente.
- **Excluir Pizza:** Remove uma pizza do sistema.

## Tecnologias Utilizadas

- **Spring Boot:** Framework Java para criar aplicativos web.
- **Hibernate:** Framework de mapeamento objeto-relacional para persistência de dados.
- **MySQL:** Sistema de gerenciamento de banco de dados relacional.
- **Maven:** Ferramenta de automação de compilação e gerenciamento de dependências.

## Configuração do Banco de Dados

- Certifique-se de ter o MySQL instalado e em execução.
- Crie um novo banco de dados chamado `pizzaria` no MySQL.
- As configurações de conexão com o banco de dados estão no arquivo `application.properties`.

## Executando o Projeto

1. Clone este repositório para o seu ambiente de desenvolvimento.
2. Importe o projeto em sua IDE preferida.
3. Execute a classe principal `Application`.
4. O servidor Spring Boot iniciará e estará pronto para aceitar solicitações.

## Endpoints da API

- **POST /pizzas:** Cria uma nova pizza. Envie um JSON com os detalhes da pizza no corpo da solicitação.
- **GET /pizzas:** Retorna todas as pizzas cadastradas.
- **GET /pizzas/{id}:** Retorna os detalhes de uma pizza específica pelo ID.
- **PUT /pizzas/{id}:** Atualiza os detalhes de uma pizza existente. Envie um JSON com os novos detalhes no corpo da solicitação.
- **DELETE /pizzas/{id}:** Exclui uma pizza do sistema com base no ID fornecido.
