package com.apartment.employee.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String phone;
    private String email;
    private String emergencyContact;
    private LocalDate dateOfJoining;
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
