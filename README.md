# 📋 Smart Attendance System

A backend REST API built with **Spring Boot** and **MySQL** to manage users and track daily attendance — with built-in duplicate prevention.

---

## ✨ Features

- Create and retrieve users
- Mark attendance (restricted to **one entry per user per day**)
- View full attendance history per user
- Clean RESTful API design
- Persistent data storage with MySQL

---

## 🛠 Tech Stack

| Technology | Purpose |
|------------|---------|
| Java 17 | Core language |
| Spring Boot | Application framework |
| Spring Data JPA | ORM / database layer |
| MySQL | Relational database |
| Postman | API testing |

---

## 📁 Project Structure

```
smart-attendance-system/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/attendance/
│       │       ├── controller/
│       │       │   ├── UserController.java
│       │       │   └── AttendanceController.java
│       │       ├── model/
│       │       │   ├── User.java
│       │       │   └── Attendance.java
│       │       ├── repository/
│       │       │   ├── UserRepository.java
│       │       │   └── AttendanceRepository.java
│       │       └── service/
│       │           ├── UserService.java
│       │           └── AttendanceService.java
│       └── resources/
│           └── application.properties
└── pom.xml
```

---

## 🔌 API Endpoints

### User APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/users` | Create a new user |
| `GET` | `/users` | Get all users |

#### Create User — Request Body
```json
{
  "name": "John Doe",
  "email": "john@example.com"
}
```

#### Create User — Response
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com"
}
```

---

### Attendance APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/attendance/mark/{userId}` | Mark attendance for a user |
| `GET` | `/attendance/user/{userId}` | Get attendance history for a user |

#### Mark Attendance — Response (success)
```json
{
  "id": 1,
  "userId": 1,
  "date": "2025-01-15",
  "status": "PRESENT"
}
```

#### Mark Attendance — Response (duplicate)
```json
{
  "error": "Attendance already marked for today"
}
```

---

## ⚙️ Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+
- MySQL 8.0+

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/smart-attendance-system.git
   cd smart-attendance-system
   ```

2. **Create the database**
   ```sql
   CREATE DATABASE smart_attendance;
   ```

3. **Configure database credentials**

   Edit `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/smart_attendance
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

   The server starts at `http://localhost:8080`

---

## 🧪 Testing with Postman

Import the following requests into Postman to test the API:

1. `POST http://localhost:8080/users` — create a user
2. `GET http://localhost:8080/users` — list all users
3. `POST http://localhost:8080/attendance/mark/1` — mark attendance for user ID 1
4. `GET http://localhost:8080/attendance/user/1` — view attendance history for user ID 1

---

## 🚧 Future Improvements

- [ ] JWT-based authentication
- [ ] Admin dashboard
- [ ] Export attendance reports as CSV
- [ ] Pagination for large datasets
- [ ] Swagger / OpenAPI documentation

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
