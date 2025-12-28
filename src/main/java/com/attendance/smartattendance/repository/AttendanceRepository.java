package com.attendance.smartattendance.repository;

import com.attendance.smartattendance.model.Attendance;
import com.attendance.smartattendance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    Optional<Attendance> findByUserAndDate(User user, LocalDate date);

    // ✅ FOR GET API
    List<Attendance> findByUserUserId(Integer userId);
}
