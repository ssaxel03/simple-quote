package com.ssaxel03.simplequote.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/document", "/document/"})
public class DocumentController {

    @GetMapping
    public String document() {
        return "document";
    }

    @PostMapping({"/new", "/new/"})
    public String newDocument() {
        return "redirect:/document";
    }
}
