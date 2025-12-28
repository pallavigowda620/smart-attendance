# Smart Attendance System

A backend application built using Spring Boot and MySQL to manage users and mark attendance with duplicate prevention.

## Features
- Create and fetch users
- Mark attendance (one per user per day)
- View attendance history
- RESTful APIs
- MySQL database integration

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Postman

## API Endpoints

### User APIs
- POST /users
- GET /users

### Attendance APIs
- POST /attendance/mark/{userId}
- GET /attendance/user/{userId}

## How to Run
1. Create database `smart_attendance`
2. Update DB credentials in `application.properties`
3. Run:
   mvn spring-boot:run
