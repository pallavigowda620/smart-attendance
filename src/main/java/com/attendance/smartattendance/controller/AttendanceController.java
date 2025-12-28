package com.attendance.smartattendance.controller;

import com.attendance.smartattendance.model.Attendance;
import com.attendance.smartattendance.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/mark/{userId}")
    public String markAttendance(@PathVariable Integer userId) {
        return attendanceService.markAttendance(userId);
    }

    // ✅ GET API
    @GetMapping("/user/{userId}")
    public List<Attendance> getAttendance(@PathVariable Integer userId) {
        return attendanceService.getAttendanceByUser(userId);
    }
}
