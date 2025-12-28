CREATE DATABASE smart_attendance;
USE smart_attendance;

CREATE TABLE users (
	user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    roll_no VARCHAR(50)
    );
    
CREATE TABLE attendance(
	attendance_id INT PRIMARY KEY AUTO_INCREMENT,  
    user_id INT,
    date DATE,
    status VARCHAR(20),
    FOREIGN KEY(user_id) REFERENCES users(user_id)
    );

SHOW DATABASES;
SHOW TABLES;
SHOW TABLES;


USE smart_attendance;
USE smart_attendance;
DROP TABLE attendance;
use smart_attendance;
use smart_attendance;
