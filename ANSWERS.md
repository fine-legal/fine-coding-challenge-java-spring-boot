# Task A

- A POJO to represent each type here. DealA, DealB, Lead, User
- DealA and DealB extend an abstract class Deal as they share four properties.

- User extends Lead as it contains two more properties. I am not convinced this is the best way to organize the data because a "User" doesn't feel like a "Lead". This just seemed like an easy way to make POJOs. Perhaps with more functionality, these should not be abstracted together
- I will later make it easy to convert JSON objects into all of these classes.
