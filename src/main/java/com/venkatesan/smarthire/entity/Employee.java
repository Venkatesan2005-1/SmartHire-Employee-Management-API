package com.venkatesan.smarthire.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Name cannot be blank")
    @Column(nullable = false)
    private String name;

    @NotBlank(message="Email cannot be blank")
    @Email(message="Email should be valid")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message="Department cannot be blank")
    @Column(nullable = false)
    private String department;

    @NotNull(message="Salary cannot be null")
    @Positive(message="Salary must be positive")
    @Column(nullable = false)
    private Double salary;

    @NotNull(message="Joining date cannot be null")
    @Column(nullable = false)
    private LocalDate joiningDate;
}