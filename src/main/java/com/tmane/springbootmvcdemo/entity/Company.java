package com.tmane.springbootmvcdemo.entity;

import com.tmane.springbootmvcdemo.enums.Sector;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String CEO;
    private LocalDate foundationDate;
    private Long revenue;
    @Enumerated(EnumType.STRING)
    private Sector sector;
}