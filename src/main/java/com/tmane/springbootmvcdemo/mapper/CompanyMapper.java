package com.tmane.springbootmvcdemo.mapper;

import com.tmane.springbootmvcdemo.dto.CompanyDTO;
import com.tmane.springbootmvcdemo.entity.Company;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    ModelMapper modelMapper = new ModelMapper();

    public CompanyDTO mapToCompanyDTO(Company company) {
        return modelMapper.map(company, CompanyDTO.class);
    }

    public Company mapToCompany(CompanyDTO companyDTO) {
        return modelMapper.map(companyDTO, Company.class);
    }
}
