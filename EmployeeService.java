*package com.dayflow.hrms.service;

import com.dayflow.hrms.entity.User;
import com.dayflow.hrms.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final UserRepository userRepository;

    public EmployeeService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all employees
    public List<User> getAllEmployees() {
        return userRepository.findAll();
    }

    // Get employee by ID
    public Optional<User> getEmployeeById(Long id) {
        return userRepository.findById(id);
    }

    // Update employee
    public User updateEmployee(Long id, User updatedEmployee) {

        User employee = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found"));

        employee.setName(updatedEmployee.getName());
        employee.setEmail(updatedEmployee.getEmail());

        return userRepository.save(employee);
    }

    // Delete employee
    public void deleteEmployee(Long id) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }

        userRepository.deleteById(id);
    }
}*