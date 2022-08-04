# cloud-parking
### Projeto desafio da Digital Innovation One (DIO)


Utilizando Spring Boot para controlar um estacionamento de veículos. Serão controlados a entrada, saída e valor a ser cobrado do cliente.  
As ferrametas usadas foram  o Spring Security  para a segurança, Spring Data para o acesso a banco de dados MySQL, o Heroku a fim de disponibilizar a API para a Internet e o Swagger para a documentação.

#### Documentação
https://parking-ntn.herokuapp.com/swagger-ui.html

#### Deploy da API
https://parking-ntn.herokuapp.com/parking


## Run database                                                                                                    
docker run --name parking-db -p 3306:3306 -e MYSQL_DB=parking -e MYSQL_USER=admin -e MYSQL_PASSWORD=8kH#qgAik368&0 -d mysql:10-alpine

#### Caso tenha problema com o Docker ou o Container
Use um banco em memória ou crie uma nova imagem
Site do Test container https://www.testcontainers.org/

### Start Database
docker start parking-db

### Stop Database
docker stop parking-db


