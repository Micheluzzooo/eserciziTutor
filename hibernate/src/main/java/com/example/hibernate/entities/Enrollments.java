package com.example.hibernate.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Enrollments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Students students;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Classes classes;

}
