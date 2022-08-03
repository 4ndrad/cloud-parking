# cloud-parking
### Projeto desafio da Digital Innovation One (DIO)


Utilizando Spring Boot para controlar um estacionamento de veículos. Serão controlados a entrada, saída e valor a ser cobrado do cliente.  
As ferrametas usadas foram  o Spring Security  para a segurança, Spring Data para o acesso a banco de dados MySQL, o Heroku a fim de disponibilizar a API para a Internet e o Swagger para a documentação.

### Run database                                                                                                    
docker run --name parking-db -p 3306:3306 -e MYSQL_DB=parking -e MYSQL_USER=admin -e MYSQL_PASSWORD=8kH#qgAik368&0 -d mysql:10-alpine

### Start and Stop

### Stop Database
docker stop parking-db

### Start Database
docker start parking-db

#### Deploy da API
https://parking-ntn.herokuapp.com/parking

#### Documentação
https://parking-ntn.herokuapp.com/swagger-ui.html
