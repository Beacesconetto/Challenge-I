Programa  de Bolsas Compass API
Esta é uma API RESTful desenvolvida usando o framework Spring Boot em Java 17 e o Maven 3.0.9 para lidar com as operações básicas dos verbos HTTP (GET, POST, PUT e DELETE). 
A API permite a manipulação de informações relacionadas ao Programa de Bolsas Compass, incluindo registros de organizadores, alunos, classes e squads.

Requisitos:
Java 17
Maven 3.0.9
Banco de dados: MySQL 
Postman (para testar os endpoints)
Configuração do Projeto
Clone este repositório: git clone https://github.com/Beacesconetto/ChalangeWeekVIII
Navegue até o diretório do projeto: cd ChalangeWeekVIII
Configure as propriedades do banco de dados no arquivo src/main/java/BeatrizCesconettoSchool/scholarship
Populando o Banco de Dados
Execute o script SQL fornecido em src/main/resources/data.sql para popular o banco de dados com os dados iniciais.
Executando o Projeto
Execute o seguinte comando para compilar e executar a aplicação: mvn spring-boot:run
Endpoints
A API possui os seguintes endpoints:

GET /v1/COORDINATOR{id}: Retorna a lista de todos os coordinators .
GET /v1/Students{id}: Retorna a lista de todos os alunos.
GET /v1/schoolclass/{id}: Retorna a lista de todas as classes.
POST /v1/students: Cria um novo aluno.
POST /v1/coordinators: Cria um novo coordenador.
POST /v1/scrummasters: Cria um novo scrum master.
POST /v1/scholclass: Cria um novo school class.
POST /v1/instructors: Cria um novo instrutor.
POST /v1/squads: Cria um novo squad.
PUT /v1/{id}/started: Atualiza o status da classe para started
PUT /v1/{id}/finished: Atualiza o status da classe para finished
DELETE /v1/alunos/delete/{id}: Exclui um aluno.
