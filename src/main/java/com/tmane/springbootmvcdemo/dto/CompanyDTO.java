package com.tmane.springbootmvcdemo.dto;

import com.tmane.springbootmvcdemo.enums.Sector;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {
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
    private Long revenue;
    private Integer numberOfEmployees;
    private String fiscalCode;
    @Enumerated(EnumType.STRING)
    private Sector sector;
}
