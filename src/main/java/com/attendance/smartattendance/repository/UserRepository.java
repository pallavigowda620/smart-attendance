package com.attendance.smartattendance.repository;

import com.attendance.smartattendance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
