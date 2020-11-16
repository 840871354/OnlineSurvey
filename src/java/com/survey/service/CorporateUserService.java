package com.survey.service;

import com.survey.entity.Company;
import com.survey.entity.OrdinaryUser;
import com.survey.entity.Question;
import com.survey.entity.Survey;
import java.util.Date;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface CorporateUserService {

    boolean corporateUserLogin(String id, String password);

    boolean confirmCorporateUserPassword(String pass, String cpass);

    String getOrdinaryUserPhoto(MultipartFile photo);

    String getCompanyUserPhoto(MultipartFile photo);

    void addCorporateUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String fphoto, String companyName);

    List getSurveyByName(String cuName);

    List getCompanyUserInfo(String cuName);

    void updateCorporateUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String fphoto);

    String getCompany(String cuName);

    void addQuestionnaire(String Sname, String Cname, String Uname, String KeyWord, String Date);

    Survey getOneSurveyByName(int SId);

    void updateQuestionnaire(Survey s);

    List getQuestionListBySurveyId(int SId);

    void deleteSurvey(int sid);

    void deleteQuestion(int qid, int sid, String uid);

    void addMultipleChoice(Question q);

    void addTextQuestion(Question q);
    
    void updateSubmitQuestionnaire(int SId);
    
    List getSurveyResult(int sid);
    
    List getCompanyList();
    
    void addCompany(Company c);
}
