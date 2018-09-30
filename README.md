Sample ofREST application

REST application that provides REST API.

Run BankService locally

Databse configuration

1. Create database bank
Predefined username - postgres
Predefined password - postgres

Change in properties if required

spring.datasource.initialize=true
spring.datasource.schema=classpath*:database/initDB.sql
spring.datasource.data=classpath*:database/populateDB.sql

spring.datasource.url=jdbc:postgresql://localhost:5432/bank - database name
spring.datasource.username=root - username
spring.datasource.password=pass - password
spring.datasource.driver-class-name=org.postrgesql.Driver - driver
spring.jpa.database=postgresql - database type
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect - dialect


2. git clone https://github.com/Amos57/BankService
3. cd BankService
4. mvn spring-boot:run

5. Access CustomerService using next REST requests:

POST: http://localhost:8080/bankaccount/{numAccount} - create new account
Request body:
{
	"numberAccount": numAccount,
	"sum": "0"
}

PUT:  http://localhost:8080/bankaccount/{numAccount}/deposit/{sum} - put sum in account

PUT: localhost:8080/bankaccount/{numAccaunt}/withdraw/{sum}
Request body:
{
	"sum":sum
}

GET: localhost:8080/bankaccount/10000/balance
Request body:
 
  456


