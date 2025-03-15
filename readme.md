# Faculdade de Informática e Administração Paulista

## Nome dos Integrantes:

- **Herbert Santos de Sousa**: RM553227
- **João Pedro Pereira**: RM553698
- **Enzo Franco Rocha**: RM553643

## Java Advanced

### São Paulo 2025

# Revolucionando o Mercado Odontológico

## Integrantes do Grupo

### Herbert Santos
- Desenvolveu a classe `Analise_Preditiva`, responsável pela análise de fotos dos clientes para prever aptidão para planos odontológicos e frequência de sinistros.
- Implementou controlador, DTO, repositório e serviço para a classe `Funcionario`.
- Eliminou a classe `Sair`, considerada desnecessária.
- Implementou integração de `HATEOAS`, levando a API ao nível 3 de maturidade de Richardson.
- Executou a implementação de `procedures` na aplicação Java, permitindo operações de `INSERT`, `UPDATE` e `DELETE`, além da adição do arquivo `Postman_Collection`.
- Criou os CRUDs necessários na classe `Usuario` e `Funcionario`, conforme solicitado e demonstrado no vídeo.

### Enzo Franco
- Ajustou a classe `Notificação`, reformulando-a para que tivesse um propósito mais claro e coeso no projeto.
- Alinhou a classe `Notificação` às novas funcionalidades implementadas e ao fluxo de dados esperado.

### João Pedro
- Otimizou o código com `Lombok`, reduzindo a verbosidade e tornando a base de código mais limpa e eficiente.
- Atualizou os diagramas `MER` e `DER`.

## Objetivo do Projeto

O projeto busca reduzir sinistros no setor odontológico por meio de uma solução preditiva baseada em `machine learning`. A aplicação permite análise preditiva de sinistros, melhorando a gestão de riscos e otimizando processos para operadoras de planos odontológicos.

## Arquitetura da Solução

A aplicação segue a arquitetura `MVC` e utiliza:

- `Spring Boot` para gerenciamento de dependências e desenvolvimento backend.
- `Thymeleaf` para renderização dinâmica de templates.
- `Banco de dados Oracle` para persistência de dados.
- `JPA/Hibernate` para mapeamento objeto-relacional.
- `HATEOAS` para construção de APIs `RESTful` no nível 3 de Richardson.
- `Lombok` para otimização de código.
- `Procedures SQL` para manipulação de dados diretamente no banco.

## Funcionalidades Implementadas

- CRUD para `Funcionario` e `Usuario`.
- Análise preditiva de sinistros via integração com modelo de `machine learning`.
- Templates `Thymeleaf` dinâmicos para exibição de dados.
- Testes de API com `Postman`.
- Integração com banco de dados `Oracle`.
- Implementação de `HATEOAS` para navegação entre recursos.

## Dificuldades Encontradas

- Configuração e integração do `HATEOAS`.
- Ajustes nas entidades para melhoria da coesão e separação de responsabilidades.
- Implementação de `procedures` no banco `Oracle`.
- CRUD através do `Thymeleaf`.

## Próximos Passos

- Refinamento da interface do usuário.
- Criar a funcionalidade para upload de fotos e usuários.
- Implementação de testes automatizados para garantir robustez da aplicação.
- Melhoria na experiência do usuário com novas funcionalidades interativas.
- Melhorar o frontend.
- Otimização do banco de dados para melhor performance.

## Instruções para Rodar a Aplicação

### Pré-requisitos

- `JDK 17` ou superior
- `Maven` instalado
- Banco de dados `Oracle` configurado

### Passos para Execução

1. Clone o repositório do GitHub:
   ```bash
   git clone https://github.com/HerbertSsousa/SprintOdonto2
   ```
2. Navegue até a pasta do projeto:
   ```bash
   cd nome-do-projeto
   ```
3. Configure as credenciais do banco de dados no arquivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
   spring.datasource.username=seu-usuario
   spring.datasource.password=sua-senha
   spring.jpa.hibernate.ddl-auto=update
   ```
4. Compile o projeto:
   ```bash
   mvn clean install
   ```
5. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```
6. Acesse a aplicação via navegador: [http://localhost:8081](http://localhost:8081)

## Diagrama de Entidade-Relacionamento (DER)

O banco de dados desenvolvido contém tabelas inter-relacionadas para gerenciar usuários, fotos, erros, processos, notificações, registros de saída, análises preditivas e dados de funcionários. As tabelas utilizam chaves primárias para garantir unicidade em cada registro e chaves estrangeiras para estabelecer relações entre as entidades. As constraints `ON DELETE CASCADE` e `ON DELETE SET NULL` definem o comportamento para exclusões, onde registros dependentes são excluídos ou têm seus valores nulos, conforme o caso.

Cada tabela é estruturada com integridade referencial e constraints de unicidade, como no campo `cpf` em `usuarios`, garantindo que cada usuário tenha um CPF único. Além disso, uma sequência (`funcionario_seq`) foi configurada para gerar IDs automaticamente para os registros de funcionários, assegurando valores únicos. Esses relacionamentos e constraints promovem a integridade e a consistência dos dados no sistema.

## Listagem de Endpoints

### Endpoints de AnalisePreditiva
- `GET /api/analises`
- `GET /api/analises/{id}`
- `POST /api/analises`
- `DELETE /api/analises/{id}`

### Endpoints de Erro
- `GET /erros`
- `GET /erros/{id}`
- `POST /erros`
- `PUT /erros/{id}`
- `DELETE /erros/{id}`

### Endpoints de Foto
- `GET /fotos`
- `GET /fotos/{id}`
- `POST /fotos`
- `PUT /fotos/{id}`
- `DELETE /fotos/{id}`

### Endpoints de Funcionario
- `GET /api/funcionarios`
- `GET /api/funcionarios/{id}`
- `POST /api/funcionarios`
- `DELETE /api/funcionarios/{id}`

### Endpoints de Notificacao
- `GET /notificacoes`
- `GET /notificacoes/{id}`
- `POST /notificacoes`
- `PUT /notificacoes/{id}`
- `DELETE /notificacoes/{id}`

## Vídeo de Apresentação/Pitch

[YouTube](https://www.youtube.com/watch?v=kd1TGHjLLk4)

## Link do Github

[Repositório](https://github.com/HerbertSsousa/OdontoPrevSprint3)


<h2>Diagramas</h2>
<h3>Diagrama de Classes</h3>
<img src="mer (2).png" alt="Diagrama de Classes">

<h3>Diagrama de Entidade-Relacionamento (DER)</h3>
<img src="der (2).png" alt="Diagrama de Entidade-Relacionamento (DER)">
