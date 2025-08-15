
# Projeto API de Tarefas com Spring Boot

Bem-vindo à API de Tarefas, um serviço RESTful para gerenciar tarefas. Este projeto foi desenvolvido utilizando o framework **Spring Boot** para demonstrar uma arquitetura em camadas e o uso de ferramentas essenciais no ecossistema Java para a construção de APIs.

---

## 📖 Sobre o Projeto

Esta API implementa um sistema de **CRUD (Criar, Ler, Atualizar, Deletar)** completo para a entidade `Tarefa`. A aplicação segue um design em camadas (Controller, Service, Repository) para garantir a separação de responsabilidades. Para a persistência de dados, utiliza o **Spring Data JPA** e um banco de dados **H2** em memória, ideal para o desenvolvimento e testes. A conversão de objetos entre a camada da API e a camada de serviço é feita de forma automatizada com o **ModelMapper**.

### Funcionalidades Principais

* **API RESTful:** Endpoints bem definidos para operações CRUD em tarefas.
* **Arquitetura em Camadas:** Separação clara entre a interface web (`Controller`), a lógica de negócios (`Service`) e o acesso a dados (`Repository`).
* **DTOs:** Utilização de Data Transfer Objects (`TarefaEntradaDto` e `TarefaSaidaDto`) para desacoplar a camada de API do modelo de domínio.
* **Banco de Dados em Memória:** Uso do H2 para um ambiente de desenvolvimento leve e rápido.

---

## 🚀 Tecnologias Utilizadas

* **Java:** Linguagem de programação.
* **Spring Boot:** Framework principal para a construção da API.
* **Spring Data JPA:** Para a camada de persistência e repositórios.
* **H2 Database:** Banco de dados relacional em memória.
* **ModelMapper:** Para mapeamento automático de objetos.
* **Lombok:** Para reduzir o código boilerplate (como getters e setters).
* **Maven:** Ferramenta para gerenciamento de dependências e build do projeto.
* **Swagger/OpenAPI:** (Configurado) para documentação automática dos endpoints.

---

## ⚙️ Como Rodar a Aplicação

Siga os passos abaixo para compilar e iniciar o projeto:

1.  **Pré-requisitos:** Certifique-se de ter o **JDK** (versão 8 ou superior) e o **Maven** instalados em sua máquina.
2.  **Clone o repositório:**
    ```bash
    git clone [URL_DO_SEU_REPOSITORIO]
    cd [NOME_DO_SEU_PROJETO]
    ```
3.  **Compilar e Empacotar o Projeto:**
    ```bash
    mvn clean package
    ```
4.  **Iniciar a Aplicação:**
    ```bash
    java -jar target/[nome-do-arquivo].jar
    ```
    Ou, para iniciar rapidamente a partir do código-fonte:
    ```bash
    mvn spring-boot:run
    ```
    A API estará rodando em `http://localhost:8080`.

---

## 💻 Documentação da API

Todos os endpoints estão disponíveis sob a URL base `http://localhost:8080/tarefa`.

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/tarefa` | Cria uma nova tarefa. |
| `PUT` | `/tarefa/{id}` | Altera uma tarefa existente pelo ID. |
| `GET` | `/tarefa/{id}` | Busca uma tarefa específica pelo ID. |
| `DELETE`| `/tarefa/{id}` | Exclui uma tarefa pelo ID. |
| `GET` | `/tarefa` | Lista todas as tarefas. |

### Acessando Ferramentas de Desenvolvimento

Com a aplicação em execução, você pode acessar:
* **H2 Console:** `http://localhost:8080/h2-console` (use as credenciais do `application.properties`).
* **Swagger UI:** `http://localhost:8080/swagger-ui.html` (se a dependência estiver configurada).