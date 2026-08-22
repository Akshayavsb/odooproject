package com.dayflow.hrms.service;

import com.dayflow.hrms.entity.User;
import com.dayflow.hrms.repository.UserRepository;
import com.dayflow.hrms.repository.LeaveRequestRepository;
import com.dayflow.hrms.entity.LeaveRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final LeaveRequestRepository leaveRequestRepository;

    public AdminService(UserRepository userRepository,
                        LeaveRequestRepository leaveRequestRepository) {
        this.userRepository = userRepository;
        this.leaveRequestRepository = leaveRequestRepository;
    }

    // Get all users/employees
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get all leave requests
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    // Approve leave request
    public LeaveRequest approveLeave(Long leaveId) {

        LeaveRequest leaveRequest = leaveRequestRepository.findById(leaveId)
                .orElseThrow(() ->
                        new RuntimeException("Leave request not found"));

        leaveRequest.setStatus("APPROVED");

        return leaveRequestRepository.save(leaveRequest);
    }

    // Reject leave request
    public LeaveRequest rejectLeave(Long leaveId) {

        LeaveRequest leaveRequest = leaveRequestRepository.findById(leaveId)
                .orElseThrow(() ->
                        new RuntimeException("Leave request not found"));

        leaveRequest.setStatus("REJECTED");

        return leaveRequestRepository.save(leaveRequest);
    }

    // Delete user
    public void deleteUser(Long userId) {

        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }

        userRepository.deleteById(userId);
    }
}