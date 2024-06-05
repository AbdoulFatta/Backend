package com.example.test9.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "yourGenerator77Name")
    @SequenceGenerator(name = "yourGenerator77Name", sequenceName = "notification_seq", allocationSize = 1)
    private Long id_notification;


    private Date date_notification;


    private boolean checked;

    private boolean deleted;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_reclamation")
    private Reclamation reclamation;
}
