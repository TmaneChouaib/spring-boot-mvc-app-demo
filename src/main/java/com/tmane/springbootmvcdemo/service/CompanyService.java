package com.tmane.springbootmvcdemo.service;

import com.tmane.springbootmvcdemo.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;


public interface CompanyService {
    public Page<Company> findCompaniesByCEO(String name, Pageable pageable);

    public List<Company> findCompaniesByCountry(String country);

    public List<Company> findCompaniesByCity(String city);

    public List<Company> findCompaniesByRevenueBetween(Double x, Double y);

    public List<Company> findCompaniesByNumberOfEmployeesBetween(Integer minEmployees, Integer maxEmployees);

    public List<Company> findCompaniesByFoundationDateBetween(LocalDate startDate, LocalDate endDate);

}
