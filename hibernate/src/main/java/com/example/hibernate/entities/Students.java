package com.example.hibernate.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "First name",nullable = false)
    private String firstName;

    @Column(name = "Last name", nullable = false)
    private String lastName;

    @Column(unique = true, name = "studentEmail", length = 100, nullable = false)
    private String email;


}
