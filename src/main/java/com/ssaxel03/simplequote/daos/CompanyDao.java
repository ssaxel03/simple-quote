package com.ssaxel03.simplequote.daos;

import com.ssaxel03.simplequote.model.Company;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDao extends GenericDao<Company> implements Dao<Company> {
    public CompanyDao() {
        super(Company.class);
    }

    public Company findByUserId(Long userId) {
        return em.createQuery("SELECT c FROM Company c WHERE c.user.id = :userId", Company.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }
}
