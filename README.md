<div align="center">

# 💪 GymTracker API

### API REST para registro e acompanhamento de evolução de treinos

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![JPA](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow?style=for-the-badge)

<img src="https://media.giphy.com/media/qgQUggAC3Pfv687qPC/giphy.gif" width="500" alt="Coding gif"/>

</div>

---

## 📌 Sobre o Projeto

O **GymTracker API** é uma API REST desenvolvida em **Java com Spring Boot** para registro de exercícios e acompanhamento da evolução de carga ao longo do tempo.

Com ela é possível:
- Cadastrar exercícios com grupo muscular, séries, repetições e carga inicial
- Registrar incrementos de carga a cada treino
- Calcular automaticamente o **percentual de evolução** em relação ao último registro
- Consultar o histórico de evolução por exercício

---

## 🎯 Motivação

<div align="center">
<img src="https://media.giphy.com/media/l0MYt5jPR6QX5pnqM/giphy.gif" width="400" alt="Gym progress gif"/>
</div>

Quem treina sabe que acompanhar a evolução de carga é essencial para garantir progressão e resultados. Este projeto nasceu da necessidade de ter um sistema simples, via API, que registre cada treino e mostre o quanto você evoluiu semana a semana.

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Finalidade |
|---|---|
| Java 17 | Linguagem principal |
| Spring Boot | Framework principal |
| Spring Data JPA | Persistência de dados |
| Hibernate | ORM |
| Lombok | Redução de boilerplate |
| PostgreSQL | Banco de dados relacional |
| Maven | Gerenciamento de dependências |

---

## 🚀 Endpoints da API

<div align="center">
<img src="https://media.giphy.com/media/du3J3cXyzhj75IOgvA/giphy.gif" width="400" alt="API gif"/>
</div>

### 🏋️ Exercícios

| Método | Rota | Descrição |
|---|---|---|
| `GET` | `/exercicios` | Lista todos os exercícios cadastrados |
| `POST` | `/exercicios` | Cadastra um novo exercício |
| `DELETE` | `/exercicios/{id}` | Remove um exercício |
| `PATCH` | `/exercicios/{id}/adicionar-carga` | Adiciona carga e calcula evolução |

---

### 📥 Exemplo de Requisição — Cadastrar Exercício

```json
POST /exercicios
Content-Type: application/json

{
  "nome": "Supino Reto",
  "grupoMuscular": "Peito",
  "carga": 60.0,
  "series": 4,
  "repeticoes": 10
}
```

### 📤 Exemplo de Resposta — Adicionar Carga

```json
PATCH /exercicios/1/adicionar-carga?ganho=5

// Retorno: percentual de evolução em relação ao último registro
15.38
// Significa: você evoluiu 15,38% desde o último treino!
```

---

## 📂 Estrutura do Projeto

```
src/
└── main/
    └── java/com/example/demo/
        ├── controller/
        │   └── ExercicioController.java   # Camada de entrada HTTP
        ├── service/
        │   └── ExercicioService.java      # Regras de negócio
        ├── repository/
        │   ├── ExercicioRepository.java
        │   └── ExercicioEvolutionRepository.java
        ├── model/
        │   ├── Exercicio.java             # Entidade principal
        │   └── ExercicioEvolution.java    # Histórico de evolução
        └── DemoApplication.java
```

---

## ⚙️ Como Rodar Localmente

### Pré-requisitos

- Java 17+
- Maven
- PostgreSQL rodando localmente

### Passos

```bash
# 1. Clone o repositório
git clone https://github.com/rafa2707e/gymtracker-api.git

# 2. Entre na pasta do projeto
cd gymtracker-api

# 3. Configure o banco de dados em src/main/resources/application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/gymtracker
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

# 4. Rode o projeto
mvn spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

---

## 🔮 Próximas Features

- [ ] Autenticação com JWT
- [ ] Relatório semanal de evolução por grupo muscular
- [ ] Suporte a múltiplos usuários
- [ ] Deploy na AWS (EC2 + RDS)
- [ ] Documentação com Swagger/OpenAPI

---

## 👨‍💻 Autor

<div align="center">

**Rafael Oliveira**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/rafael-oliveira-46052516b/)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/rafa2707e)

</div>

---

<div align="center">
  <i>Projeto em desenvolvimento ativo 🚧</i>
</div>
