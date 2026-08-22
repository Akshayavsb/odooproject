package com.dayflow.hrms.service;

import com.dayflow.hrms.entity.LeaveRequest;
import com.dayflow.hrms.repository.LeaveRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveService {

    private final LeaveRequestRepository leaveRequestRepository;

    public LeaveService(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    // Get all leave requests
    public List<LeaveRequest> getAllLeaves() {
        return leaveRequestRepository.findAll();
    }

    // Get leave request by ID
    public Optional<LeaveRequest> getLeaveById(Long id) {
        return leaveRequestRepository.findById(id);
    }

    // Get leave requests for an employee
    public List<LeaveRequest> getEmployeeLeaves(Long employeeId) {
        return leaveRequestRepository.findByEmployeeId(employeeId);
    }

    // Apply for leave
    public LeaveRequest applyLeave(LeaveRequest leaveRequest) {

        if (leaveRequest.getStatus() == null ||
                leaveRequest.getStatus().isEmpty()) {
            leaveRequest.setStatus("PENDING");
        }

        return leaveRequestRepository.save(leaveRequest);
    }

    // Approve leave
    public LeaveRequest approveLeave(Long id) {

        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Leave request not found"));

        leaveRequest.setStatus("APPROVED");

        return leaveRequestRepository.save(leaveRequest);
    }

    // Reject leave
    public LeaveRequest rejectLeave(Long id) {

        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Leave request not found"));

        leaveRequest.setStatus("REJECTED");

        return leaveRequestRepository.save(leaveRequest);
    }

    // Update leave request
    public LeaveRequest updateLeave(Long id, LeaveRequest updatedLeave) {

        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Leave request not found"));

        leaveRequest.setStartDate(updatedLeave.getStartDate());
        leaveRequest.setEndDate(updatedLeave.getEndDate());
        leaveRequest.setLeaveType(updatedLeave.getLeaveType());
        leaveRequest.setReason(updatedLeave.getReason());

        return leaveRequestRepository.save(leaveRequest);
    }

    // Delete leave request
    public void deleteLeave(Long id) {

        if (!leaveRequestRepository.existsById(id)) {
            throw new RuntimeException("Leave request not found");
        }

        leaveRequestRepository.deleteById(id);
    }
}