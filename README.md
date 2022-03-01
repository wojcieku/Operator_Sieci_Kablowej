# Operator_Sieci_Kablowej
This is a client's web application for database designed and implemented for cable operator as a project for studies. 
# Project Description
Main goals were:
- implementation of basic CRUD operations
- support for different access abilities and appearance of the application depending on role of logged in user (in this case admin and client roles were distinguished)
- creation of basic appearance of web page
- error handling
<!--><!-->
Technologies used:
- Java
- Spring Boot, Spring Web MVC - basic configuration of application and server
- Spring Security - supporting login/registration operations and access management
- Oracle Database
- JDBC - connection between server and database
- JUnit - basic unit tests of implemented functionalities
- Thymeleaf - creation of views by server (mapping data to and from HTML files)
- HTML
- CSS
- Intellij IDEA Ultimate - IDE used for implementing and testing
<!-->
The application allows to view, edit, add and delete data from database that it is connected to. Admin has access to all tables and all operations, 
whereas client can access only his own data and perform only bunch of operations (for example he can sign an agreement, but he cannot edit nor delete it). 
Access is controlled by Spring Security and user can registrate or simply log in, if he has an existing account. Authentication is based on data in database; all passwords are hashed using bcrypt function.
In most cases displayed data is retrieved from multiple tables and in one case from tables that are extension for table storing data about offers (Internet, TV, telephony).
