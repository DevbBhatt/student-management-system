# Student Management System

A simple Java-based Student Management System using Spring Boot, H2 Database, and Lombok.  
This project demonstrates basic CRUD (Create, Read, Update, Delete) operations for managing student data.

## Features
- Add new students
- Update existing student details
- Delete students
- View all students
- Uses H2 in-memory database
- Implements Lombok for cleaner code
- Email validation included

## Technologies Used
- **Java 21**
- **Spring Boot**
- **H2 Database**
- **Lombok**
- **Maven** for dependency management


## Setup & Installation
1. Clone the repository:  
   ```bash
   git clone https://github.com/your-username/student-management-system.git
   
2. Build the project:
   mvn clean install

3. Run the Spring Boot application:
   mvn spring-boot:run


**API Endpoints**

| Method | Endpoint         | Description         |
| ------ | ---------------- | ------------------- |
| GET    | `/students`      | Get all students    |
| GET    | `/students/{id}` | Get student by ID   |
| POST   | `/students`      | Add new student     |
| PUT    | `/students/{id}` | Update student info |
| DELETE | `/students/{id}` | Delete student      |


**Project Structure**

src/main/java
 └─ com.example.sms
     ├─ controller     # REST API endpoints
     ├─ model          # Student entity
     ├─ repository     # Spring Data JPA repository
     ├─ service        # Business logic
     └─ StudentManagementSystemApplication.java


