# Banking Demo Project

This is a simple Spring Boot project created for an assignment. It includes basic Customer and Account APIs with an H2 in-memory database.

## How to Run
- Open the project in STS/Eclipse/IntelliJ  
- Run `BankingDemoApplication`  
- App runs on: http://localhost:8080

## Main APIs
- GET /api/customers  
- POST /api/customers  
- PUT /api/customers/{id}  
- DELETE /api/customers/{id}  
- POST /api/accounts/create?customerId={id}

## Postman Collection
The file **banking-demo.postman_collection.json** contains all API requests for testing.

## Note
This project is for learning purposes only.
