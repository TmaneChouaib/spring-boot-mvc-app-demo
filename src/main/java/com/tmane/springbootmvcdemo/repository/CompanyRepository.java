package com.tmane.springbootmvcdemo.repository;

import com.tmane.springbootmvcdemo.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Page<Company> findByNameContaining(String name, Pageable pageable);
}
