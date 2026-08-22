package com.dayflow.hrms.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private LocalDate date;
    private String status;
}