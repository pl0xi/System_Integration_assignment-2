# System Integration Mini Project 2
## Participants
* Benjamin Sommervoll - CPH-BS202
* Line Wienke - CPH-LW146  
* Louise Estrup – CPH-LE115 
* Jeffrey Adam Oechsner – CPH-JO208

## Architectural Style
We have built our system with microservices architectural style. The process engine (Camunda Processer), Middleware (Apache Camel) and backend is seperated services built with Java (17 & 21). 

![alt text](https://github.com/pl0xi/System_Integration_assignment-2/blob/main/Server_architecture.png)

## Business process
We have chosen to create a business process scenario with creating a user. The business process includes a form, business rule and a service task. 
![alt text](https://github.com/pl0xi/System_Integration_assignment-2/blob/main/Business_process_diagram.png)
First event is a user task, which asks for user informations: name, phone number and email.
Second event is a business rule, which checks for the inputs are valid (Not empty)
Third event is a gateway checking for the result from the business rule. If the rule was not approved, the first task must be redone. The last event is a Service task, which sends a request to the Apache Camel to create a user in the database.

## Apache Camel (EIP)
We are using Apache Camel with rest endpoints. 
