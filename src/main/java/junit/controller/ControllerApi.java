package junit.controller;

import junit.model.Company;
import junit.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * springMVS
 * 16.02.2023
 * user
 * чт
 **/
@Controller
@RequestMapping("/companies")
@RequiredArgsConstructor
public class ControllerApi {
    private final CompanyService companyService;

    @GetMapping
    String findAll(Model model){
        List<Company> companies = companyService.findAll();
        model.addAttribute("companies",companies);
        return "companies";
    }
    @PostMapping("/new")
    String create(@ModelAttribute("newCompany") Company company){
        companyService.save(company);
        return "redirect:/companies";
    }
    @GetMapping("/savePage")
    String save(Model model){
        model.addAttribute("company",new Company());
        return "savePage";
    }
}
