package com.tmane.springbootmvcdemo.controller;

import com.tmane.springbootmvcdemo.entity.Company;
import com.tmane.springbootmvcdemo.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/companies")
@AllArgsConstructor
public class CompanyController {
    private CompanyService companyService;

    @GetMapping("/page/{pageNum}")
    public String getAllCompanies(Model model,
                                  @PathVariable(value = "pageNum") int pageNum,
                                  @RequestParam(name = "size", defaultValue = "5") int size,
                                  @RequestParam(name = "keyword", defaultValue = "") String keyword) {

        Page<Company> page = companyService.getAllCompanies(pageNum, size);
        List<Company> companyList = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("companyList", companyList);
        model.addAttribute("keyword", keyword);


        return "companies";
    }

    @GetMapping("/new")
    public String addCompanyForm(@ModelAttribute("company") Company company) {
        return "AddCompany";
    }

    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("company") Company company,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "keyword", defaultValue = "") String keyword) {

        companyService.saveCompany(company);
        return "redirect:/companies?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/edit/{id}")
    public String editCompanyForm(@PathVariable Long id, Model model) {
        Company company = companyService.findCompanyById(id);
        model.addAttribute("company", company);
        return "EditCompany";
    }

    @GetMapping("/company/{id}")
    public String detailCompany(@PathVariable Long id, Model model) {
        model.addAttribute("company", companyService.getCompanyById(id));
        return "company";
    }

    @GetMapping("/delete/{id}")
    public String deleteCompanyById(@PathVariable Long id,
                                    @RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        companyService.deleteCompanyById(id);
        return "redirect:/companies?page=" + page + "&keyword=" + keyword;
    }

}
