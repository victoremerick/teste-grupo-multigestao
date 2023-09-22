# Projeto Spring Boot com PostgreSQL

Este é um projeto de exemplo que demonstra a criação de um microsserviço em Spring Boot com PostgreSQL para gerenciar números de processos.

## Pré-requisitos

Antes de executar este projeto, certifique-se de ter o seguinte instalado em sua máquina:

- Java 8 ou superior
- Maven
- Docker

## Configuração do Banco de Dados PostgreSQL

Este projeto utiliza um contêiner Docker para o PostgreSQL. Para configurar o banco de dados, siga os passos abaixo:

1. Certifique-se de que o Docker está instalado em sua máquina.

2. Acesse a pasta `./docker` no diretório raiz do projeto com o seguinte conteúdo

3. Execute o comando a seguir no diretório do projeto para iniciar o contêiner PostgreSQL:

```
docker-compose up -d
```

## Executando o Projeto
Clone este repositório em sua máquina:

```
git clone https://github.com/victoremerick/teste-grupo-multigestao.git
```

Navegue até o diretório do projeto:

```
cd seu-projeto
```

Execute o projeto Spring Boot:

```
mvn spring-boot:run
```

O aplicativo estará disponível em http://localhost:8080.

### Endpoints

```
POST /processos: Salvar um novo número de processo.
```
```
GET /processos: Consultar todos os números de processos salvos.
```
```
DELETE /processos/{id}: Excluir um número de processo por ID.
```
```
POST /processos/{numeroProcesso}/adicionar-reu: Adicionar um réu a um processo existente.
```

Certifique-se de verificar a documentação da API ou os arquivos de código-fonte para obter mais detalhes sobre como usar os endpoints.

## Contribuição
Sinta-se à vontade para contribuir para este projeto. Abra uma issue ou envie um pull request com suas melhorias ou correções.

## Licença
Este projeto está licenciado sob a Licença MIT.


#### Lembre-se de personalizar o arquivo `README.md` com as informações específic


