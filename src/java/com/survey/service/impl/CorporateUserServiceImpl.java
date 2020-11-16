package com.survey.service.impl;

import com.survey.dao.CorporateUserDao;
import com.survey.entity.Company;
import com.survey.entity.Question;
import com.survey.entity.Survey;
import com.survey.service.CorporateUserService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author NIIT
 */
@Service
public class CorporateUserServiceImpl implements CorporateUserService {

    @Autowired
    private CorporateUserDao corporateUserDao;

    @Override
    public boolean corporateUserLogin(String id, String password) {
        return corporateUserDao.getLogin(id, password);
    }

    @Override
    public boolean confirmCorporateUserPassword(String pass, String cpass) {
        return corporateUserDao.getConfirm(pass, cpass);
    }

    @Override
    public String getOrdinaryUserPhoto(MultipartFile photo) {
        return corporateUserDao.getPhoto(photo);
    }

    @Override
    public void addCorporateUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String fphoto, String companyName) {
        corporateUserDao.addUser(name, phone, email, dob, hobby, Gender, pass, fphoto, companyName);
    }

    @Override
    public List getSurveyByName(String cuName) {
        return corporateUserDao.getSurveyByName(cuName);
    }

    @Override
    public String getCompany(String cuName) {
        return corporateUserDao.getCompany(cuName);
    }

    @Override
    public void addQuestionnaire(String Sname, String Cname, String Uname, String KeyWord, String Date) {
        corporateUserDao.addQuestionnaire(Sname, Cname, Uname, KeyWord, Date);
    }

    @Override
    public Survey getOneSurveyByName(int SId) {
        return corporateUserDao.getOneSurveyByName(SId);
    }

    @Override
    public void updateQuestionnaire(Survey s) {
        corporateUserDao.updateSurvey(s);
    }

    @Override
    public String getCompanyUserPhoto(MultipartFile photo) {
        return corporateUserDao.getPhoto(photo);
    }

    @Override
    public List getCompanyUserInfo(String cuName) {
        return corporateUserDao.getOneByName(cuName);
    }

    @Override
    public void updateCorporateUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String fphoto) {
        corporateUserDao.updateUser(name, phone, email, dob, hobby, Gender, pass, fphoto);
    }

    @Override
    public List getQuestionListBySurveyId(int SId) {
        return corporateUserDao.getQuestionListBySId(SId);
    }

    @Override
    public void deleteSurvey(int sid) {
        corporateUserDao.deleteSurveyBySid(sid);
    }

    @Override
    public void deleteQuestion(int qid, int sid, String uid) {
        corporateUserDao.deleteQuestion(qid, sid, uid);
    }

    @Override
    public void addMultipleChoice(Question q) {
        corporateUserDao.addMultipleChoice(q);
    }

    @Override
    public void addTextQuestion(Question q) {
        corporateUserDao.addTextQuestion(q);
    }
    
    @Override
    public List getSurveyResult(int sid) {
        return corporateUserDao.getResult(sid);
    }

    @Override
    public List getCompanyList() {
        return corporateUserDao.getAllCompany();
    }
    
    @Override
    public void addCompany(Company c) {
        corporateUserDao.add(c);
    }

    @Override
    public void updateSubmitQuestionnaire(int s) {
        corporateUserDao. updateSubmitQuestionnaire(s);
       
    }

}
