# Entities package

This package contains the classes that represent the entities in the database.

There is one class for each entity, stored in a database table, and based in the real life models we need to manage in the library.

* Entities:
  * ``Book`` -> Model for the books.
  * ``User`` -> Model for the users of the library.
  * ``OldUser`` -> Model to represent the old users of a concrete book.
  * ``GrantedUser`` -> Model for the authority users that are allowed to access the database.

### Relations between entities

There are relations between all the entities except `GrantedUser`. 

`GrantedUser` has no relationship with the rest of the entities.

* User and Book -> There is a N to M relationship between theese entities. A user can has three books and a book can 
has many users, the actual user and past users that have had already the book previously. 
* OldUser and Book -> There is also a N to M relationship as this represent a historical of the relationship between User and Book.




