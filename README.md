<h2 align="center">spring-Boot-MVC Demo - Company app</h2>

## 🔎 Table of Contents:

- [About](#about)
- [Project Objective](#objective)
- [Features](#features)
- [Endpoints](#endpoints)
- [Architecture](#architecture)
- [Data Flow](#data-flow)
- [Used Technologies](#used-technologies)
- [Project Structure](#project-structure)
- [Contacts](#contacts)


## <a name="about"></a> 📎 About:

- This Demo is designed to showcase the implementation of a basic Spring Boot application using the Model-View-Controller (MVC) architectural pattern.

## <a name="objective"></a> 📎 Project Objective:

- The primary objective of this project is to provide a simple yet comprehensive example of building a web application with Spring Boot,
focusing on MVC design pattern. While the example used in this demo revolves around managing a company, the primary focus is on demonstrating the capabilities of
Spring Boot and MVC architecture rather than addressing specific business needs, The goal is to provide developers with insights into how to effectively leverage these technologies
to develop a robust and scalable web application adhering to best practices and conventions such as Dependency Inversion Principle (DIP),Dependency Injection (DI),Open/Closed Principle (OCP),
Use of Constants and more. These principles and practices ensure maintainability, modularity and scalability which makes the application easier to maintain and extend in the long run.

## <a name="features"></a> 📎 Features:

- This demo application includes features such as:
  - CRUD operations for managing companies.
  - Search functionality to filter companies by their Names.
  
## Endpoints :

- Bellow is a table representing the endpoints available in this demo application after it has been launched:

| Endpoint                                | HTTP Method | Description                                             |
|-----------------------------------------|-------------|---------------------------------------------------------|
| /companies                              | GET         | Display the home page with paginated list of companies  |
| /companies/page/{pageNum}               | GET         | Display paginated list of companies                     |
| /companies/{id}                         | GET         | Display details of a specific company                   |
| /companies/new                          | GET         | Display form to add a new company                       |
| /companies                              | POST        | Save a new company                                      |
| /companies/{id}/edit                    | GET         | Display form to edit an existing company                |
| /companies/{id}/update                  | POST        | Update an existing company                              |
| /companies/{id}/delete                  | GET         | Delete a specific company                               |


## <a name="architecture"></a> 📎 Architecture - MVC (Model-View-Controller) Pattern:

<img src="public-doc/mvc.png" align="center">

### Overview :
- The architecture of this demo follows the MVC design pattern, separating the application into three main components: Model, View and Controller.

- The Model represents the data and business logic, the View handles the presentation layer, and the Controller manages user input and coordinates interactions between Model and Views.

## <a name="data-flow"></a> 📎 Data flow:

<img src="public-doc/Repository_flow_diagram.jpg" align="center">

- The data flow in this application follows the typical request-response cycle of a web application,
where requests are received by the controller, processed by the service and stored in the MySQL database using Spring Data Hibernate and JDBC.

## <a name="used-technologies"></a> 📎 Used technologies:

- Spring Boot 
- Spring MVC
- Spring Data JPA
- Thymeleaf
- Bootstrap 5
- MySQL Database


## <a name="project-structure"></a> 📎 Project Structure:

```Bash
spring-Boot-MVC-demo/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── Tmane/
│   │   │           └── springBootMVCDemo/
│   │   │               ├── controller/
│   │   │               │   └── CompanyController.java
│   │   │               ├── entity/
│   │   │               │   └── Company.java
│   │   │               ├── enums/
│   │   │               │   └── Sector.java
│   │   │               ├── repository/
│   │   │               │   └── CompanyRepository.java
│   │   │               ├── service/
│   │   │               │   ├── CompanyService.java
│   │   │               │   └── impl/
│   │   │               │       └── CompanyServiceImpl.java
│   │   │               └── SpringBootDemoApplication.java
│   │   │
│   │   ├── resources/
│   │   │   ├── static/
│   │   │   │   └── css/
│   │   │   │       └── styles.css
│   │   │   ├── templates/
│   │   │   │   ├── companies/
│   │   │   │   │   ├── addCompany.html
│   │   │   │   │   ├── companies.html
│   │   │   │   │   ├── company.html
│   │   │   │   │   └── editCompany.html
│   │   │   │   └── template.html
│   │   │   └── application.properties
│   │   │
│   └── test/
│       └── java/
│           └── com/
│               └── tmane/
│                   └── springBootMVCDemo/
│                       └── SpringBootMvcDemoApplicationTests.java
├── public-doc/
│   ├── mvc.png
│   └── Repository_flow_diagram.jpg
│
├── pom.xml
└── README.md
 ```

### Note:

- The project structure of this demo based Spring boot mvc is organized to maintain a clear separation of concerns and facilitate modular 
development. Below is an overview of the main components:

| Component              | Description                                                                                                                                                                                                                                                                                                                                                                                     |
|------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| pom.xml                | The `pom.xml` file contains project configuration and dependencies managed by Apache Maven. It specifies required dependencies such as Spring Boot Starter, Thymeleaf, Spring Data JPA, MySQL Connector, and Bootstrap.                                                                                                                                                                         |
| application.properties | The `application.properties` file holds configuration properties for the Spring Boot application. It allows configuring settings like database connection details, server port, etc. For example, it specifies the datasource URL, username, and password for MySQL database connection.                                                                                                        |
| Entity                 | The Entity represents the 'Company' entity used in the application. Annotated with '@Entity', these classes define the structure of data stored in the database. Each entity class corresponds to a table in the database and contains fields representing entity attributes.                                                                                                                   |
| Repository             | The Repository layer provides an interface for database operations, allowing the application to interact with the database using Spring Data JPA. These interfaces extend JpaRepository and provide methods for CRUD operations on entities.                                                                                                                                                    |
| Service                | The Service layer contains the business logic of the application, including CRUD operations on companies. The service layer encapsulate the application's business logic and handle creating, updating, deleting, and retrieving data. They interact with the repository layer to perform database operations.                                                                                  |
| Controller             | The Controller layer contains classes that handle HTTP requests and define endpoint mappings for various operations such as creating, updating, deleting, or listing a company. These classes are annotated with @Controller or @RestController and define methods to handle incoming requests. They interact with the service layer to execute business logic and return appropriate responses. |
| Templates              | Templates, typically implemented using Thymeleaf, define the views presented to users in the web application. They contain HTML markup along with Thymeleaf attributes to dynamically render data from the backend. Stored in the 'src/main/resources/templates' directory, these templates are used by controllers to generate HTML responses sent to clients.                                 |
| Database               | The application uses MySQL as the database backend, and database schema management is handled automatically by `Hibernate` based on entity mappings.                                                                                                                                                                                                                                             |

## <a name="contacts"></a> 📎 Contacts:
 
- For any inquires or feedback regarding this project, please contact me on: 
  - chouaib.tmane@hotmail.com.

  

### End

----------------------------------------------------------------------------------------------------------

<p align="center">
<img src="public-doc/Brand.png">
</p>