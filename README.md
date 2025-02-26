# **BetOnMe**

O **BetOnMe** é um sistema de apostas em desafios pessoais, onde os usuários podem criar desafios, apostar dinheiro e ter amigos como fiscais para validar o cumprimento do desafio. Se o desafio não for cumprido, o dinheiro é doado para caridade.

## 🚀 **Funcionalidades Implementadas**

### 🔹 **1. Entidades Principais**
#### 📌 **User**
- Representa os usuários do sistema.  
- **Campos:** `id`, `nome`, `email`, `senha`, `desafios`, `pagamentos`.  
- **Relacionamentos:** Um usuário pode criar vários desafios e ter vários pagamentos.  

#### 📌 **Challenge**
- Representa os desafios criados pelos usuários.  
- **Campos:** `id`, `titulo`, `descricao`, `valorAposta`, `dataLimite`, `statusDesafio`.  
- **Relacionamentos:** Um desafio pertence a um usuário e pode ter vários fiscais (outros usuários).  

#### 📌 **Payment**
- Representa os pagamentos associados aos desafios.  
- **Campos:** `id`, `valorPagamento`, `statusPagamento`.  
- **Relacionamentos:** Um pagamento está associado a um desafio e a um usuário.  

---

### 🔹 **2. Endpoints Implementados**

#### **🧑‍💻 UserController**
- **POST** `/user` → Cria um novo usuário.  
- **GET** `/user/{id}` → Busca um usuário por ID.  
- **PUT** `/user/{id}` → Atualiza os dados de um usuário.  
- **DELETE** `/user/{id}` → Exclui um usuário.  

#### **🏆 ChallengeController**
- **POST** `/challenge` → Cria um novo desafio.  
- **GET** `/challenge/{id}` → Busca um desafio por ID.  
- **GET** `/challenge` → Lista todos os desafios.  
- **PUT** `/challenge/{id}` → Atualiza os dados de um desafio.  
- **DELETE** `/challenge/{id}` → Exclui um desafio.  

#### **💳 PaymentController**
- **POST** `/payment` → Cria um novo pagamento.  
- **GET** `/payment/{id}` → Busca um pagamento por ID.  
- **GET** `/payment` → Lista todos os pagamentos.  
- **PUT** `/payment/{id}` → Atualiza os dados de um pagamento.  
- **DELETE** `/payment/{id}` → Exclui um pagamento.  

---

### 🔹 **3. Tecnologias Utilizadas**
- 🖥️ **Spring Boot** → Framework para desenvolvimento de aplicações Java.  
- 📊 **Spring Data JPA** → Para acesso e gerenciamento de dados.  
- 🗄️ **H2 Database** → Banco de dados em memória para desenvolvimento.  
- ⚡ **Lombok** → Para reduzir boilerplate code.  
- 🔄 **MapStruct** → Para mapeamento entre entidades e DTOs.  
- ✅ **Spring Validation** → Para validação de dados de entrada.  
- 🌐 **Spring Web** → Para desenvolvimento de APIs RESTful.  

---

### 🔹 **4. Estrutura do Projeto**
```
src
├── main
│   ├── java
│   │   └── com
│   │       └── betonme
│   │           ├── controller
│   │           │   ├── UserController.java
│   │           │   ├── ChallengeController.java
│   │           │   └── PaymentController.java
│   │           ├── service
│   │           │   ├── UserService.java
│   │           │   ├── ChallengeService.java
│   │           │   └── PaymentService.java
│   │           ├── repository
│   │           │   ├── UserRepository.java
│   │           │   ├── ChallengeRepository.java
│   │           │   └── PaymentRepository.java
│   │           ├── entity
│   │           │   ├── User.java
│   │           │   ├── Challenge.java
│   │           │   └── Payment.java
│   │           ├── dto
│   │           │   ├── UserDTO.java
│   │           │   ├── ChallengeDTO.java
│   │           │   └── PaymentDTO.java
│   │           ├── mapper
│   │           │   ├── UserMapper.java
│   │           │   ├── ChallengeMapper.java
│   │           │   └── PaymentMapper.java
│   │           └── exception
│   │               ├── GlobalExceptionHandler.java
│   │               └── ResourceNotFoundException.java
│   └── resources
│       ├── application.properties
│       └── data.sql
└── test
    └── java
        └── com
            └── betonme
                ├── controller
                │   ├── UserControllerTest.java
                │   ├── ChallengeControllerTest.java
                │   └── PaymentControllerTest.java
                ├── service
                │   ├── UserServiceTest.java
                │   ├── ChallengeServiceTest.java
                │   └── PaymentServiceTest.java
                └── repository
                    ├── UserRepositoryTest.java
                    ├── ChallengeRepositoryTest.java
                    └── PaymentRepositoryTest.java
```

---

### 🔹 **5. Como Executar o Projeto**

#### **📌 Pré-requisitos**
- ☕ **Java 17** ou superior.  
- 🛠️ **Maven** instalado.  
- 🖥️ **IDE** de sua preferência (**IntelliJ**, **Eclipse**, **VS Code**).  

#### **📌 Passos**
1. Clone o repositório:  
   ```bash
   git clone https://github.com/seu-usuario/betonme.git
   ```

2. Navegue até o diretório do projeto:  
   ```bash
   cd betonme
   ```

3. Compile o projeto:  
   ```bash
   mvn clean install
   ```

4. Execute o projeto:  
   ```bash
   mvn spring-boot:run
   ```

5. Acesse a API:  
   - 🌍 API disponível em **`http://localhost:8080`**.  
   - Use o **Postman** ou **Insomnia** para testar os endpoints.  

---

### 🔹 **6. Testes**
- 🧪 **Testes Unitários:**  
  - Usando **JUnit** e **Mockito** para testar os métodos dos services e controllers.  
- 🔄 **Testes de Integração:**  
  - Usando **Spring Boot Test** para testar os endpoints da API.  

---

### 🔹 **7. Contribuição**
Se você quiser contribuir com o projeto, siga os passos abaixo:  
1. Faça um **fork** do repositório.  
2. Crie uma **branch** para sua feature:  
   ```bash
   git checkout -b minha-feature
   ```
3. **Commit** suas mudanças:  
   ```bash
   git commit -m "Adicionando nova feature"
   ```
4. Envie para o repositório remoto:  
   ```bash
   git push origin minha-feature
   ```
5. Abra um **pull request** e descreva suas mudanças.  

---

### 🔹 **8. Licença**
Este projeto está licenciado sob a **MIT License**. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.  

---

### 🔹 **9. Contato**
📌 **Lucas Souza**  
✉ **Email:** seu-email@exemplo.com  
🐙 **GitHub:** [seu-usuario](https://github.com/seu-usuario)  

---

Esse **README** agora está bem formatado para o GitHub, com emojis e markdown organizados. 🎯🚀
