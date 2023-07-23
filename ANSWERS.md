# Task

## A

- A POJO (Spring Entity) to represent each type here as they appear in the database. DealA, DealB, Lead, User

- DealA and DealB extend an abstract class Deal as they share four properties.

- User extends Lead as it contains two more properties. I am not convinced this is the best way to organize the data because a "User" doesn't feel like a "Lead". This just seemed like an easy way to structure the data in this simple example. Perhaps with more functionality, these should not be abstracted together

- These will need to be represented in the database as well. A 'Leads' table will represent the leads. When a lead is converted, an entry in the 'Users' table will be created. The 'Conversions' table will gain an entry that links the primary key of the user to the existing lead.

- The types should all be marked with @Entity to represent their DB tables. Names of tables specified

## B

- I am making use of Spring's @GetMapping annotation.

- First, I am building the functionality to simply get a Lead with an ID

- Get request comes in and the LeadEndpoint class hands the request off to LeadService. Leads are stored in the database so LeadService asks LeadRepository to query the database. LeadRepository makes use of the spring JpaRepository interface which comes with some useful pre-built queries.

- Before sending back the response, a DTO class (leadDTO) is used to decide which fields should be sent back in the response.

- Getting all leads regardless of ID at /leads works similarly but makes use of the JpaRepository findAll query

- Creating a new lead makes use of the JpaRepository save
