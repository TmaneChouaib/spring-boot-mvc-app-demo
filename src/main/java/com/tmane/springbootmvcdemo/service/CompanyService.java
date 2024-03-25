package com.tmane.springbootmvcdemo.service;

import com.tmane.springbootmvcdemo.dto.CompanyDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CompanyService {
    Page<CompanyDTO> findPaginatedCompanies(int pageNum, int pageSize);

    Page<CompanyDTO> findPaginatedCompaniesByName(String name, Pageable pageable);

    CompanyDTO findCompanyById(Long id);

    CompanyDTO saveCompany(CompanyDTO companyDTO);

    void deleteCompanyById(Long id);
}
