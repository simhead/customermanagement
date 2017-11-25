# Customer Management API implementation by using Swagger Jersey generated server

## SOLUTION REQUIREMENT:
- Design a RESTful API using RAML that contains a single resource, customers, and allows the following:
	- List customers
	- Create a new customer
	- Update a customer
	- Deletes a customer
You may constrain the customer object to first name, last name and addresses, and the format to JSON.

### USECASE:
1. A consumer may periodically (every 5 minutes) consume the API to enable it (the consumer) to maintain a copy of the provider API's customers (the API represents the system of record)
2. A mobile application used by customer service representatives that uses the API to retrieve and update the customers details
3. Simple extension of the API to support future resources such as orders and products

## APPROACH:
- Design:> used https://studio.restlet.com studio to define/design API specification
- Development:> 
	- restlet studio to export to RAML 1.0
	- eclipse for development IDE
	- GIT for source code version control
	- swagger-codegen for Java (JAX-RS) server stubs
	- Jetty server for handling API request/response
	- maven for building and running server environment
	- json-simple library for handing json string
	- mysql server for data storage
	- docker to run mysql server as a containerized DB server
	- mysql-connect and JPA (Java Persistence API) libraries for DB connection
- Test:> used Postman for REST API testing:
	- http://localhost:8080/listCustomers for GET with HTTP return code 200 for successful extraction
	- http://localhost:8080/addCustomer for POST with HTTP return code 201 for successful insertion
	- http://localhost:8080/customer/{customerId} for PUT with HTTP return code 200 for successful update
	- http://localhost:8080/customer/{customerId} for DELETE with HTTP return code 204 for successful deletion
	- http://localhost:8080/customer/{customerId} for GET with HTTP return code 200 for successful extraction

```
GIT location: https://github.com/simhead/customermanagement
```
## Usage Overview
This server was generated by the [swagger-codegen](https://github.com/swagger-api/swagger-codegen) project. By using the 
[OpenAPI-Spec](https://github.com/swagger-api/swagger-core/wiki) from a remote server, you can easily generate a server stub.  This
is an example of building a swagger-enabled JAX-RS server.

This example uses the [JAX-RS](https://jax-rs-spec.java.net/) framework.

To run the server, please execute the following:

```
mvn clean package jetty:run
```

You can then view the swagger listing here:

```
http://localhost:8080/swagger.json
```

## TODO (Future expansion):
- slow db connection due to server being located in remote US - only applicable for first call, subsequent calls are using cached dB connection.	
- Products and Orders are defined in the placeholder for future expansion and use customerID for primary key relationship.

## Deliverables:
- The RAML spec itself
	- DONE - ./RAML/customer.raml
- Commentary on the interaction of use case 1 with the API
	- TBD
- Commentary on interaction of use case 2 with the API
	- TBD
- Commentary on how the API could be extended for use case 3
	- TBD
- Commentary on any 'interesting' design decisions you made (and alternative options considered)
	- TBD
- Link to git repository where the code is stored along with the README.md
	- DONE - https://github.com/simhead/customermanagement/blob/master/README.md
