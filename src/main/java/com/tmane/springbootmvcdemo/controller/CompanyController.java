package com.tmane.springbootmvcdemo.controller;

import com.tmane.springbootmvcdemo.entity.Company;
import com.tmane.springbootmvcdemo.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/companies")
@AllArgsConstructor
public class CompanyController {
    private static final String COMPANIES_REDIRECT = "/companies";
    private static final String COMPANIES_PAGE = "/companies/companies";
    private static final String ADD_COMPANY_PAGE = "/companies/AddCompany";
    private static final String EDIT_COMPANY_PAGE = "/companies/EditCompany";
    private static final String VIEW_COMPANY_PAGE = "/companies/company";
    private CompanyService companyService;

    public int getLastPageNumber() {
        int pageSize = 5;
        Page<Company> page = companyService.findPaginated(1, pageSize);

        return page.getTotalPages();
    }

    @GetMapping
    public String HomePage(Model model) {
        return findPaginated(model, 1, 5, "");
    }

    @GetMapping("/page/{pageNum}")
    public String findPaginated(Model model,
                                @PathVariable(value = "pageNum") int pageNum,
                                @RequestParam(name = "size", defaultValue = "5") int size,
                                @RequestParam(name = "keyword", defaultValue = "") String keyword) {

        Page<Company> page;

        if (keyword != null && !keyword.trim().isEmpty() && !"null".equalsIgnoreCase(keyword)) {
            page = companyService.findCompaniesByName((keyword), PageRequest.of(pageNum - 1, size));
        } else {
            page = companyService.findPaginated(pageNum, size);
        }

        List<Company> companyList = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("companyList", companyList);
        model.addAttribute("keyword", keyword);

        return COMPANIES_PAGE;
    }

    @GetMapping("/new")
    public String addCompanyForm(@ModelAttribute("company") Company company) {

        return ADD_COMPANY_PAGE;
    }

    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.saveCompany(company);

        return "redirect:" + COMPANIES_REDIRECT + "/page/" + getLastPageNumber();
    }

    @PostMapping("/update/{id}")
    public String updateCompany(@ModelAttribute("company") Company company,
                                @PathVariable Long id,
                                @RequestParam(defaultValue = "1") int page) {
        companyService.saveCompany(company);

        return "redirect:" + COMPANIES_REDIRECT + "/page/" + page;
    }

    @GetMapping("/edit/{id}")
    public String editCompanyForm(@PathVariable Long id, Model model,
                                  @RequestParam(value = "page", defaultValue = "1") int page) {
        Company company = companyService.findCompanyById(id);
        model.addAttribute("company", company);
        model.addAttribute("page", page);

        return EDIT_COMPANY_PAGE;
    }

    @GetMapping("/company/{id}")
    public String detailCompany(@PathVariable Long id, Model model) {
        model.addAttribute("company", companyService.getCompanyById(id));

        return VIEW_COMPANY_PAGE;
    }

    @GetMapping("/delete/{id}")
    public String deleteCompanyById(@PathVariable Long id,
                                    @RequestParam(name = "page", defaultValue = "0") int page) {
        companyService.deleteCompanyById(id);

        return "redirect:" + COMPANIES_REDIRECT + "?page=" + page;
    }
}
