package com.example.test9.repo;

import com.example.test9.model.Notification;
import com.example.test9.model.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
    List<Notification> findByReclamation(Reclamation reclamation);
}
