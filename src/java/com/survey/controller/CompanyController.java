/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.survey.controller;

import com.survey.entity.Company;
import com.survey.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author 13704
 */
@Controller
@RequestMapping("/company")
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;
    
//    @PostMapping("/register")
//    public String companyRegister(Company c){
//        companyService.addCompany(c);
//        return "CorUserRegistered";
//    }
}
