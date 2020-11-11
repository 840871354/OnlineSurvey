/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.survey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * 
 */
@Controller
public class RegisteredController {

    @RequestMapping(value = "/CompanyRegistered")
    public String getCompanyRegistered() {
        return "CompanyRegistered";
    }

    @RequestMapping(value = "/CorUserRegistered")
    public String getUserRegistered() {
        return "CorUserRegistered";
    }

    @RequestMapping(value = "/OrdUserRegistered")
    public String getOrdUserRegistered() {
        return "OrdUserRegistered";
    }
}
