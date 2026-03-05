# API de Transações e Estatísticas

Esta API realiza o gerenciamento de transações e calcula estatísticas em tempo real (últimos 60 segundos).

## 🚀 Tecnologias
* Java / Spring Boot
* Maven
* OpenAPI / Swagger

## 🛠️ Testes Realizados (Evidências)

### 1. Criar Transação (Sucesso)
Retorna `201 Created` quando os dados são válidos.

### 2. Validação de Dados
* **Valor Negativo:** Retorna `422 Unprocessable Entity`.

* **Transação Atrasada (>60s):** Retorna `400 Bad Request`.

### 3. Estatísticas
Cálculo automático de `count`, `sum`, `avg`, `min` e `max`.

### 4. Limpar Dados
Remoção de todas as transações da memória.
