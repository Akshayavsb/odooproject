package com.dayflow.hrms.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="leave_requests")
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private String leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String remarks;
    private String status;
}