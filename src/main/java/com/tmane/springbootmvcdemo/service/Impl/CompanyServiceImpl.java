package com.tmane.springbootmvcdemo.service.Impl;

import com.tmane.springbootmvcdemo.entity.Company;
import com.tmane.springbootmvcdemo.repository.CompanyRepository;
import com.tmane.springbootmvcdemo.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    @Override
    public Page<Company> findPaginatedCompanies(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return companyRepository.findAll(pageable);
    }

    @Override
    public void saveCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Company findCompanyById(Long id) {
        return companyRepository.findById(id).get();
    }

    @Override
    public Page<Company> findPaginatedCompaniesByName(String name, Pageable pageable) {
        return companyRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Page<Company> findPaginatedCompaniesByCEO(String name, Pageable pageable) {
        return companyRepository.findByCEOContaining(name, pageable);
    }

    @Override
    public List<Company> findCompaniesByCountry(String country) {
        return companyRepository.findByCountry(country);
    }

    @Override
    public List<Company> findCompaniesByCity(String city) {
        return companyRepository.findByCity(city);
    }

    @Override
    public List<Company> findCompaniesByRevenueBetween(Double minRevenu, Double maxRevenu) {
        return companyRepository.findByRevenueBetween(minRevenu, maxRevenu);
    }

    @Override
    public List<Company> findCompaniesByNumberOfEmployeesBetween(Integer minEmployees, Integer maxEmployees) {
        return companyRepository.findByNumberOfEmployeesBetween(minEmployees, maxEmployees);
    }

    @Override
    public List<Company> findCompaniesByFoundationDateBetween(LocalDate startDate, LocalDate endDate) {
        return companyRepository.findByFoundationDateBetween(startDate, endDate);
    }
}
