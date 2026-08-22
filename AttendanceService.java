package com.dayflow.hrms.service;

import com.dayflow.hrms.entity.Attendance;
import com.dayflow.hrms.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    // Get all attendance records
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    // Get attendance by ID
    public Optional<Attendance> getAttendanceById(Long id) {
        return attendanceRepository.findById(id);
    }

    // Get attendance for an employee
    public List<Attendance> getEmployeeAttendance(Long employeeId) {
        return attendanceRepository.findByEmployeeId(employeeId);
    }

    // Mark attendance
    public Attendance markAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    // Update attendance
    public Attendance updateAttendance(Long id, Attendance updatedAttendance) {

        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Attendance record not found"));

        attendance.setDate(updatedAttendance.getDate());
        attendance.setStatus(updatedAttendance.getStatus());
        attendance.setCheckIn(updatedAttendance.getCheckIn());
        attendance.setCheckOut(updatedAttendance.getCheckOut());

        return attendanceRepository.save(attendance);
    }

    // Delete attendance
    public void deleteAttendance(Long id) {

        if (!attendanceRepository.existsById(id)) {
            throw new RuntimeException("Attendance record not found");
        }

        attendanceRepository.deleteById(id);
    }
}