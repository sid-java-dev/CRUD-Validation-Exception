Problem Designing:
Create User entity with name, email, mobile, gender, age, nationality

1.Create User: Create a new user with the given details.
Endpoint: /api/users
Method: POST
Request Body: User object
Response: 201 Created with the created User object

2.Get User by ID: Retrieve a user by their ID.
Endpoint: /api/users/{id}
Method: GET
Path Variable: id (integer)
Response: 200 OK with the retrieved User object, or 404 Not Found if the user does not exist

3.Update User: Update an existing user with the given details.
Endpoint: /api/users/{id}
Method: PUT
Path Variable: id (integer)
Request Body: User object
Response: 200 OK with the updated User object, or 404 Not Found if the user does not exist

4.Delete User: Delete a user by their ID.
Endpoint: /api/users/{id}
Method: DELETE
Path Variable: id (integer)
Response: 204 No Content if the user is deleted successfully, or 404 Not Found if the user does not exist

5.Get All Users: Retrieve a list of all users.
Endpoint: /api/users
Method: GET
Response: 200 OK with a list of all User objects
*****************
Validation Requirements:

name should not be null or empty
email should be a valid email address
mobile should be a 10-digit number
age should be between 18 and 60 (inclusive)
nationality should not be null or empty
*******************
Exception Handling:

Handle NullPointerException when creating or updating a user with null values
Handle IllegalArgumentException when creating or updating a user with invalid values (e.g., empty name, invalid email, etc.)
Handle RuntimeException when deleting a user that does not exist
Implement the above CRUD operations using Spring Boot and Hibernate, and ensure that the validation requirements are met.
