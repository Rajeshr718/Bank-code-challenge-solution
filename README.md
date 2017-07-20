# Bank-code-challenge-solution

This project is my solution to the code challenge published by Number26

## Get & run it
 
 - Clone the project from `master` branch.
 - With Maven installed, just run command `mvn spring-boot:run` at the root of the project. 

## Project structure
 
 Project is a Maven project, inheriting from the Spring Boot parent POM.
 
 ## The language
 
  Java 1.7
  
 ## The web architecture
 
 All web MVC standard, we'll let Spring take care of auto-configuring properties, beans, config files. etc. 
 The web front and will listen port 8080 and will be accessible through the following mappings (quoted from log file):
 
 ```
 Mapped "{[/transaction],methods=[Post]}"
 Mapped "{[/statistics],methods=[GET]}"
 ```
 
 It will serve REST clients and will answer with JSON objects serialized from data objects created in the controller.
 
## The model
 
 The REST service deals only with transactions, so the model is limited to a single data class
 
 public class Transaction{

	private double amount;
	
	private long timestamp;

	public Transaction() {
		super();
	}
	
	public Transaction(double amount, long timestamp) {
		super();
		this.amount = amount;
		this.timestamp = timestamp;
	}

## Below requirment is handled in the code
The API have to be threadsafe with concurrent requests
● The API have to function properly, with proper result
● The project should be buildable, and tests should also complete successfully. e.g. If
maven is used, then mvn clean install should complete successfully.
● The API should be able to deal with time discrepancy, which means, at any point of time,
we could receive a transaction which have a timestamp of the past
● Make sure to send the case in memory solution without database (including in-memory
database)
● Endpoints have to execute in constant time and memory (O(1))
