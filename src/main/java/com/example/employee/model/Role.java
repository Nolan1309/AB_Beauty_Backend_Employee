package com.example.employee.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
}
