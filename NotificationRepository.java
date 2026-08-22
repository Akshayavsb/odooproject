package com.dayflow.repository;

import com.dayflow.entity.Notification;
import com.dayflow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository
        extends JpaRepository<Notification, Long> {

    // All notifications of a user
    List<Notification> findByUserOrderByCreatedAtDesc(
            User user
    );

    // Unread notifications
    List<Notification> findByUserAndReadFalseOrderByCreatedAtDesc(
            User user
    );

    // Count unread notifications
    long countByUserAndReadFalse(
            User user
    );

    // Find notifications by type
    List<Notification> findByUserAndType(
            User user,
            String type
    );
}