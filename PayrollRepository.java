package com.dayflow.repository;

import com.dayflow.entity.Employee;
import com.dayflow.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Long> {

    // Find payroll of an employee
    List<Payroll> findByEmployee(Employee employee);

    // Find latest payroll record
    Optional<Payroll> findTopByEmployeeOrderByIdDesc(
            Employee employee
    );

    // Find payroll by employee ID
    Optional<Payroll> findByEmployeeEmployeeId(
            String employeeId
    );

    // Find payroll by year
    List<Payroll> findByYear(int year);

    // Find payroll by year and month
    List<Payroll> findByYearAndMonth(
            int year,
            int month
    );

    // Check whether payroll exists
    boolean existsByEmployeeAndYearAndMonth(
            Employee employee,
            int year,
            int month
    );
}