package com.survey.dao;

import com.survey.entity.Company;
import com.survey.entity.CompanyUser;
import com.survey.entity.Question;
import com.survey.entity.Survey;
import com.survey.entity.UserAnswer;
import java.util.Date;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface CorporateUserDao {

    boolean getLogin(String id, String password);

    boolean getConfirm(String pass, String cpass);

    String getPhoto(MultipartFile photo);

    void addUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String fphoto, String companyName);

    List<Survey> getSurveyByName(String cuName);

    String getCompany(String cuName);

    void addQuestionnaire(String Sname, String Cname, String Uname, String KeyWord, String Date);

    Survey getOneSurveyByName(int SId);

    List<CompanyUser> getOneByName(String cuName);

    void updateUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String fphoto);

    void updateSurvey(Survey s);
    
    List<Question> getQuestionListBySId(int SId);
     
     void deleteSurveyBySid(int sid);
     
     void deleteQuestion(int qid,int sid,String uid);
     
     void addMultipleChoice(Question q);
     
     void addTextQuestion(Question q);
     
     List<UserAnswer> getResult(int sid);
     
     List<Company> getAllCompany();
     
     void add(Company c);
     
     void updateSubmitQuestionnaire(int s);
}
