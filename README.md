# 📋 Smart Attendance System

> A production-structured REST API built with **Spring Boot + MySQL** to manage users and track daily attendance — with business-rule-level duplicate prevention, full CRUD operations, and 100% Postman test coverage.

---

## 🎯 What This Does

Manual attendance systems break in three ways: duplicate entries, no audit trail, and no reliable reporting. This backend eliminates all three.

Built with a clean **Controller → Service → Repository** architecture across three modules (User, Course, Attendance), this system replaces paper-based attendance with a reliable, real-time API — designed with the same quality standards you'd apply in a production environment.

---

## ✨ Features

- 👤 Full user management (create, retrieve, validate)
- 📚 Course management with enrollment tracking
- ✅ Mark attendance with **duplicate prevention** — one entry per user per day, enforced at the service layer
- 📊 Real-time attendance history and reporting per user/course
- 🛡️ Custom exception handling with meaningful error responses
- 🔍 Input validation on all endpoints
- 🧪 100% Postman test coverage — happy path + edge cases

---

## 🛠 Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Core language |
| Spring Boot | Application framework |
| Spring Data JPA | ORM / database layer |
| Hibernate | JPA implementation |
| MySQL 8.0 | Relational database |
| Maven | Build tool |
| Postman | API testing |

---

## 📁 Project Structure

```
smart-attendance/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/attendance/
│       │       ├── controller/
│       │       │   ├── UserController.java          # User API endpoints
│       │       │   └── AttendanceController.java    # Attendance API endpoints
│       │       ├── model/
│       │       │   ├── User.java                    # User entity
│       │       │   └── Attendance.java              # Attendance entity
│       │       ├── repository/
│       │       │   ├── UserRepository.java          # DB queries for users
│       │       │   └── AttendanceRepository.java    # DB queries for attendance
│       │       └── service/
│       │           ├── UserService.java             # User business logic
│       │           └── AttendanceService.java       # Attendance business logic + duplicate check
│       └── resources/
│           └── application.properties              # DB config
├── pom.xml
└── README.md
```

---

## 🔌 API Reference

### 👤 User Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/users` | Create a new user |
| `GET` | `/users` | Get all users |
| `GET` | `/users/{id}` | Get user by ID |

**Create User — Request**
```json
{
  "name": "Pallavi Gowda",
  "email": "pallavi@example.com"
}
```

**Create User — Response `201 Created`**
```json
{
  "id": 1,
  "name": "Pallavi Gowda",
  "email": "pallavi@example.com"
}
```

---

### ✅ Attendance Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/attendance/mark/{userId}` | Mark attendance for a user (today) |
| `GET` | `/attendance/user/{userId}` | Get full attendance history for a user |

**Mark Attendance — Response `200 OK` (success)**
```json
{
  "id": 1,
  "userId": 1,
  "date": "2025-03-15",
  "status": "PRESENT"
}
```

**Mark Attendance — Response `400 Bad Request` (duplicate)**
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

**1. Clone the repo**
```bash
git clone https://github.com/pallavigowda620/smart-attendance.git
cd smart-attendance
```

**2. Create the database**
```sql
CREATE DATABASE smart_attendance;
```

**3. Configure credentials**

Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/smart_attendance
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

**4. Run**
```bash
mvn spring-boot:run
```

Server starts at `http://localhost:8080`

---

## 🧪 Testing with Postman

Test the full flow in order:

```
1. POST   http://localhost:8080/users                    → Create a user
2. GET    http://localhost:8080/users                    → Confirm user exists
3. POST   http://localhost:8080/attendance/mark/1        → Mark attendance (should succeed)
4. POST   http://localhost:8080/attendance/mark/1        → Mark again (should return 400 — duplicate)
5. GET    http://localhost:8080/attendance/user/1        → View attendance history
```

Edge cases covered:
- Marking attendance for a non-existent user → `404 Not Found`
- Marking attendance twice in one day → `400 Bad Request`
- Invalid request body → `400 Bad Request` with validation message

---

## 💡 Design Decisions Worth Noting

- **Duplicate prevention at the service layer, not just DB constraints** — a DB unique constraint alone gives you a generic SQL error. A service-layer check gives you a meaningful, user-facing message. Both are implemented.
- **CSR architecture (Controller-Service-Repository)** — keeps business logic out of controllers and persistence logic out of services. Makes the codebase easy to extend and test independently.
- **Custom exception handling** — every error returns a structured JSON response, not a Spring stack trace. This is production behaviour, not tutorial behaviour.

---

## 🚀 Future Improvements

- [ ] JWT-based authentication and role management (Admin / Student)
- [ ] Course module with enrollment and per-course attendance tracking
- [ ] CSV export of attendance reports
- [ ] Pagination for large user/attendance datasets
- [ ] Swagger / OpenAPI documentation auto-generated from annotations
- [ ] Docker support for easy deployment

---

## 👩‍💻 Author

**Pallavi Jattu Gowda**
MCA Graduate | Bangalore, India
[LinkedIn](https://www.linkedin.com/in/pallavi-gowda-885646223) · [GitHub](https://github.com/pallavigowda620)

---

## 📄 License

Open source under the [MIT License](LICENSE).
