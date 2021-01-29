# employeeserv

## Application Overview
employeeserv is a spring boot rest application which would provide the CRUD operations for `Employee` resource.

There are three modules in this application
- employeeservApi - This module contains the interface.
	- `v1/schema/employee.json` defines the employee resource.
	- `jsonschema2pojo-maven-plugin` is being used to create `Employee POJO` from json file.
	- `EmployeeResource.java` is the interface for CRUD operations on `Employee` resource.
		- GET `/v1/bfs/employees/{id}` endpoint is defined to fetch the resource.
- employeeservImplementation - This module contains the implementation for the rest endpoints.
	- `EmployeeResourceImpl.java` implements the `EmployeeResource` interface.
- employeeservFunctionalTests - This module would have the functional tests.

## How to run the application
- Please have Maven version `3.3.3` & Java 8 on your system.
- Use command `mvn clean install` to build the project.
- Use command `mvn spring-boot:run` from `employeeservImplementation` folder to run the project.
- Use postman or curl to access `http://localhost:8080/v1/bfs/employees/1` GET endpoint. It will return an Employee resource.

## Assignment
We would like you to enhance the existing project and see you complete the following requirements:

- `employee.json` has only `name`, and `id` elements. Please add `date of birth` and `address` elements to the `Employee` resource. Address will have `line1`, `line2`, `city`, `state`, `country` and `zip_code` elements. `line2` is an optional element.
- Add one more operation in `EmployeeResource` to create an employee. `EmployeeResource` will have two operations, one to create, and another to retrieve the employee resource.
- Implement create and retrieve operations in `EmployeeResourceImpl.java`.
- Resource created using create endpoint should be retrieved using retrieve/get endpoint.
- Please add the unit tests to validate your implementation.
- Please use h2 in-memory database or any other in-memory database to persist the `Employee` resource. Dependency for h2 in-memory database is already added to the parent pom.
- Please make sure the validations are done for the requests.
- Response codes are as per rest guidelines.
- Error handling in case of failures.
- Idempotency logic is implemented to avoid duplicate resource creation.

## Assignment submission
Thank you very much for your time to take this test. Please upload this complete solution in Github and send us the link to `bfs-sor-interview@paypal.com`.

-----------------------------------------------

API's Description -
- Array list is used as in memory database
- To create a employee , array list size is used as empid.
- API field validations are done.
- Swagger is used for API documentation
  http://localhost:8085/swagger-ui.html#/
- Unit testing is done by using mockito and junit. Testing class name is 'TestEmployeeDetails'
  I have commented this class, As there is few issues. Please build and run this application.
  And, uncomment this class to review and excute testing methods.

API documentations-
- Get employee
  http://localhost:8085/employees/{empid}

- POST employee
  http://localhost:8085/addEmployeeDetails
   Post Body :
   {"firstName":"Rajesh","lastName":"Kumar","birthDate":"06-06-1988","id":"1000","address":{"line1":"D-401","line2":"Street 6","city":"Chicago","state":"Missouri","country":"USA","zipCode":"712101"}}
   Technical descrpition :
   @Empid creation is taken care by the api even though you provide empid while creating resouce it will be ignored.
   @Idempotent of Post method is taken care. You have to provide key in header.
   @Idempotent key is : idempotent-key.

- To create idempotent scenario you have to comment out line nos 26 and 27 form class EmployeeService.


I have written few below api's for my reference please ignore those.

- Get all employees
  http://localhost:8085/employees

- Update employee
  PUT : http://localhost:8085/updateEmployeeDetails/3
  Request Body :
  {"firstName":"Hello","lastName":"Kumar","birthDate":"06-06-1988","id":"3","address":{"line1":"D-401","line2":"Street 6","city":"Chicago","state":"Missouri","country":"USA","zipCode":"712101"}}