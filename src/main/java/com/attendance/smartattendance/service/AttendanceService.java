package com.attendance.smartattendance.service;

import com.attendance.smartattendance.model.Attendance;
import com.attendance.smartattendance.model.User;
import com.attendance.smartattendance.repository.AttendanceRepository;
import com.attendance.smartattendance.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final UserRepository userRepository;

    public AttendanceService(AttendanceRepository attendanceRepository,
                             UserRepository userRepository) {
        this.attendanceRepository = attendanceRepository;
        this.userRepository = userRepository;
    }

    // ✅ MARK ATTENDANCE
    public String markAttendance(Integer userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        LocalDate today = LocalDate.now();

        if (attendanceRepository.findByUserAndDate(user, today).isPresent()) {
            return "Attendance already marked for today";
        }

        Attendance attendance = new Attendance();
        attendance.setUser(user);
        attendance.setDate(today);
        attendance.setStatus("PRESENT");

        attendanceRepository.save(attendance);
        return "Attendance marked successfully";
    }

    // ✅ GET ATTENDANCE BY USER
    public List<Attendance> getAttendanceByUser(Integer userId) {
        return attendanceRepository.findByUserUserId(userId);
    }
}
