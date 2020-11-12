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
public class ManagementPageController {
//    @RequestMapping(value = "part/comUser/com_menu")
//    public String getComMenu() {
//        return "part/comUser/com_menu";
//    }
    @RequestMapping(value = "part/AfterLogin_NavigationBar")
    public String getAfterLogin_NavigationBar() {
        return "part/AfterLogin_NavigationBar";
    }

    @RequestMapping(value = "/OrdUser_Management_Page")
    public String getOrdUser_Management_Page() {
        return "OrdUser_Management_Page";
    }

    @RequestMapping(value = "part/ordUser/ord_menu")
    public String getOrdMenu() {
        return "part/ordUser/ord_menu";
    }

    @RequestMapping(value = "part/comUser/com_menu")
    public String getComMenu() {
        return "part/comUser/com_menu";
    }

    @RequestMapping(value = "part/admUser/ad_menu")
    public String getAdmMenu() {
        return "part/admUser/ad_menu";
    }
}
