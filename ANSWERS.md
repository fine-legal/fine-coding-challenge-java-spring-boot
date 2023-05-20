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
