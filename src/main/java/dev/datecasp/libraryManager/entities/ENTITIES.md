# Entities package

This package contains the classes that represent the entities in the database.

There is one class for each entity, stored in a database table, and based in the real life models we need to manage in the library.

* Entities:
  * Books -> Model for the books.
  * Users -> Model for the users.
  * OldUsers -> Model to represent the old users of a concrete book.
  * Categories -> Model for the categories of the books.
  * GrantedUsers -> Model for the authorities users that are allowed to access the database.

### Relations between entities

There are relations between `Users` and `Books` and between `Books` and `Categories`. 

`GrantedUsers` has no relationship with the rest of the entities.

* Users and Books -> There is a N to M relationship between theese entities. A user can has three books and a book can 
has many users, the actual user and past users that have had already the book previously. I use a flag to identify the actual user.
* Books and Categories -> There is a N to M relationship too. A book can has many categories and a category many books.




