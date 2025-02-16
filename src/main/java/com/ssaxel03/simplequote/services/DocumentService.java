package com.ssaxel03.simplequote.services;

import com.ssaxel03.simplequote.model.Company;
import com.ssaxel03.simplequote.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {


    public class Document {

        private String name;
        private String currency;
        private int taxRate;
        private Company company;
        private String clientName;
        private String clientAddress;
        private String clientEmail;
        private String clientPhone;
        private List<Item> items;
        private String primaryColor;
        private String secondaryColor;


    }

}