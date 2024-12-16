package com.ssaxel03.simplequote.controllers;

import com.ssaxel03.simplequote.model.Document;
import com.ssaxel03.simplequote.services.DocumentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/document", "/document/"})
public class DocumentController {

    private DocumentService documentService;

    @GetMapping
    public String document(HttpSession session, Model model) {

        if (session.getAttribute("document") == null) {
            documentService.newDocument(session);
        }

        model.addAttribute("document", session.getAttribute("document"));

        return "document";
    }

    @PostMapping({"/new", "/new/"})
    public String newDocument(HttpSession session) {
        documentService.newDocument(session);
        return "redirect:/document";
    }

    @PostMapping({"/generate", "/generate/"})
    public String generateDocument() {



        return "NOT YET IMPLEMENTED";
    }

    public DocumentService getDocumentService() {
        return documentService;
    }
    @Autowired
    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }
}
