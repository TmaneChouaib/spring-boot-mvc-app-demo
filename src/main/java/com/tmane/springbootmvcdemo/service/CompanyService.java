package com.tmane.springbootmvcdemo.service;

import com.tmane.springbootmvcdemo.entity.Company;

import java.time.LocalDate;
import java.util.List;


public interface CompanyService {
    public List<Company> findCompaniesByCEO(String name);

    public List<Company> findCompaniesByCountry(String country);

    public List<Company> findCompaniesByCity(String city);

    public List<Company> findCompaniesByRevenueBetween(Double x, Double y);

    public List<Company> findCompaniesByNumberOfEmployeesBetween(Integer minEmployees, Integer maxEmployees);

    public List<Company> findCompaniesByFoundationDateBetween(LocalDate startDate, LocalDate endDate);

}
