package com.survey.controller;

import com.survey.entity.Company;
import com.survey.entity.CompanyUser;
import com.survey.entity.Question;
import com.survey.entity.QuestionId;
import com.survey.entity.Survey;
import com.survey.service.CorporateUserService;
import static com.survey.session.Session.getSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/corporateUser")
public class CorporateUserController {

    @Autowired
    private CorporateUserService corporateUserService;

    @GetMapping("/login")
    public ModelAndView corporateUserLogin(@RequestParam String id, @RequestParam String password, Model model) {
        ModelAndView access = new ModelAndView("ComUser_Management_Page");
        ModelAndView fail = new ModelAndView("CorUserLogin");
        HttpSession session = getSession();
        if (corporateUserService.corporateUserLogin(id, password)) {
            session.setAttribute("user", id);
            session.setAttribute("type", "CompanyUser");
            return access;
        } else {
            return fail;
        }
    }

    @PostMapping("/register")
    public String corporateUserRegister(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String cpass, @RequestParam(value = "photo") MultipartFile photo, String companyName) {
        if (corporateUserService.confirmCorporateUserPassword(pass, cpass)) {
            String fphoto = corporateUserService.getOrdinaryUserPhoto(photo);
            if (fphoto != null) {
                corporateUserService.addCorporateUser(name, phone, email, dob, hobby, Gender, pass, fphoto, companyName);
                return "CorUserLogin";
            } else {
                return "CorUserRegistered";
            }
        } else {
            return "CorUserRegistered";
        }
    }

    @RequestMapping(value = "/com_survey_list")
    public String getSurveyLlist(Model model) {
        HttpSession session = getSession();
        String u_id = (String) session.getAttribute("user");
        model.addAttribute("SurveyList", corporateUserService.getSurveyByName(u_id));
        return "part/comUser/com_survey_list";
    }
///////////////////////ADD

    @RequestMapping(value = "/to_Edit_CompanyUser_Info")
    public String getEdit_Personal_Info(Model model) {
        HttpSession session = getSession();
        String cuName = (String) session.getAttribute("user");
        model.addAttribute("corporateUser", corporateUserService.getCompanyUserInfo(cuName));
        return "Edit_CompanyUser_Info";
    }
///////////        /ADD1

    //////////////ADD2
    @PostMapping("/Edit_CompanyUser_Info")
    public String updateCompanyUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String cpass, @RequestParam(value = "photo") MultipartFile photo) {
        if (corporateUserService.confirmCorporateUserPassword(pass, cpass)) {
            String fphoto = corporateUserService.getCompanyUserPhoto(photo);
            if (fphoto != null) {
                corporateUserService.updateCorporateUser(name, phone, email, dob, hobby, Gender, pass, fphoto);
                return "CorUserLogin";
            } else {
                return "Edit_CompanyUser_Info";
            }
        } else {
            return "Edit_CompanyUser_Info";
        }
    }

    /////////////   /ADD2
    @RequestMapping(value = "/addSurveyPage")
    public ModelAndView getaddSurveyPage() {
        HttpSession session = getSession();
        String u_id = (String) session.getAttribute("user");
        String companyName = corporateUserService.getCompany(u_id);
        ModelAndView add = new ModelAndView("part/comUser/Add_questionnaire");
        session.setAttribute("user", u_id);
        session.setAttribute("companyName", companyName);
        return add;
    }

    @RequestMapping(value = "/addSurveyService")
    public String getaddSurveyService(String SName, String CName, String UName, String KeyWord, String date, Model model) {
        corporateUserService.addQuestionnaire(SName, CName, UName, KeyWord, date);
        HttpSession session = getSession();
        String u_id = (String) session.getAttribute("user");
        model.addAttribute("SurveyList", corporateUserService.getSurveyByName(u_id));
        return "part/comUser/com_survey_list";
    }

    @RequestMapping(value = "/to_ModifySurveyService/{SId}")
    public String getToModifySurvey(@PathVariable int SId, Model model) {
        model.addAttribute("survey", corporateUserService.getOneSurveyByName(SId));

        HttpSession session = getSession();
        String u_id = (String) session.getAttribute("user");
        String companyName = corporateUserService.getCompany(u_id);
        session.setAttribute("companyName", companyName);

        return "part/comUser/Modify_questionnaire";
    }

    @RequestMapping("/ModifySurveyService")
    public String updateSurveyService(Company c, CompanyUser cu, Survey s, Model model) {
        s.setCompany(c);
        s.setCompanyUser(cu);
        s.setSIsRelease("No");
        s.setSFinish(0);
        HttpSession session = getSession();
        String u_id = (String) session.getAttribute("user");
        corporateUserService.updateQuestionnaire(s);

        model.addAttribute("SurveyList", corporateUserService.getSurveyByName(u_id));
        return "part/comUser/com_survey_list";
    }

    @RequestMapping("/QuestionsList/{SId}")
    public String getQuestionsList(@PathVariable int SId, Model model) {
        HttpSession session = getSession();
        session.setAttribute("sid", SId);
        model.addAttribute("QuestionList", corporateUserService.getQuestionListBySurveyId(SId));
        return "part/comUser/com_question_list";
    }

    @PostMapping("/deleteSurvey")
    @ResponseBody
    public void deleteSurvey(int sid) {
        corporateUserService.deleteSurvey(sid);
    }

    @PostMapping("/deleteQuestion")
    @ResponseBody
    public void deleteQuestion(int qid) {
        HttpSession session = getSession();
        int sid = (int) session.getAttribute("sid");
        String uid = (String) session.getAttribute("user");
        corporateUserService.deleteQuestion(qid, sid, uid);
    }

    @RequestMapping(value = "/Select_topic_type")
    public String getTopic_type() {
        return "part/comUser/Select_topic_type";
    }

    @RequestMapping(value = "/to_addMultipleChoice")
    public String getTo_addMultipleChoice() {
        return "part/comUser/add_Multiple_choice";
    }

    @RequestMapping(value = "/addMultipleChoice")
    public String getAddMultipleChoice(Question q) {
        int i = 2;
        if (!q.getFoption().equals("")) {
            i = 6;
        } else if (!q.getEoption().equals("")) {
            i = 5;
        } else if (!q.getDoption().equals("")) {
            i = 4;
        } else if (!q.getCoption().equals("")) {
            i = 3;
        }
        QuestionId qi = new QuestionId();
        Survey su = new Survey();
        HttpSession session = getSession();
        int sid = (int) session.getAttribute("sid");
        su.setSId(sid);
        qi.setSId(sid);
        q.setId(qi);
        q.setSurvey(su);
        q.setQType("MultipleChoice");
        q.setQSize(i);
        corporateUserService.addMultipleChoice(q);
        return "part/comUser/Select_topic_type";
    }

    @RequestMapping(value = "/to_addTextQuestion")
    public String getTo_addTextQuestion() {
        return "part/comUser/add_text_question";
    }

    @RequestMapping(value = "/addTextQuestion")
    public String getaddTextQuestion(Question q) {
        int i = 0;
        QuestionId qi = new QuestionId();
        Survey su = new Survey();
        HttpSession session = getSession();
        int sid = (int) session.getAttribute("sid");
        su.setSId(sid);
        qi.setSId(sid);
        q.setId(qi);
        q.setSurvey(su);
        q.setQType("TextQuestion");
        q.setQSize(i);
        q.setAoption("");
        q.setBoption("");
        q.setCoption("");
        q.setDoption("");
        q.setEoption("");
        q.setFoption("");
        corporateUserService.addTextQuestion(q);
        return "part/comUser/Select_topic_type";
    }
    
    @RequestMapping(value="/SurveyResult/{SId}")
    public String getSurveyResult(@PathVariable int SId, Model model){
        model.addAttribute("ordinaryUserResult",corporateUserService.getSurveyResult(SId));
        return "part/comUser/Survey_Result_List";
    }
    
    @RequestMapping(value = "/CorUserRegistered")
    public String getUserRegistered(Model model) {
        model.addAttribute("company",corporateUserService.getCompanyList());
        return "CorUserRegistered";
    }
    
    @PostMapping("/companyRegister")
    public String companyRegister(Company c,Model model){
        corporateUserService.addCompany(c);
        model.addAttribute("company",corporateUserService.getCompanyList());
        return "CorUserRegistered";
    }

    @RequestMapping(value = "/SubmitQuestionnaire/{SId}")
    public String getSubmitQuestionnaire(@PathVariable int SId) {
        corporateUserService.updateSubmitQuestionnaire(SId);
    return "redirect:/corporateUser/com_survey_list "; 
    }
//       @RequestMapping("/QuestionsList/{SId}")
//    public String getQuestionsList(@PathVariable int SId, Model model) {
//        HttpSession session = getSession();
//        session.setAttribute("sid", SId);
//        model.addAttribute("QuestionList", corporateUserService.getQuestionListBySurveyId(SId));
//        return "part/comUser/com_question_list";
//    }

}
