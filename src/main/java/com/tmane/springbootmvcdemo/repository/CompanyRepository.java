package com.tmane.springbootmvcdemo.repository;

import com.tmane.springbootmvcdemo.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Page<Company> findByCEOContaining(String name, Pageable pageable);

    Page<Company> findByNameContaining(String name, Pageable pageable);

    List<Company> findByCountryContaining(String country);

    List<Company> findByCityContaining(String city);

    List<Company> findByRevenueBetween(Double minRevenu, Double maxRevenu);

    List<Company> findByNumberOfEmployeesBetween(Integer minEmployees, Integer maxEmployees);

    List<Company> findByFoundationDateBetween(LocalDate startDate, LocalDate endDate);
}
