package com.tmane.springbootmvcdemo.controller;

import com.tmane.springbootmvcdemo.entity.Company;
import com.tmane.springbootmvcdemo.enums.Sector;
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
    private static final int PAGE_SIZE = 10;
    private final CompanyService companyService;


    public int retrieveLastPageNumber() {
        Page<Company> page = companyService.findPaginatedCompanies(1, PAGE_SIZE);

        return page.getTotalPages();
    }

    @GetMapping
    public String displayHomePage(Model model,
                                  @RequestParam(value = "keyword", required = false) String keyword) {
        return displayPaginatedCompanies(model, 1, keyword);
    }

    @GetMapping("/page/{pageNum}")
    public String displayPaginatedCompanies(Model model,
                                            @PathVariable(value = "pageNum") int pageNum,
                                            @RequestParam(name = "keyword", required = false) String keyword) {

        Page<Company> page;

        if (keyword != null && !keyword.trim().isEmpty() && !"null".equalsIgnoreCase(keyword)) {
            page = companyService.findPaginatedCompaniesByName((keyword), PageRequest.of(pageNum - 1, PAGE_SIZE));
        } else {
            page = companyService.findPaginatedCompanies(pageNum, PAGE_SIZE);
        }

        List<Company> companyList = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("companyList", companyList);
        model.addAttribute("keyword", keyword);

        return COMPANIES_PAGE;
    }

    @GetMapping("/{id}")
    public String displayCompanyDetails(@PathVariable Long id, Model model) {
        model.addAttribute("company", companyService.findCompanyById(id));

        return VIEW_COMPANY_PAGE;
    }

    @GetMapping("/new")
    public String displayAddCompanyForm(Model model) {
        model.addAttribute("company", new Company());
        model.addAttribute("sectors", Sector.values());

        return ADD_COMPANY_PAGE;
    }

    @PostMapping
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.saveCompany(company);

        return "redirect:" + COMPANIES_REDIRECT + "/page/" + retrieveLastPageNumber();
    }

    @GetMapping("/{id}/edit")
    public String displayEditCompanyForm(@PathVariable Long id, Model model,
                                         @RequestParam(value = "keyword", required = false) String keyword,
                                         @RequestParam(value = "page", defaultValue = "1") int page) {
        Company company = companyService.findCompanyById(id);
        model.addAttribute("company", company);
        model.addAttribute("sectors", Sector.values());
        model.addAttribute("page", page);
        model.addAttribute(("keyword"), keyword);

        return EDIT_COMPANY_PAGE;
    }

    @PostMapping("/{id}/update")
    public String updateCompany(@ModelAttribute("company") Company company,
                                @PathVariable Long id,
                                @RequestParam(value = "keyword", required = false) String keyword,
                                @RequestParam(defaultValue = "1") int page) {
        companyService.saveCompany(company);

        return "redirect:" + COMPANIES_REDIRECT + "/page/" + page + "?keyword=" + (keyword == null ? "" : keyword);
    }

    @GetMapping("/{id}/delete")
    public String deleteCompany(@PathVariable Long id,
                                @RequestParam(name = "page", defaultValue = "0") int page) {
        companyService.deleteCompanyById(id);

        return "redirect:" + COMPANIES_REDIRECT + "?page=" + page;
    }
}
