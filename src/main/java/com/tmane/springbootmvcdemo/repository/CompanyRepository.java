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
    public Page<Company> findByCEOContaining(String name, Pageable pageable);

    public Page<Company> findByNameContaining(String name, Pageable pageable);

    public List<Company> findByCountry(String country);

    public List<Company> findByCity(String city);

    public List<Company> findByRevenueBetween(Double minRevenu, Double maxRevenu);

    public List<Company> findByNumberOfEmployeesBetween(Integer minEmployees, Integer maxEmployees);

    public List<Company> findByFoundationDateBetween(LocalDate startDate, LocalDate endDate);
}
