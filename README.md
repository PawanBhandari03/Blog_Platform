# Blog Platform

A full-stack blog management platform built using Spring Boot that allows users to create, manage, and interact with blog posts through a secure and user-friendly interface.

## Features

* User Registration and Login
* Secure Authentication and Authorization using Spring Security
* Create, Edit, Delete, and View Blog Posts
* User Profile Management
* Role-Based Access Control
* Responsive User Interface
* Database Integration with MySQL
* Form Validation and Error Handling
* RESTful Architecture

## Tech Stack

### Backend

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* Maven

### Database

* MySQL

### Frontend

* HTML
* CSS
* Bootstrap
* Thymeleaf

### Tools

* Git
* GitHub
* IntelliJ IDEA

## Project Structure

```text
src
├── main
│   ├── java
│   │   ├── controller
│   │   ├── service
│   │   ├── repository
│   │   ├── model
│   │   └── config
│   └── resources
│       ├── templates
│       ├── static
│       └── application.properties
```

## Installation

1. Clone the repository

```bash
git clone https://github.com/PawanBhandari03/Blog_Platform.git
```

2. Navigate to the project directory

```bash
cd Blog_Platform
```

3. Configure MySQL in `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blogdb
spring.datasource.username=root
spring.datasource.password=your_password
```

4. Run the application

```bash
mvn spring-boot:run
```

5. Open your browser

```text
http://localhost:8080
```

## Future Enhancements

* JWT Authentication
* Comment System
* Like and Share Features
* Rich Text Editor
* Image Upload Support
* Search and Filtering
* Email Verification
* Admin Dashboard
* REST API Documentation

## Author

Pawan Bhandari

GitHub: https://github.com/PawanBhandari03

## License

This project is intended for educational and learning purposes.
