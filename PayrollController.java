package com.dayflow.hrms.controller;

import com.dayflow.hrms.entity.Payroll;
import com.dayflow.hrms.service.PayrollService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payroll")
@CrossOrigin(origins = "*")
public class PayrollController {

    private final PayrollService payrollService;

    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @GetMapping
    public List<Payroll> getAllPayroll() {
        return payrollService.getAllPayroll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payroll> getPayrollById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                payrollService.getPayrollById(id)
        );
    }

    @PostMapping
    public ResponseEntity<Payroll> createPayroll(
            @RequestBody Payroll payroll) {

        return ResponseEntity.ok(
                payrollService.createPayroll(payroll)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payroll> updatePayroll(
            @PathVariable Long id,
            @RequestBody Payroll payroll) {

        return ResponseEntity.ok(
                payrollService.updatePayroll(id, payroll)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayroll(
            @PathVariable Long id) {

        payrollService.deletePayroll(id);

        return ResponseEntity.ok(
                "Payroll deleted successfully"
        );
    }
}