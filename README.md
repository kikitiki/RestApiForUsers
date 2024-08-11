# RestApiForUsers

This is a REST API for managing users and there checking accounts.
The api allows creating,retrieving,updating and deleting users 
as well as creating and retrieving checking accounts associated with users.

##Run the application
Open the Project in an IDE such as IntelliJ IDEA or Eclipse.
Navigate to the directory where you extracted the project and select the root folder of the project.

##Database Configuration
Set up the application.properties file in  the src/main/resources directory with the appropriate parameters for your MSSQL .

##Testing the API

-Create user 
POST /api/users
Request body (JSON)
{
"email": "john.doe@example.com",
"firstName": "John",
"lastName": "Doe"
}

-Get user
GET /api/users/getUserById/{id}

-Update user
PUT /api/users/update/{id}
Request body (JSON)
{
"email": "john.doe@example.com",
"firstName": "John",
"lastName": "Doe"
}

-Delete user
DELETE /api/users/{id}

-Create Checking Account
POST /api/accounts/createAccount/{userId}
Request body (JSON)
{
"balance": 34567.99,
"accountNumber": "9988776655"
}

-Get Checking Account by User ID
GET /api/accounts/user/{id}