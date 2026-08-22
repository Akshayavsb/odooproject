package com.dayflow.hrms.entity;

import jakarta.persistence.*;

@Entity
@Table(name="payroll")
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private double basicSalary;
    private double bonus;
    private double deduction;
    private double netSalary;
}