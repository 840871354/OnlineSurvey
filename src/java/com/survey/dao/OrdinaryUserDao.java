package com.survey.dao;

import com.survey.entity.OrdinaryUser;
import com.survey.entity.Survey;
import com.survey.entity.Question;
import java.util.Date;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface OrdinaryUserDao {

    boolean getLogin(String id, String password);

    boolean getConfirm(String pass, String cpass);

    String getPhoto(MultipartFile photo);

    void addUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String photo);

    List<OrdinaryUser> getOneByName(String ouName);

    void updateUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String fphoto);

    List<Survey> geteSurveyByOrdUser(String cuName);

    void deleteAnswer(int sid, String ouName);

    List<Survey> geteSurveyByHobby(String ouName);

    List<Question> getQuestionaire(int SId);

    List<Question> getTextQuestion(int SId);

    void addChoiceAnswer(String[] option, String user, int Sid, int[] Qid);

    void addTextAnswer(String user, int Sid, int[] Tid, String[] Answer);

    void updateFinish(int Sid);
}
