package com.tmane.springbootmvcdemo.entity;

import com.tmane.springbootmvcdemo.enums.Sector;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String country;
    private String city;
    private String postalCode;
    private String CEO;
    private String phoneNumber;
    private String email;
    private LocalDate foundationDate;
    private Double revenue;
    private Integer numberOfEmployees;
    private String fiscalCode;
    @Enumerated(EnumType.STRING)
    private Sector sector;
}