package com.tmane.springbootmvcdemo.service;

import com.tmane.springbootmvcdemo.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;


public interface CompanyService {
    Page<Company> findPaginatedCompanies(int pageNum, int pageSize);

    Page<Company> findPaginatedCompaniesByName(String name, Pageable pageable);

    Company findCompanyById(Long id);

    void saveCompany(Company company);

    void deleteCompanyById(Long id);

    Page<Company> findPaginatedCompaniesByCEO(String name, Pageable pageable);

    List<Company> findCompaniesByCountry(String country);

    List<Company> findCompaniesByCity(String city);

    List<Company> findCompaniesByRevenueBetween(Double minRevenue, Double maxRevenue);

    List<Company> findCompaniesByNumberOfEmployeesBetween(Integer minEmployees, Integer maxEmployees);

    List<Company> findCompaniesByFoundationDateBetween(LocalDate startDate, LocalDate endDate);

}
