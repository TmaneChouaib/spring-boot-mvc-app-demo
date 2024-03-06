<h2 align="center">spring-Boot-MVC Demo - Company app</h2>

## 🔎 Table of Contents:

- [About](#about)
- [Project Objective](#objective)
- [Features](#features)
- [Architecture](#architecture)
- [Data Flow](#data-flow)
- [Used Technologies](#used-technologies)
- [Configuration](#configuration)
- [Project Implementation](#project-implementation)
- [Contacts](#contacts)


## <a name="about"></a> 📎 About:

- This Spring Boot MVC Demo is designed to showcase the implementation of a basic Spring Boot application using the Model-View-Controller (MVC) architectural pattern.

## <a name="objective"></a> 📎 Project Objective:

- The primary objective of this project is to provide a simple yet comprehensive example building a web application with Spring Boot,
focusing on MVC design pattern.

## <a name="features"></a> 📎 Features:

- This demo application includes features such as:
- CRUD operations for managing companies.
- Search functionality to filter companies by CEO name or companies Name.
- User-friendly web interface using Thymeleaf templates.

## <a name="architecture"></a> 📎 Architecture - MVC(Model-View-Controller) Pattern:

<img src="public-doc/mvc.png" align="center">

- Overview :
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
- MySQL Database

## <a name="configuration"></a> 📎 Configuration:

- **Prerequisites**:
  - Before running the application, ensure you have the following installed:
  - JAVA Development Kit (JDK)
  - Maven
  - MySQL Server

- **Configuration Settings**:
- Database configuration can be found in the 'application.properties' file, where you can specify the database connection details.

## <a name="project-implementation"></a> 📎 Project Implementation:

- **Model**:
  - Models represent the 'Company' entity used in this application in which is annotated with @Entity to define that the class is mapped to a table in the database.

- **Repository**:
  - Repositories provide an interface for database operations, allowing the application to interact with the database using Spring Data JPA.

- **Service**:
  - Services contain the business logic of the application including methods for CRUD operations on companies.

- **Controller**:
  - The controllers handle HTTP requests and define endpoint mappings for the various operation to create, update delete or listing a company.

- **Database**:
  - The application uses MySql as the database backend, and database schema management is handled automatically by Hibernate based on entity mappings.

## <a name="contacts"></a> 📎 Contacts:
 
- For any inquires or feedback regarding this project, please contact me on chouaib.tmane@hotmail.com.

### End

----------------------------------------------------------------------------------------------------------

<p align="center">
<img src="public-doc/Brand.png">
</p>