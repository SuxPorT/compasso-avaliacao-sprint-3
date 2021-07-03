<h1 align="center">Avaliação Sprint 3</h1>
<p align="center">Desenvolva uma aplicação em Spring Boot que possua dois endpoints</p>

## 1. POST api/cars que cria uma lista de carros
- [X] a. Pode ser armazenado em memória ou em um banco de dados
- [X] b. Não é permitido a repetição de dados (usaremos como validação o Chassi)
- [X] c. Dados para armazenamento (Chassi, Nome, Marca, Cor, Valor, Ano de Fabricação)
## 2. GET api/cars que retorna uma lista de carros
- [X] a. Filtrar carros por marca
- [X] b. Filtrar carros por nome
- [X] c. Filtrar carros por cor
- [X] d. Filtrar o carro mais caro
- [X] e. Filtrar o carro mais barato
- [X] f. Ordenar por nome
- [X] g. Ordenar valor
- [X] h. Ordenar por ano de fabricação

Exemplo<br/>
**GET**: api/cars?marca=ford&anoFabricacao= 2015

**Retorno JSON**:
<pre><code>
{
	"chassi": "9BBNSZPPA288003333",
	"nome": "New Fiesta",
	"marca": "ford",
	"cor": "branco",
	"valor": 28.100,
	"anoFabricacao": 2015
}
</code></pre>

Como parte do trabalho e como uma forma de documentar a API, crie a documentação dela pelo Swagger.

## Ferramentas e dependências utilizadas
![Java Badge](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring Badge](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Eclipse Badge](https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipse&logoColor=white)
![Postman Badge](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white)
![Git Badge](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
<img src="https://static1.smartbear.co/swagger/media/assets/images/swagger_logo.svg" width="90px;"></img>

- **[Spring Initializr](https://start.spring.io/):** gera um projeto de Spring Boot com dependências iniciais de forma rápida. Todas as dependências se encontram no arquivo **[pom.xml](/pom.xml)**.
  * **Projeto Maven com Spring Boot versão 2.5.2 e Java versão 8.**
  * **Spring Data JPA**: persiste dados em SQL com Java Persistence API usando Spring Data e Hibernate.
  * **Spring Web**: cria aplicações web, incluindo RESTful, usando Spring MVC, utilizando o Apache Tomcat como contêiner integrado padrão.
  * **Validation**: Bean Validation com validador do Hibernate.
  * **H2 Database**: fornece um banco de dados em memória que suporta acesso JDBC API e R2DBC, com um aplicativo de console baseado em navegador.
  * **Spring Boot DevTools**: fornece reinicializações rápidas de aplicativos, LiveReload e configurações para uma experiência de desenvolvimento aprimorada.
  * As configurações do DataSource, JPA e H2 se encontram no arquivo **[application.properties](/src/main/resources/application.properties)**
  * Os registros do banco de dados utilizados como teste se encontram no arquivo **[data.sql](/src/main/resources/data.sql)**
- **[Eclipse IDE for Java EE Developers](https://www.eclipse.org/downloads/packages/release/kepler/sr2/eclipse-ide-java-ee-developers)**: ferramentas para desenvolvedores Java criando aplicativos Java EE e Web, incluindo Java IDE, ferramentas para Java EE, JPA, JSF, Mylyn, EGit e outros.
- **[Postman](https://www.postman.com/)**: plataforma de colaboração para desenvolvimento de API, utilizado para requisições do tipo GET/POST/PUT/DELETE.
- **[Git](https://git-scm.com/)**: sistema de controle de versão distribuído gratuito e de código aberto.
- **[Swagger](https://swagger.io/)**: simplifica o desenvolvimento de API, ajudando a projetar e documentar APIs. A documentação criada para esse projeto se encontra em **[documentacao-swagger.yml](/documentacao-swagger.yml)**.

## Links externos utilizados
* ***[Rocketseat - Como fazer um bom README](https://blog.rocketseat.com.br/como-fazer-um-bom-readme/)***
* ***[Ileriayo Adebiyi - Markdown Badges](https://github.com/Ileriayo/markdown-badges)***
* <strike>***[Salvador de vidas - Stack Overflow](https://stackoverflow.com/)***</strike>
