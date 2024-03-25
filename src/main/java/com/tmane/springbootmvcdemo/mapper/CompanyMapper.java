package com.tmane.springbootmvcdemo.mapper;

import com.tmane.springbootmvcdemo.dto.CompanyDTO;
import com.tmane.springbootmvcdemo.entity.Company;

import org.springframework.stereotype.Component;

@Component
public class    CompanyMapper {
    public CompanyDTO mapToCompanyDTO(Company company) {
        CompanyDTO companyDTO=new CompanyDTO();

        companyDTO.setId(company.getId());
        companyDTO.setName(company.getName());
        companyDTO.setAddress(company.getAddress());
        companyDTO.setCountry(company.getCountry());
        companyDTO.setCity(company.getCity());
        companyDTO.setPostalCode(company.getPostalCode());
        companyDTO.setCEO(company.getCEO());
        companyDTO.setPhoneNumber(company.getPhoneNumber());
        companyDTO.setEmail(company.getEmail());
        companyDTO.setFoundationDate(company.getFoundationDate());
        companyDTO.setRevenue(company.getRevenue());
        companyDTO.setNumberOfEmployees(company.getNumberOfEmployees());
        companyDTO.setFiscalCode(company.getFiscalCode());
        companyDTO.setSector(company.getSector());

        return companyDTO;
    }

    public Company mapToCompany(CompanyDTO companyDTO){
        Company company=new Company();

        company.setName(companyDTO.getName());
        company.setAddress(companyDTO.getAddress());
        company.setCountry(companyDTO.getCountry());
        company.setCity(companyDTO.getCity());
        company.setPostalCode(companyDTO.getPostalCode());
        company.setCEO(companyDTO.getCEO());
        company.setPhoneNumber(companyDTO.getPhoneNumber());
        company.setEmail(companyDTO.getEmail());
        company.setFoundationDate(companyDTO.getFoundationDate());
        company.setRevenue(companyDTO.getRevenue());
        company.setNumberOfEmployees(companyDTO.getNumberOfEmployees());
        company.setFiscalCode(companyDTO.getFiscalCode());
        company.setSector(companyDTO.getSector());

        return company;
    }
}
