package com.ssaxel03.simplequote.services;

import com.ssaxel03.simplequote.model.Company;
import com.ssaxel03.simplequote.model.Document;
import com.ssaxel03.simplequote.model.Item;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class DocumentService {

    public void newDocument(HttpSession session) {
        session.setAttribute("document", new Document());
    }

    public void saveDocument(HttpSession session, String name, String currency, String taxRate, String clientName, String clientAddress, String clientEmail, String clientPhone, String primaryColor, String secondaryColor) {

        Document document = (Document) session.getAttribute("document");

        document.setName(name);
        document.setCurrency(currency);
        document.setTaxRate(Integer.parseInt(taxRate));
        document.setClientName(clientName);
        document.setClientAddress(clientAddress);
        document.setClientEmail(clientEmail);
        document.setClientPhone(clientPhone);
        document.setPrimaryColor(primaryColor);
        document.setSecondaryColor(secondaryColor);

        session.setAttribute("document", document);
    }

    public void addItem(HttpSession session, Item item) {

        Document document = (Document) session.getAttribute("document");

        document.getItems().add(item);
    }

    public void removeItem(HttpSession session, Item item) {

        Document document = (Document) session.getAttribute("document");

        document.getItems().remove(item);
    }

    public File generatePDF(HttpSession session) {
        return null;
    }

}