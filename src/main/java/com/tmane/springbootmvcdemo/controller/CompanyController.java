package com.tmane.springbootmvcdemo.controller;

import com.tmane.springbootmvcdemo.entity.Company;
import com.tmane.springbootmvcdemo.repository.CompanyRepository;
import com.tmane.springbootmvcdemo.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/companies")
@AllArgsConstructor
public class CompanyController {
    private CompanyService companyService;
    private final CompanyRepository companyRepository;

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

    @GetMapping("/new")
    public String AddCompany(@ModelAttribute("company") Company company) {
        return "AddCompany";
    }

    @PutMapping
    public String SaveCompany(@ModelAttribute("company") Company company,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "keyword", defaultValue = "") String keyWord) {

        companyRepository.save(company);
        return "redirect:/companies?page=" + page + "&keyword=" + keyWord;
    }

}
