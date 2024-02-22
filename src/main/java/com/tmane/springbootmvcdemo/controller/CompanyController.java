package com.tmane.springbootmvcdemo.controller;

import com.tmane.springbootmvcdemo.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class CompanyController {
    private CompanyService companyService;

}
