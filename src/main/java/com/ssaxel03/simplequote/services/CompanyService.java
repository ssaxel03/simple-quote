package com.ssaxel03.simplequote.services;

import com.ssaxel03.simplequote.daos.CompanyDao;
import com.ssaxel03.simplequote.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    CompanyDao companyDao;

    public Company getCompany(Long userId) {
        return companyDao.findByUserId(userId);
    }

    public void saveOrUpdateCompany(Company company) {
        companyDao.saveOrUpdate(company);
    }

    public CompanyDao getCompanyDao() {
        return companyDao;
    }
    @Autowired
    public void setCompanyDao(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }
}
