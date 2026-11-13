# Click Book: sistema de hotelaria em microsserviços

Projeto em equipe da disciplina **Resolução de Problemas V** do curso de Engenharia de Software da
Universidade Federal do Pampa (Unipampa), campus Alegrete, desenvolvido pelo Grupo 01 entre 2021 e 2022.

O Click Book reúne o cadastro de hotéis, quartos e usuários, as reservas, o consumo e os serviços oferecidos aos hóspedes,
e sugestões de turismo, numa arquitetura de microsserviços com autenticação por token.

## Arquitetura

| Serviço | Papel |
|---|---|
| `discovery` | Registro e descoberta dos serviços (Eureka) |
| `gateway` | Porta de entrada única da API (Zuul) |
| `authentication` | Cadastro, login e emissão de tokens JWT |
| `CrudService` | Cadastro de hotéis, quartos, usuários e produtos |
| `reservaservice` | Reservas |
| `consumoservice` | Consumo dos hóspedes |
| `servicos` | Serviços oferecidos pelo hotel |
| `turismo` | Sugestões de turismo |
| `Front_end` | Interface web em React |

Os serviços conversam por HTTP (através do gateway) e por mensagens no **RabbitMQ**; cada um guarda os dados no **MySQL**.

**Tecnologias:** Java 11, Spring Boot 2.5, Spring Cloud Netflix (Eureka, Zuul), Spring Data JPA, RabbitMQ, MySQL, JWT, React 17, Axios.

## Organização da equipe

- Trabalho dividido por serviço, com uma branch por funcionalidade (`develop`, `authentication` etc.) e integração por
  **pull requests** revisados antes de entrar na branch principal.
- Minha parte (Denner Ramiro Ribeiro): **autenticação com JWT** (configuração do token, cadastro e login) e integração das
  branches de desenvolvimento.

## Como executar

Pré-requisitos: Java 11, Maven, Node.js, MySQL 8 e RabbitMQ rodando localmente.

1. Defina as variáveis de ambiente (as senhas não ficam mais no código):

   ```bash
   export MYSQL_USER=root
   export MYSQL_PASSWORD=sua_senha_do_mysql
   export JWT_SECRET=uma_chave_longa_e_aleatoria
   # opcionais (padrão do RabbitMQ local: guest/guest)
   export RABBITMQ_USER=guest
   export RABBITMQ_PASSWORD=guest
   ```

2. Suba os serviços na ordem: `discovery`, `gateway`, `authentication` e depois os demais:

   ```bash
   cd App-Hotel-RPIV-FixingMicroservi-os/Hotelaria/discovery && ./mvnw spring-boot:run
   ```

3. Suba o front-end:

   ```bash
   cd App-Hotel-RPIV-FixingMicroservi-os/Front_end && npm install && npm start
   ```

## Situação

Projeto acadêmico concluído; não recebe mais atualizações.
