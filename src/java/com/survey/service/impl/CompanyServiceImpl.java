/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.survey.service.impl;

import com.survey.dao.CompanyDao;
import com.survey.entity.Company;
import com.survey.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 13704
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    
    @Autowired
    private CompanyDao companyDao;

    @Override
    public void addCompany(Company c) {
        companyDao.add(c);
    }
    
}
