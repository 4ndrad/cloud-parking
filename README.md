# cloud-parking
### Projeto desafio da Digital Innovation One (DIO)


Utilizando Spring Boot para controlar um estacionamento de veículos. Serão controlados a entrada, saída e valor a ser cobrado do cliente.  
As ferrametas usadas foram  o Spring Security  para a segurança, Spring Data para o acesso a banco de dados MySQL, o Heroku a fim de disponibilizar a API para a Internet e o Swagger para a documentação.

### Autorizações

## Swagger
Vai ter um campo com um cadiado aberto na documentação, clique coloque o usuario e senha e em seguida clique em "Close"
Você estara autorizado a usar e o cadiado estara fechado

USER: user
PASSWORD: dio@123

#### Documentação
https://parking-ntn.herokuapp.com/swagger-ui.html

#### Deploy da API
https://parking-ntn.herokuapp.com/parking

## Optei por não usar o Docker e nem criar um container
### mas deixei a dependência  e um arquivo de configuração disponivel, caso queira usar  basta seguir as instrções a baixo

## Docker
Tenha o docker instalado e crie ou baixe uma imagem (nome opcinal da imagem "mysql:10-alpine")

## Run database
docker run --name parking-db -p 3306:3306 -e MYSQL_DB=parking -e MYSQL_USER=admin -e MYSQL_PASSWORD=8kH#qgAik368&0 -d mysql:10-alpine 

### Start Database
docker start parking-db

### Stop Database
docker stop parking-db

### Na classe de teste ParkingControllerTest extenda para AbstractContainerBase

### Caso tenha problema com o Docker ou o Container

Opte por usar e confingurar um Banco de Dados ao seu gosto

Ou crie e use uma nova imagem

Site do Test container https://www.testcontainers.org/




