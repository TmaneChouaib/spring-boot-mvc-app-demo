package com.tmane.springbootmvcdemo.service;

import com.tmane.springbootmvcdemo.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CompanyService {
    Page<Company> findPaginatedCompanies(int pageNum, int pageSize);

    Page<Company> findPaginatedCompaniesByName(String name, Pageable pageable);

    Company findCompanyById(Long id);

    void saveCompany(Company company);

    void deleteCompanyById(Long id);
}
