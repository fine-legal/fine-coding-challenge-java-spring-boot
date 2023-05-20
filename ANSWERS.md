### A - Model

- DealA and DealB inherit form AbstractDeal. Because they require polymorphic behaviour in the rest of the program.
  The result is that DealA and DealB share one "big" table in the database.

- User entity gets a table named "user_table" in the database. Because the word "user" is reserved in H2.

- Deal entities have a foreign key field to User. This is what the @ManyToOne and @OneToMany annotations are for.
  The column with the foreign keys is called "user_id". That is what the @JoinColumn annotation is for.

- Use FetchType.LAZY for @ManyToOne and @OneToMany. Simply because there is no good reason to do it differently.
  See: https://stackoverflow.com/a/27520593.
  BUT one has to be careful to not try and fetch a user's deals outside of a database transaction!

### B - Service / API

- Minimal Zipcode service (hardcoded and hacky) and a fake Court service

- Core service tests written before the implementation. 
  Tests are a bit minimal: Only checking a few data fields. They should check everything.
  Also we are assuming that certain fields are nullable in the database, which they may not be in reality.

- In the tests we're using a mock for the CourtService, because this is an external service. 
  Check this service by verifying the interaction with the mock.

- Controller implementation: Logging has been omitted to save time.

- TODO: Better logging in case client gives a JSON payload with invalid deal type or invalid deal status.
  But Spring Boot already handles these as a 400 Bad Request.

- TODO: Omit fields in JSON response objects that are NULL in the database. Especially important for returning deals,
  since different deal types are possible.

### C - Client for external service

- New service not actually connected to the core service, because the external court data API doesn't actually exist.

- TODO: Do something smarter in case of problems with the connection (e.g. use resilience4j).

- TODO: Write a WireMock test. 

### D - E - F

- Out of time. Will be happy to discuss on Tuesday.

### Final Remark

- Spring Boot 3 requires a JDK 17 to run. The checked-in .idea folder specifies a JDK 11.
  I left it as-is, but the JDK probably needs to be changed.
