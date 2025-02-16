package com.ssaxel03.simplequote.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
public class CompanyDetailsController {

    @GetMapping
    public String companyDetails() {
        return "company";
    }
}
