package com.tmane.springbootmvcdemo.controller;

import com.tmane.springbootmvcdemo.entity.Company;
import com.tmane.springbootmvcdemo.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/companies")
@AllArgsConstructor
public class CompanyController {
    private CompanyService companyService;

    @GetMapping
    public String getAllCompanies(Model model,
                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "size", defaultValue = "5") int size,
                                  @RequestParam(name = "keyword", defaultValue = "") String keyWord) {

        Page<Company> companyPage = companyService.findCompaniesByCEO(keyWord, PageRequest.of(page, size));
        model.addAttribute("Companies", companyPage.getContent());
        model.addAttribute("pages", new int[companyPage.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyWord", keyWord);

        return "companies";
    }

}
