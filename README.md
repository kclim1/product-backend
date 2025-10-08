# Product Backend API

A modular, production-ready RESTful API built with Spring Boot, PostgreSQL, and Terraform-automated AWS EC2 deployment.
This service provides CRUD operations for managing products, complete with DTO pattern, pagination, and global exception handling.

<hr>

### Features
* Controller–Service–Repository architecture for clean separation of concerns.
* DTO pattern for decoupled entity-to-response mapping.
* Pagination support using Spring Data Pageable.
* Centralized global exception handler for consistent error responses.
* Deployed on AWS EC2 via Docker, GitHub Actions CI/CD, and Terraform for automated lifecycle management.
* Elastic IP configuration for stable SSH and deployment access.

<hr>

### Tech Stack
<table>
  <tr>
    <th>Category</th>
    <th>Technologies</th>
  </tr>
  <tr>
    <td><b>Language</b></td>
    <td>Java 17</td>
  </tr>
  <tr>
    <td><b>Framework</b></td>
    <td>Spring Boot 3.x</td>
  </tr>
  <tr>
    <td><b>Database</b></td>
    <td>PostgreSQL</td>
  </tr>
  <tr>
    <td><b>ORM & Validation</b></td>
    <td>Spring Data JPA, Hibernate, Jakarta Validation</td>
  </tr>
  <tr>
    <td><b>Infrastructure & DevOps</b></td>
    <td>Terraform, AWS EC2, AWS ECR, Docker, Docker Compose</td>
  </tr>
  <tr>
    <td><b>CI/CD</b></td>
    <td>GitHub Actions</td>
  </tr>
  <tr>
    <td><b>Testing</b></td>
    <td>Postman (manual), JUnit 5 </td>
  </tr>
  <tr>
    <td><b>Others</b></td>
    <td>AWS CLI, Shell scripting</td>
  </tr>
</table>

<hr>

### API Documentation

#### Base URL : /api/v1/products

### Get All Products

#### GET /api/v1/products

Description:
Returns a paginated list of all products.
<hr>

#### Get Product by ID

GET /api/v1/products/{id}

Description:
Fetch details of a specific product by its UUID.
<hr>

#### Add New Product

POST /api/v1/products

Description:
Create a new product entry.
<hr>

Update Product by ID

PUT /api/v1/products/{id}

Description:
Update details of an existing product by UUID.

<hr>

#### Delete Product by ID

DELETE /api/v1/products/{id}

Description:
Delete a product record from the database.

<hr>

#### Error Handling Example

All exceptions are handled by a global @RestControllerAdvice that returns a standardized ErrorResponse DTO:
```
{
  "message": "Product with id not found",
  "error": "Not Found",
  "statusCode": 404,
  "path": "/api/v1/products/d32b4d58-d692-441c-81b5-0344b54ad231",
  "timeStamp": "2025-10-07T13:02:03.603503083Z"
}
```


