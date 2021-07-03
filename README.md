# Avaliação Sprint 3

Desenvolva uma aplicação em spring-boot que possua dois endpoints

## 1. POST api/cars que cria uma lista de carros
- [X] a. Pode ser armazenado em memória ou em um banco de dados
- [X] b. Não é permitido a repetição de dados (usaremos como validação o Chassi)
- [X] c. Dados para armazenamento (Chassi, Nome, Marca, Cor, Valor, Ano de Fabricação)
## 2. GET api/cars que retorna uma lista de carros
- [X] a. Filtrar carros por marca
- [X] b. Filtrar carros por nome
- [X] c. Filtrar carros por cor
- [ ] d. Filtrar o carro mais caro
- [ ] e. Filtrar o carro mais barato
- [X] f. Ordenar por nome
- [X] g. Ordenar valor
- [X] h. Ordenar por ano de fabricação

Exemplo<br>
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

# Ferramentas e dependências utilizadas
