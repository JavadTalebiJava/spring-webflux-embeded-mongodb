package com.exchane.market.controller;

import com.exchane.market.model.Company;
import com.exchane.market.repo.CompanyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping(path = "/companies")
public class CompanyController {

    private CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @PostMapping()
    public @ResponseBody
    Mono<Company> add(@RequestBody Company kayak) {
        return companyRepository.save(kayak);
    }

    @GetMapping()
    public @ResponseBody
    Flux<Company> getAll() {
        return companyRepository.findAll();
    }
}