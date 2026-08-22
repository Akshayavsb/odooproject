package com.dayflow.hrms.controller;

import com.dayflow.hrms.entity.LeaveRequest;
import com.dayflow.hrms.service.LeaveRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
@CrossOrigin(origins = "*")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    public LeaveRequestController(
            LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    @GetMapping
    public List<LeaveRequest> getAllLeaves() {
        return leaveRequestService.getAllLeaves();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequest> getLeaveById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                leaveRequestService.getLeaveById(id)
        );
    }

    @PostMapping
    public ResponseEntity<LeaveRequest> createLeave(
            @RequestBody LeaveRequest leaveRequest) {

        return ResponseEntity.ok(
                leaveRequestService.createLeave(leaveRequest)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveRequest> updateLeave(
            @PathVariable Long id,
            @RequestBody LeaveRequest leaveRequest) {

        return ResponseEntity.ok(
                leaveRequestService.updateLeave(id, leaveRequest)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLeave(
            @PathVariable Long id) {

        leaveRequestService.deleteLeave(id);

        return ResponseEntity.ok(
                "Leave request deleted successfully"
        );
    }
}