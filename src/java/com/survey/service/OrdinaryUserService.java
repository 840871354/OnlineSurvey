package com.survey.service;

import java.util.Date;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface OrdinaryUserService {

    boolean ordinaryUserLogin(String id, String password);

    boolean confirmOrdinaryUserPassword(String pass, String cpass);

    String getOrdinaryUserPhoto(MultipartFile photo);

    void addOrdinaryUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String photo);

    List getOrdinaryUserInfo(String ouName);

    void updateOrdinaryUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String fphoto);

    List getSurveyByOrdUser(String ouName);

    void deleteAnswer(int sid, String ouName);

    List getRecommend(String ouName);

    List getQuestionaire(int SId);

    List getTextQuestion(int SId);

    void addChoiceAnswer(String[] TextAnswer, String user, int Sid, int[] Tid);

    void addTextAnswer(String user, int Sid, int[] Tid, String[] TextAnswer);
    
    void updateFinish(int Sid);
}
