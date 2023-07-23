# Task

## A

- A POJO (Spring Entity) to represent each type here as they appear in the database. DealA, DealB, Lead, User

- DealA and DealB extend an abstract class Deal as they share four properties.

- User extends Lead as it contains two more properties. I am not convinced this is the best way to organize the data because a "User" doesn't feel like a "Lead". This just seemed like an easy way to structure the data in this simple example. Perhaps with more functionality, these should not be abstracted together

- These will need to be represented in the database as well. A 'Leads' table will represent the leads. When a lead is converted, an entry in the 'Users' table will be created. The 'Conversions' table will gain an entry that links the primary key of the user to the existing lead.

- *update* When it came to adding the POST path to /leads/{id}/conversion, I had a change of heart. User shouldn't extend Lead. Any time you would want to retrieve a Lead, you must check that it doesn't have an entry in the "conversions table". While this is doable, its just simpler if Users don't exist in the leads table in any capacity. I am removing the Conversions table and separating Leads and Users.

- The types should all be marked with @Entity to represent their DB tables. Names of tables specified

## B

- I am making use of Spring's @GetMapping annotation.

- First, I am building the functionality to simply get a Lead with an ID

- Get request comes in and the LeadEndpoint class hands the request off to LeadService. Leads are stored in the database so LeadService asks LeadRepository to query the database. LeadRepository makes use of the spring JpaRepository interface which comes with some useful pre-built queries.

- Before sending back the response, a DTO class (leadDTO) is used to decide which fields should be sent back in the response.

- Getting all leads regardless of ID at /leads works similarly but makes use of the JpaRepository findAll query

- Creating a new lead makes use of the JpaRepository save

- Converting a lead to a user has a few steps. First LeadEndpoint takes a post to /leads/{id}/convert. If a lead is found with that id then a user is created. This user has the same information as the lead plus a state and court (determined by a simple mapping with test data). After the user is succesfully created, the lead is deleted and the new user is returned in the response body

## Remaining B-F

- Due to time, I will not be implementing any more. Will prepare to discuss the rest of the challenge.
