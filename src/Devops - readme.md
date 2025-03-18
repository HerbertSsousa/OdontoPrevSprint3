# Implantação de Módulo da Solução Odontoprev na Nuvem

## 1. Descrição da Solução

A solução consiste na implantação de um módulo do sistema **Odontoprev** em nuvem, utilizando uma API desenvolvida em **Java** hospedada em um Serviço de Aplicativos da **Azure** e conectada a um banco de dados **Azure SQL Database**. O objetivo é fornecer um sistema de análise preditiva para detectar e mitigar fraudes e sinistros no setor odontológico.

A API disponibilizará endpoints para realizar operações CRUD sobre as entidades **Usuário** e **Funcionário** primeiramente, permitindo armazenar e recuperar informações essenciais para nosso aplicativo. Inicialmente, esses "cruds" são de extrema importância para identificar todos que estão utilizando o nosso aplicativo, para posteriormente realizar a análise preditiva de fraudes.

## 2. Desenho da Arquitetura da Solução

### Componentes principais:

- **Azure App Service**: Hospedagem da API em Java.
- **Database**: Armazena os dados estruturados do sistema.
- **Rede Virtual (VNet)**: Para segurança e isolamento da comunicação entre a API e o banco de dados.
- **Azure Monitor**: Monitoramento da aplicação.
- **Azure Key Vault**: Gerenciamento seguro de credenciais e conexões.

### Fluxo de informação:

1. O usuário interage com a API via requisições HTTP.
2. A API processa a requisição e executa operações no banco de dados.
3. O banco de dados retorna os dados processados.
4. A API responde ao usuário e armazena a requisição feita no banco de dados.
5. Os dados são armazenados no **Azure Monitor**.

## 3. Benefícios da Solução para o Negócio

- **Redução de fraudes e sinistros**: A análise preditiva melhora a detecção de irregularidades.
- **Escalabilidade**: A solução na Azure permite crescimento conforme demanda.
- **Segurança**: Proteção dos dados por meio de **VNet**.
- **Alta disponibilidade**: Infraestrutura robusta com balanceamento de carga e redundância.

## 4. DDL das Tabelas

```sql
CREATE TABLE usuarios (
    id_user      INT PRIMARY KEY,
    nome         VARCHAR(100) NOT NULL,
    cpf          VARCHAR(11) NOT NULL UNIQUE,
    senha        VARCHAR(255) NOT NULL,
    data_criacao DATE NOT NULL
);

CREATE TABLE fotos (
    id_fotos     INT PRIMARY KEY,
    usuario_id   INT NOT NULL,
    caminho_foto VARCHAR(255) NOT NULL,
    data_envio   DATE NOT NULL,
    FOREIGN KEY ( usuario_id )
        REFERENCES usuarios ( id_user )
            ON DELETE CASCADE
);

CREATE TABLE erros (
    id_erro         INT PRIMARY KEY,
    usuario_id      INT NULL,
    mensagem        VARCHAR2(50) NOT NULL,
    data_ocorrencia DATE NOT NULL,
    FOREIGN KEY ( usuario_id )
        REFERENCES usuarios ( id_user )
            ON DELETE SET NULL
);

CREATE TABLE processo (
    id_processo  INT PRIMARY KEY,
    usuario_id   INT NULL,
    analise_id   INT NOT NULL,
    data_analise DATE NOT NULL,
    FOREIGN KEY ( usuario_id )
        REFERENCES usuarios ( id_user )
            ON DELETE SET NULL
);

CREATE TABLE notificacoes (
    id_notificacoes  INT PRIMARY KEY,
    usuario_id       INT NOT NULL,
    mensagem         VARCHAR(50) NOT NULL,
    data_notificacao DATE NOT NULL,
    lida             NUMBER(1) DEFAULT 0, -- 0 para FALSE e 1 para TRUE,

    FOREIGN KEY ( usuario_id )
        REFERENCES usuarios ( id_user )
            ON DELETE CASCADE
);

CREATE TABLE analise_preditiva (
    id_analise NUMBER(10) PRIMARY KEY,
    resultado_analise VARCHAR2(255) NOT NULL,
    frequencia_sinistros NUMBER(10) NOT NULL,
    foto_id NUMBER(10) NOT NULL,
    data_analise DATE NOT NULL,
    CONSTRAINT fk_analise_foto FOREIGN KEY (foto_id) REFERENCES foto(id)
);

CREATE TABLE funcionario (
    id NUMBER(19) PRIMARY KEY,
    nome VARCHAR2(100) NOT NULL,
    cpf VARCHAR2(11) NOT NULL UNIQUE,
    cargo VARCHAR2(50) NOT NULL,
    salario NUMBER(15,2) NOT NULL,
    data_admissao DATE NOT NULL,
    telefone VARCHAR2(15),
    email VARCHAR2(50) UNIQUE
);



<br>
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



###arquivo json é o postman_collection.json com todos os endpoints pra testar a api, minha preferência pra testar é o Postman 




## Vídeo de Apresentação/Pitch

[YouTube](https://www.youtube.com/watch?v=uDAUgtqArlw)

## Link do Github

[Repositório](https://github.com/HerbertSsousa/OdontoPrevSprint3)
