/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.survey.controller;

import static com.survey.session.Session.getSession;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * 
 */
@Controller
public class LoginPageController {

    @RequestMapping(value = "/AdmUserLogin")
    public String getAdmUserLogin() {
        return "AdmUserLogin";
    }

    @RequestMapping(value = "/CorUserLogin")
    public String getCorUserLogin() {
        return "CorUserLogin";
    }

    @RequestMapping(value = "part/NavigationBar")
    public String getNavigationBar() {
        return "part/NavigationBar";
    }

    @RequestMapping(value = "/OrdUserLogin")
    public String getOrdUserLogin() {
        return "OrdUserLogin";
    }

    @RequestMapping(value = "/to_Edit_Personal_Info")
    public String getEditType() {
        HttpSession session = getSession();
        String type = (String) session.getAttribute("type");
        if (type.equals("CompanyUser")) {
            return "redirect:/corporateUser/to_Edit_CompanyUser_Info";
        } else if(type.equals("OrdinaryUser")) {
            return "redirect:/ordinaryUser/to_Edit_OrdinaryUser_Info";
        }else{
            return"AdmUser_Management_Page";
        }
    }
}
