package com.tmane.springbootmvcdemo.service.Impl;

import com.tmane.springbootmvcdemo.entity.Company;
import com.tmane.springbootmvcdemo.repository.CompanyRepository;
import com.tmane.springbootmvcdemo.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findCompaniesByCEO(String name) {
        return companyRepository.findByCEO(name);
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
