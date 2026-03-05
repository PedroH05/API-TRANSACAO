# API de Transações e Estatísticas

API desenvolvida em Spring Boot para o gerenciamento de transações financeiras e cálculo de estatísticas em tempo real (últimos 60 segundos).

## Tecnologias e Dependências

As principais ferramentas utilizadas no desenvolvimento foram:

* **Java 17** e **Spring Boot 3**
* **Spring Web**: Construção dos endpoints REST.
* **Spring Validation**: Validação de campos obrigatórios, valores positivos e datas.
* **Lombok**: Redução de código boilerplate (getters, setters e construtores).
* **Springdoc OpenAPI (Swagger)**: Documentação interativa da API.
* **Maven**: Gerenciamento de dependências.

## Funcionalidades e Evidências

### 1. Criar Transação
O endpoint `POST /transacao` recebe o valor e a data/hora. Quando os dados são válidos, retorna `201 Created`.

### 2. Validações de Regra de Negócio
A API valida se os dados estão corretos conforme os requisitos:
* **Valor Negativo ou Inválido:** Retorna `422 Unprocessable Entity`.
* 
* **Data Antiga (> 60 segundos):** Retorna `400 Bad Request`.

### 3. Estatísticas em Tempo Real
O endpoint `GET /estatistica` calcula a soma, média, valor mínimo, valor máximo e quantidade das transações dos últimos 60 segundos.

### 4. Limpeza de Dados
O endpoint `DELETE /transacao` limpa todas as transações da memória.

### 5. Documentação
A documentação completa pode ser acessada via Swagger UI.

---
Desenvolvido como projeto de estudo para APIs REST com Spring Boot.
