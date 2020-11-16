package com.survey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.survey.service.OrdinaryUserService;
import com.survey.dao.OrdinaryUserDao;
import java.util.Date;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author NIIT
 */
@Service
public class OrdinaryUserServiceImpl implements OrdinaryUserService {

    @Autowired
    private OrdinaryUserDao ordinaryUserDao;

    @Override
    public boolean ordinaryUserLogin(String id, String password) {
        return ordinaryUserDao.getLogin(id, password);
    }

    @Override
    public boolean confirmOrdinaryUserPassword(String pass, String cpass) {
        return ordinaryUserDao.getConfirm(pass, cpass);
    }

    @Override
    public String getOrdinaryUserPhoto(MultipartFile photo) {
        return ordinaryUserDao.getPhoto(photo);
    }

    @Override
    public void addOrdinaryUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String photo) {
        ordinaryUserDao.addUser(name, phone, email, dob, hobby, Gender, pass, photo);
    }

    @Override
    public List getOrdinaryUserInfo(String ouName) {
        return ordinaryUserDao.getOneByName(ouName);
    }

    @Override
    public void updateOrdinaryUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String fphoto) {
        ordinaryUserDao.updateUser(name, phone, email, dob, hobby, Gender, pass, fphoto);
    }

    @Override
    public List getSurveyByOrdUser(String ouName) {
        return ordinaryUserDao.geteSurveyByOrdUser(ouName);
    }

    @Override
    public void deleteAnswer(int sid, String ouName) {
        ordinaryUserDao.deleteAnswer(sid, ouName);
    }

    @Override
    public List getRecommend(String ouName) {
        return ordinaryUserDao.geteSurveyByHobby(ouName);
    }

    @Override
    public List getQuestionaire(int SId) {
        return ordinaryUserDao.getQuestionaire(SId);
    }

    @Override
    public List getTextQuestion(int SId) {
        return ordinaryUserDao.getTextQuestion(SId);
    }



    @Override
    public void addChoiceAnswer(String[] choiceAnswer,String user,int Sid,int[] Qid) {
       ordinaryUserDao.addChoiceAnswer(choiceAnswer,user,Sid,Qid);
    }

    @Override
    public void addTextAnswer(String user, int Sid, int[] Tid, String[] TextAnswer) {
        ordinaryUserDao.addTextAnswer(user,Sid,Tid,TextAnswer);
    }

    @Override
    public void updateFinish(int Sid) {
       ordinaryUserDao.updateFinish(Sid);
    }



}
