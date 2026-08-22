package com.dayflow.hrms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    // Admin Dashboard
    @GetMapping("/dashboard")
    public ResponseEntity<String> getDashboard() {
        return ResponseEntity.ok("Admin dashboard data");
    }

    // Get all employees
    @GetMapping("/employees")
    public ResponseEntity<String> getAllEmployees() {
        return ResponseEntity.ok("List of all employees");
    }

    // Get employee by ID
    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<String> getEmployee(
            @PathVariable Long employeeId) {

        return ResponseEntity.ok(
                "Employee details for ID: " + employeeId);
    }

    // Delete employee
    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable Long employeeId) {

        return ResponseEntity.ok(
                "Employee deleted successfully");
    }

    // Approve leave
    @PutMapping("/leave/{leaveId}/approve")
    public ResponseEntity<String> approveLeave(
            @PathVariable Long leaveId) {

        return ResponseEntity.ok(
                "Leave approved successfully");
    }

    // Reject leave
    @PutMapping("/leave/{leaveId}/reject")
    public ResponseEntity<String> rejectLeave(
            @PathVariable Long leaveId) {

        return ResponseEntity.ok(
                "Leave rejected successfully");
    }

    // Get attendance report
    @GetMapping("/attendance")
    public ResponseEntity<String> getAttendanceReport() {
        return ResponseEntity.ok("Attendance report");
    }

    // Get payroll report
    @GetMapping("/payroll")
    public ResponseEntity<String> getPayrollReport() {
        return ResponseEntity.ok("Payroll report");
    }
}