# Gerenciamento de Tarefas

Essa é uma aplicação back-end para gerenciamento de tarefas.

# Funcionalidades

### Tarefa:
  - Criar uma nova tarefa (POST): Permite a criação de uma nova tarefa.
  - Listar todas as tarefas (GET):  Permite listar todas as tarefas.
  - Atualizar uma tarefa existente (PUT):  Permite atualizar uma tarefa já cadastrada.
  - Deletar uma tarefa (DELETE):  Permite deletar uma tarefa.
  - Buscar tarefas por status(concluída/não concluída) (GET):  Permite buscar tarefas de acordo como o status indicado.
  - Mudar status da tarefa (PATCH):  Permite mudar o status de uma tarefa.

# Tecnologias Utilizadas
  
  - Java 17
  - Spring Boot
  - Spring Boot WebFlux
  - MongoDB
  - Docker
  - Postman

 ## Instalação da aplicação

 Primeiramente, faça o clone do repositório:
  ```
  https://github.com/wanderson648/management-task-api.git
  ```
Feito isso, acesse o projeto:
```
cd gerenciamento-tarefas
```
É preciso compilar o código e baixar as dependências do projeto:
```
mvn clean package
```
Finalizado esse passo, vamos iniciar a aplicação:
```
mvn spring-boot:run
```
Pronto. A aplicação está disponível em  http://localhost:8080

# Setup da aplicação com docker

## Pré-requisito

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:
```
Java 
Docker 
Maven 
```
Com o projeto clonado, acesse o diretório do projeto
```
cd gerenciamento-tarefas
```
Feito isso, abra o terminal na pasta do projeto e digite o comando para rodar a aplicação
```
docker run -p 8080:8080 spring-boot-task-management:1.1
```
A aplicação rodando, estará disponível em http://localhost:8080

# APIs

Segue abaixo as Endpoints disponíveis no projeto:

 - /task-api/v1/task (POST)
 - Espera atributos para criar uma tarefa, exemplo:
    ```
    {
      "name":"tarefa",
      "description": "descricao tarefa"
    }
    ```
 - /task-api/v1/task (GET)
 - /task-api/v1/task/{taskId} (PUT)
 - Espera atributos para atualizar uma tarefa existente, exemplo:
    ```
    {
      "name":"tarefa",
      "description": "descricao tarefa"
    }
    ```
 - /task-api/v1/task/{taskId} (DELETE)
 - /task-api/v1/task/status (GET)
 - Espera que seja passado via params a key (status) e value para buscar uma tarefa pelo status, exemplo:
    ```
    Query Params
      [x] key      Value
      [x] status = completed/not_completed
    ```
 - /task-api/v1/task/status/{taskId} (PATCH)

     
















