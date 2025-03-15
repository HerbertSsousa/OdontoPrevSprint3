<h1>Revolucionando o Mercado Odontológico</h1>

<h2>Integrantes do Grupo</h2>
<ul>
  <li><strong>Herbert Santos</strong><br>
    <em>Responsabilidade</em>: 
foi responsável por uma parte significativa das evoluções no projeto. Ele desenvolveu a classe Analise_Preditiva, 
que foi projetada para analisar as fotos dos clientes e prever a aptidão para planos odontológicos e a frequência de sinistros, 
conectando-se a um modelo de machine learning. Herbert também implementou o controlador, DTO, repositório e serviço 
para a classe Funcionário, garantindo uma estrutura robusta e funcional. Além disso, ele realizou a eliminação da classe “Sair”,
considerada desnecessária, e implementou a integração de HATEOAS, levando a API ao nível 3 de maturidade de Richardson. 
Finalizando, ele executou a implementação de procedures na aplicação Java, permitindo operações de INSERT, UPDATE e DELETE,
além da adição do arquivo Postman_Collection.  </li>
  <li><strong>Enzo Franco</strong><br>
    <em>Responsabilidade</em>: 
Contribuiu com ajustes específicos na classe Notificação, reformulando-a para que tivesse um propósito mais claro e coeso no projeto,
alinhando-a às novas funcionalidades implementadas e ao fluxo de dados esperado.
  </li>
  <li><strong>João Pedro</strong><br>
    <em>Responsabilidade</em>: 
focou na otimização do código com o uso de Lombok, o que simplificou a manutenção e reduziu a verbosidade do projeto,
tornando a base de código mais limpa e eficiente, além de atualização no MER e DER 
  </li>
</ul>

<h2>Instruções para Rodar a Aplicação</h2>
<h3>Pré-requisitos</h3>
<ul>
  <li>JDK 17 ou superior</li>
  <li>Maven instalado</li>
  <li>Banco de dados Oracle ou outro banco de dados relacional configurado</li>
</ul>

<h3>Passos para Rodar:</h3>
<ol>
  <li>Clone o repositório do GitHub:
    <pre><code>git clone https://github.com/HerbertSsousa/SprintOdonto2</code></pre>
  </li>
  <li>Navegue até a pasta do projeto:
    <pre><code>cd nome-do-projeto</code></pre>
  </li>
  <li>Configure as credenciais do banco de dados no arquivo <code>application.properties</code>:
    <pre><code>
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
spring.jpa.hibernate.ddl-auto=update
    </code></pre>
  </li>
  <li>Compile o projeto:
    <pre><code>mvn clean install</code></pre>
  </li>
  <li>Execute a aplicação:
    <pre><code>mvn spring-boot:run</code></pre>
  </li>
  <li>Acesse a aplicação através da URL:
    <a href="http://localhost:8081">http://localhost:8081</a>
  </li>
</ol>

<h2>Diagramas</h2>
<h3>Diagrama de Classes</h3>
<img src="mer (2).png" alt="Diagrama de Classes">

<h3>Diagrama de Entidade-Relacionamento (DER)</h3>
<img src="der (2).png" alt="Diagrama de Entidade-Relacionamento (DER)">

<h2>Vídeo de Apresentação</h2>
<p>Você pode acessar o vídeo de apresentação da proposta tecnológica, o público-alvo da aplicação e os problemas que a aplicação se propõe a solucionar no link abaixo:</p>
<a href="https://youtu.be/Xg01iNC5zSs?si=pBmGElipfNv43P2c">Link para o vídeo de apresentação</a>

# Lista de Endpoints para testar no Postman

Abaixo estão os endpoints disponíveis para testar os controladores fornecidos, usando o endereço base `http://localhost:8081`.

## Endpoints de Análise Preditiva
- **GET** `/api/analises`: Lista todas as análises preditivas.
- **GET** `/api/analises/{id}`: Busca uma análise preditiva específica por ID.
- **POST** `/api/analises`: Cria uma nova análise preditiva.
- **DELETE** `/api/analises/{id}`: Exclui uma análise preditiva por ID.

## Endpoints de Erro
- **GET** `/erros`: Lista todos os erros.
- **GET** `/erros/{id}`: Busca um erro específico por ID.
- **POST** `/erros`: Cria um novo erro.
- **PUT** `/erros/{id}`: Atualiza um erro existente por ID.
- **DELETE** `/erros/{id}`: Exclui um erro por ID.

## Endpoints de Foto
- **GET** `/fotos`: Listar todas as fotos.
- **GET** `/fotos/{id}`: Buscar foto específica por ID.
- **POST** `/fotos`: Criar uma nova foto.
- **PUT** `/fotos/{id}`: Atualizar uma foto existente por ID.
- **DELETE** `/fotos/{id}`: Deletar uma foto por ID.

## Endpoints de Funcionário
- **GET** `/api/funcionarios`: Listar todos os funcionários.
- **GET** `/api/funcionarios/{id}`: Buscar funcionário específico por ID.
- **POST** `/api/funcionarios`: Criar um novo funcionário.
- **DELETE** `/api/funcionarios/{id}`: Excluir um funcionário por ID.

## Endpoints de Notificação
- **GET** `/notificacoes`: Listar todas as notificações.
- **GET** `/notificacoes/{id}`: Buscar notificação específica por ID.
- **POST** `/notificacoes`: Criar uma nova notificação.
- **PUT** `/notificacoes/{id}`: Atualizar uma notificação existente por ID.
- **DELETE** `/notificacoes/{id}`: Deletar uma notificação por ID.

## Endpoints de Processo
- **GET** `/processo`: Lista todos os processos.
- **GET** `/processo/{id}`: Busca um processo pelo ID.
- **POST** `/processo`: Cria um novo processo.
- **PUT** `/processo/{id}`: Atualiza um processo pelo ID.
- **DELETE** `/processo/{id}`: Deleta um processo pelo ID.

## Endpoints de Usuário
- **GET** `/usuarios`: Lista todos os usuários.
- **GET** `/usuarios/{id}`: Busca um usuário pelo ID, com links HATEOAS para navegação.
- **POST** `/usuarios`: Cria um novo usuário.
- **PUT** `/usuarios/{id}`: Atualiza um usuário pelo ID.
- **DELETE** `/usuarios/{id}`: Deleta um usuário pelo ID.


## Link do Github
https://github.com/HerbertSsousa/SprintOdonto2


## Link do vídeo
https://www.youtube.com/watch?v=4pkziGL_koo
