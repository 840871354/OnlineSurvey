/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.survey.dao.impl;

import com.survey.dao.CompanyDao;
import com.survey.entity.Company;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 13704
 */
@Repository
public class CompanyDaoImpl implements CompanyDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Company c) {
        sessionFactory.getCurrentSession().save(c);
    }
    
}
