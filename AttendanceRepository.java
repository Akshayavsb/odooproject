package com.dayflow.repository;

import com.dayflow.entity.Attendance;
import com.dayflow.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    // Employee's complete attendance
    List<Attendance> findByEmployee(Employee employee);

    // Attendance for a particular date
    Optional<Attendance> findByEmployeeAndDate(
            Employee employee,
            LocalDate date
    );

    // Attendance between two dates
    List<Attendance> findByEmployeeAndDateBetween(
            Employee employee,
            LocalDate startDate,
            LocalDate endDate
    );

    // All attendance on a particular date
    List<Attendance> findByDate(LocalDate date);

    // Attendance by status
    List<Attendance> findByStatus(String status);

    // Employee attendance by status
    List<Attendance> findByEmployeeAndStatus(
            Employee employee,
            String status
    );

    // Check whether attendance already exists
    boolean existsByEmployeeAndDate(
            Employee employee,
            LocalDate date
    );
}