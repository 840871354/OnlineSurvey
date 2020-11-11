package com.survey.controller;

import com.survey.entity.Manager;
import com.survey.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import static com.survey.session.Session.getSession;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/adminUser")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @GetMapping("/login")
    public ModelAndView adminUserLogin(String id, String password) {
        ModelAndView access = new ModelAndView("AdmUser_Management_Page");
        ModelAndView fail = new ModelAndView("AdmUserLogin");
        HttpSession session = getSession();
        session.setAttribute("type", "admin");
        if (adminUserService.adminUserLogin(id, password)) {
            session.setAttribute("user", id);
            return access;
        } else {
            return fail;
        }
    }

    @RequestMapping(value = "/managerList")
    public String getManagerInformation(Model model) {
        model.addAttribute("manager", adminUserService.getManagerInformation());
        return "part/admUser/ManagerList";
    }

    @RequestMapping(value = "/addManager")
    public String newManager() {
        return "part/admUser/AddNewManager";
    }

    @PostMapping("/to_AddManager")
    public String addNewManager(Manager m, Model model) {
        adminUserService.addManager(m);
        model.addAttribute("manager", adminUserService.getManagerInformation());
        return "part/admUser/ManagerList";
    }

    @RequestMapping(value = "/ordinaryUserList")
    public String getOrdinaryUserList(Model model) {
        model.addAttribute("ordinaryUser", adminUserService.getOrdinaryUserInformation());
        return "part/admUser/ViewOrdinaryUserInformation";
    }

    @RequestMapping(value = "/companyUserList")
    public String getCompanyUserList(Model model) {
        model.addAttribute("companyUser", adminUserService.getCompanyUserInformation());
        return "part/admUser/ViewCompanyUserInformation";
    }

    @PostMapping("/deleteCompanyUser")
    @ResponseBody
    public String deleteCompanyUser(String cuName) {
        adminUserService.deleteOneCompanyUser(cuName);
        return "part/admUser/ViewCompanyUserInformation";
    }

    @PostMapping("/deleteOrdinaryUser")
    public String deleteOrdinaryUser(String ouName) {
        adminUserService.deleteOneOrdinaryUser(ouName);
        return "part/admUser/ViewOrdinaryUserInformation";
    }

    @RequestMapping(value = "/toEditOrdinaryUser/{ouName}")
    public String toEditOrdinaryUser(@PathVariable String ouName, Model model) {
        model.addAttribute("ordinaryUser", adminUserService.getOneOrdinaryUser(ouName));
        return "part/admUser/EditOrdinaryUser";
    }

    @RequestMapping(value = "/toEditCompanyUser/{cuName}")
    public String toEditCompanyUser(@PathVariable String cuName, Model model) {
        model.addAttribute("companyUser", adminUserService.getOneCompanyUser(cuName));
        return "part/admUser/EditCompanyUser";
    }

    @PostMapping("/Edit_OrdinaryUser_Info")
    public String updateOrdinaryUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String cpass, Model model) {
        if (adminUserService.confirmOrdinaryUserPassword(pass, cpass)) {
            adminUserService.updateOrdinaryUser(name, phone, email, dob, hobby, Gender, pass);
            model.addAttribute("ordinaryUser", adminUserService.getOrdinaryUserInformation());
            return "part/admUser/ViewOrdinaryUserInformation";
        } else {
            return "part/admUser/EditOrdinaryUser";
        }
    }

    @PostMapping("/Edit_CompanyUser_Info")
    public String updateCompanyUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String cpass, Model model) {
        if (adminUserService.confirmCorporateUserPassword(pass, cpass)) {
            adminUserService.updateCorporateUser(name, phone, email, dob, hobby, Gender, pass);
            model.addAttribute("companyUser", adminUserService.getCompanyUserInformation());
            return "part/admUser/ViewCompanyUserInformation";
        } else {
            return "part/admUser/EditCompanyUser";
        }
    }

    @PostMapping("/searchOrdinaryUser")
    public String searchOrdinaryUserInformation(String search, Model model) {
        model.addAttribute("ordinaryUser", adminUserService.searchOrdinaryUserInformation(search));
        return "part/admUser/ViewOrdinaryUserInformation";
    }

    @PostMapping("/searchCompanyUser")
    public String searchCompanyUserInformation(String search, Model model) {
        model.addAttribute("companyUser", adminUserService.searchCompanyUserInformation(search));
        return "part/admUser/ViewCompanyUserInformation";
    }

    @RequestMapping(value = "/unpublished")
    public String unpublished(Model model) {
        model.addAttribute("unpublishedList", adminUserService.getUnpublishedList());
        return "part/admUser/adm_unpublished_survey_list";
    }

    @RequestMapping(value = "/Approved/{SId}")
    public String getApproved(@PathVariable int SId) {
        adminUserService.updateApprovedQuestionnaire(SId);
        return "redirect:/adminUser/unpublished";
    }

    @RequestMapping(value = "/Disapproved/{SId}")
    public String getDisapproved(@PathVariable int SId) {
        adminUserService.updateDisapprovedQuestionnaire(SId);
        return "redirect:/adminUser/unpublished";
    }

    @RequestMapping(value = "/published")
    public String published(Model model) {
        model.addAttribute("publishedList", adminUserService.getPublishedList());
        return "part/admUser/adm_published_survey_list";
    }
}
