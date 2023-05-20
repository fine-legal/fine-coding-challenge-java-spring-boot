### A - Model

- DealA and DealB inherit form AbstractDeal. Because they require polymorphic behaviour in the rest of the program.
  The result is that DealA and DealB share one "big" table in the database.

- User entity gets a table named "user_table" in the database. Because the word "user" is reserved in H2.

- Deal entities have a foreign key field to User. This is what the @ManyToOne and @OneToMany annotations are for.
  The column with the foreign keys is called "user_id". That is what the @JoinColumn annotation is for.

- Use FetchType.LAZY for @ManyToOne and @OneToMany. Simply because there is no good reason to do it differently.
  See: https://stackoverflow.com/a/27520593


