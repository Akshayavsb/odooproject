package com.dayflow.repository;

import com.dayflow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user during login
    Optional<User> findByEmail(String email);

    // Check whether email already exists during registration
    boolean existsByEmail(String email);

    // Find user by employee ID
    Optional<User> findByEmployeeId(String employeeId);

    // Check whether employee ID already exists
    boolean existsByEmployeeId(String employeeId);

    // Find user using email verification token
    Optional<User> findByVerificationToken(String verificationToken);
}