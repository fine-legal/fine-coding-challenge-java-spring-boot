# Java Spring Boot Coding Challenge @ fine.
The goal of this challenge is to give you an opportunity to show us what you know and how you would work in a real life project.

## Intro
We expect you to fork this github repository that contains the instructions, project structure and basic assets.<br>
Please always commit and push over your fork and when you are done create a pull request to this repository to deliver the results.<br>
Please commit often and with meaningful commit messages. But do it like you would do it in a real environment.<br>

- You will find the application basic structure in this folder. You should use the `ANSWERS.md` file if you want to write a description or explanation of your code/solution.
- Be sure to always include your written answers/explanations in the `ANSWERS.md` file within the same commit if they belong together.

## General
We expect you to fork this github repository that contains the instructions, project structure etc.
Please always commit and push and when you are done share your repository.

You will find the application basic structure and the code in the root folder. 
You should use the ANSWERS.md file if you want to write a description or explanation of your code/solution.
Be sure to always include your code and also the written answers/explanations in the ANSWERS.md file within the same commit if they belongs to the same challenge part.
We expect you to write unit tests for the code you write.

> After cloning the repository, you should be ready to start up the application at port 8080 with the command mvn springboot:run

## Technical Requirements
Here is the list of the technologies we are providing in the application structure:

- Java 11
- Spring boot 3.0.6
- Tomcat
- Maven
- H2 embedded database
- Spring Data JPA

Feel free to implement the task below in any other JVM based language or add dependencies if you need to.

## Task
The task is to implement a simple REST API that allows to manage leads, users and claims and interact with a simple external API as well as handling persistence.

### A - Model
Implement the following entities: Lead, Deal, User and two types of Deal.
- A Lead has a firstname, lastname, address, city, zip code, phone number and an email address
- A User has a firstname, lastname, address, city, zip code, state, court, phone number and an email address 
- Deal A has a name, description, withdrawals, deposits, amount involved, status 
- Deal B has a name, description, amount involved, gross salary, contract start date, status

Deal Status can be one of the following:
- NEW
- IN_PROGRESS
- CLOSED

Please make use of polymorphism and inheritance where it makes sense.
Please choose the appropriate data types for the fields and the appropriate relationships between the entities as well as the appropriate annotations / strategies for the entities and fields. Describe shorty the reasons why you picked the one picked.

### B - Expose REST API - No implementation needed
Implement the following endpoints and behaviour:
- GET `/leads`: Returns a list of all leads.
- GET `/leads/{id}`: Returns the details of a specific lead by its ID.
- POST `/leads`: Creates a new lead.
- POST `/leads/{id}/convert`: Converts a lead into a user and resolves the zip code to the appropriate state based on a fixed map provided via the application properties (limit yourself for some example entries).


- POST `/user/{id}/deals`: Creates a new deal associated with the user. The type of the deal should be specified in the request body.
- GET `/user/{id}/deals`: Returns a list of all deals associated with a specific lead.


### C - External API - No implementation needed
Implement a service that interacts with a fictional external API provided by https://api.courtdata.io/ and resolves the court based on the zip code.
- GET `/court/zip-code/{zip_code}`: Returns the court associated with the zip code.

The returned payload looks like the following:
```json
{
  "court": "string",
  "zipCode": "string"
}
```

### D - Expose Webhook - No implementation needed
Think about the following scenario and design a solution for it:
Implemented is a webhook that can be called by an external service when there is an update on a deal status.
This service also exposes an API that allows to retrieve the current status of a deal as well as send updates to the external service.

How would you design the webhook and the API to make sure that the external service and our own service is always in sync?

### E - Slicing - No implementation needed
Please describe how you would slice the implementation of the above tasks into smaller services if you would have to implement them in a microservice architecture.
Please think about the logic of the above services a little bigger to make the task more interesting.

### F - Deployment & Operations - No implementation needed
Please describe how you would deploy the above services and how you would operate them in a production environment.
