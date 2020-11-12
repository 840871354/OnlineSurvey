package com.survey.controller;

import com.survey.entity.UserAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.survey.service.OrdinaryUserService;
import static com.survey.session.Session.getSession;
import java.io.File;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ordinaryUser")

public class OrdinaryUserController {

    @Autowired
    private OrdinaryUserService ordinaryUserService;

    @GetMapping("/login")
    public ModelAndView ordinaryUserLogin(@RequestParam String id, @RequestParam String password, Model model) {
        ModelAndView access = new ModelAndView("OrdUser_Management_Page");
        ModelAndView fail = new ModelAndView("OrdUserLogin");
        HttpSession session = getSession();
        if (ordinaryUserService.ordinaryUserLogin(id, password)) {
            session.setAttribute("user", id);
            session.setAttribute("type", "OrdinaryUser");
            return access;
        } else {
            return fail;
        }
    }

    @PostMapping("/register")
    public String ordinaryUserRegister(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String cpass, @RequestParam(value = "photo") MultipartFile photo) {
        if (ordinaryUserService.confirmOrdinaryUserPassword(pass, cpass)) {
            String fphoto = ordinaryUserService.getOrdinaryUserPhoto(photo);
            if (fphoto != null) {
                ordinaryUserService.addOrdinaryUser(name, phone, email, dob, hobby, Gender, pass, fphoto);
                return "OrdUserLogin";
            } else {

                return "OrdUserRegistered";
            }
        } else {
            return "OrdUserRegistered";
        }
    }
///// add gao

    @RequestMapping(value = "to_Edit_OrdinaryUser_Info")
    public String getEdit_Personal_Info(Model model) {
        HttpSession session = getSession();
        String ouName = (String) session.getAttribute("user");
        model.addAttribute("ordinaryUser", ordinaryUserService.getOrdinaryUserInfo(ouName));
        return "Edit_OrdinaryUser_Info";
    }

    @PostMapping("/Edit_OrdinaryUser_Info")
    public String updateCompanyUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String cpass, @RequestParam(value = "photo") MultipartFile photo) {
        if (ordinaryUserService.confirmOrdinaryUserPassword(pass, cpass)) {
            String fphoto = ordinaryUserService.getOrdinaryUserPhoto(photo);
            if (fphoto != null) {
                ordinaryUserService.updateOrdinaryUser(name, phone, email, dob, hobby, Gender, pass, fphoto);
                return "CorUserLogin";
            } else {
                return "redirect:/ordinaryUser/to_Edit_OrdinaryUser_Info";
            }
        } else {
            return "redirect:/ordinaryUser/to_Edit_OrdinaryUser_Info";
        }
    }

    @RequestMapping(value = "/CompletedQuestionnaire")
    public String getCompletedQuestionnaire(Model model) {
        HttpSession session = getSession();
        String ouName = (String) session.getAttribute("user");
        model.addAttribute("SurveyList", ordinaryUserService.getSurveyByOrdUser(ouName));
        return "part/ordUser/completed_survey_list";
    }

    @PostMapping("/deleteAnswer")
    @ResponseBody
    public void deleteAnswer(int sid) {
        HttpSession session = getSession();
        String ouName = (String) session.getAttribute("user");

        ordinaryUserService.deleteAnswer(sid, ouName);
    }

    @RequestMapping(value = "/Recommend")
    public String getRecommend(Model model) {
        HttpSession session = getSession();
        String ouName = (String) session.getAttribute("user");
        model.addAttribute("SurveyList", ordinaryUserService.getRecommend(ouName));
        return "part/ordUser/recommend_survey_list";
    }

    @RequestMapping(value = "/questionaire/{SId}")
    public String getquestionaire(@PathVariable int SId, Model model, HttpSession session) {
        session.setAttribute("SId", SId);
        model.addAttribute("questionsList", ordinaryUserService.getQuestionaire(SId));
        model.addAttribute("textQuestion", ordinaryUserService.getTextQuestion(SId));
        return "part/ordUser/do_questionnaire";
    }

    @RequestMapping(value = "/submitAnswer")
    public String submitAnswer(Model model, @RequestParam("option") String[] option, @RequestParam("QId") int[] Qid, @RequestParam("TId") int[] Tid, @RequestParam("textAnswer") String[] TextAnswer) {

        HttpSession session = getSession();
        String user = (String) session.getAttribute("user");
        int Sid = (int) session.getAttribute("SId");
        ordinaryUserService.addChoiceAnswer(option, user, Sid, Qid);
        ordinaryUserService.addTextAnswer(user, Sid, Tid, TextAnswer);
        ordinaryUserService.updateFinish(Sid);
        return "redirect:/ordinaryUser/CompletedQuestionnaire";
    }
}
