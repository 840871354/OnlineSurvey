package com.survey.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.survey.entity.OrdinaryUser;
import com.survey.dao.OrdinaryUserDao;
import com.survey.entity.Question;
import com.survey.entity.Survey;
import com.survey.entity.UserAnswer;
import com.survey.entity.UserAnswerId;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class OrdinaryUserDaoImpl implements OrdinaryUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override

    public boolean getLogin(String id, String password) {
//        sessionFactory.getCurrentSession().load(OrdinaryUser.class, id);
        try {
            OrdinaryUser or = sessionFactory.getCurrentSession().load(OrdinaryUser.class, id);
            String user_password = or.getOuPassword();
            if (password.equals(user_password)) {
                return true;
            } else {
                return false;
            }

        } catch (RuntimeException re) {
            System.out.println("Error in OrdinaryUserLogin : " + re);
            return false;
        }
    }

    @Override
    public boolean getConfirm(String pass, String cpass) {
        if (pass.equals(cpass)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getPhoto(MultipartFile photo) {
        try {
            //存储图片的路径
            String path = "C:\\Users\\MIKUO\\Documents\\NetBeansProjects\\OnlineSurvey\\UserImage\\";
//            String path = "C:\\Program Files\\Tomcat\\UserImage\\";
            String relativePath = "../../../UserImage/";
            //图片原始名称
            String originalFileName = photo.getOriginalFilename();
            //新图片名称
            String newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
            //新图片
            File newFile = new File(path + newFileName);
            //将数据写入磁盘
            photo.transferTo(newFile);

            return relativePath + newFileName;
        } catch (IOException ex) {
            System.out.println("Error in Transfer : " + ex);
            return null;
        }
    }

    @Override
    public void addUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String photo) {
        System.out.println(name +" "+phone+" "+email+" "+dob+" "+hobby+" "+Gender+" "+pass+" "+photo);
        OrdinaryUser ou = new OrdinaryUser();
        ou.setOuDateOfBirth(dob);
        ou.setOuHobby(hobby);
        ou.setOuEmail(email);
        ou.setOuName(name);
        ou.setOuPassword(pass);
        ou.setOuPhone(phone);
        ou.setOuPhoto(photo);
        ou.setOuSex(Gender);
        sessionFactory.getCurrentSession().save(ou);
    }

    @Override
    public List<OrdinaryUser> getOneByName(String ouName) {
        return sessionFactory.getCurrentSession().createQuery("from OrdinaryUser where ouName=:ouName").setParameter("ouName", ouName).list();
    }

    @Override
    public void updateUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String fphoto) {
        OrdinaryUser ou = new OrdinaryUser();
        ou.setOuDateOfBirth(dob);
        ou.setOuEmail(email);
        ou.setOuHobby(hobby);
        ou.setOuName(name);
        ou.setOuPassword(pass);
        ou.setOuPhone(phone);
        ou.setOuPhoto(fphoto);
        ou.setOuSex(pass);
        sessionFactory.getCurrentSession().update(ou);
    }

    @Override
    public List<Survey> geteSurveyByOrdUser(String cuName) {
//        Query getSurvey = sessionFactory.getCurrentSession().createQuery("delete Question  as q where  q.survey=?0");

        String sql = "select distinct  survey.*from survey,user_answer where survey.s_id=user_answer.s_id and user_answer.ou_name='" + cuName + "'";
        List<Survey> list = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(Survey.class).list();
        return list;
    }

    @Override
    public void deleteAnswer(int sid, String ouName) {
        Survey su = sessionFactory.getCurrentSession().load(Survey.class, sid);
        su.setSFinish(su.getSFinish() - 1);
        sessionFactory.getCurrentSession().update(su);
        OrdinaryUser ou = sessionFactory.getCurrentSession().load(OrdinaryUser.class, ouName);
        Query deleteAs = sessionFactory.getCurrentSession().createQuery("delete UserAnswer  as u where  u.survey=?0 and u.ordinaryUser=?1");
        deleteAs.setParameter(0, su);
        deleteAs.setParameter(1, ou);
        deleteAs.executeUpdate();
    }

    @Override
    public List<Survey> geteSurveyByHobby(String ouName) {
        String hobby = null;
        Query query = sessionFactory.getCurrentSession().createQuery("from OrdinaryUser where ouName=:ouName").setParameter("ouName", ouName);
        List<OrdinaryUser> list = query.list();
        for (OrdinaryUser ou : list) {
            hobby = ou.getOuHobby();
        }
        List<Survey> survey1 = sessionFactory.getCurrentSession().createQuery("from Survey where  SKeyWord!=:KeyWord and SIsRelease='Yes'").setParameter("KeyWord", hobby).list();
        List<Survey> survey2 = sessionFactory.getCurrentSession().createQuery("from Survey where  SKeyWord=:KeyWord  and SIsRelease='Yes'").setParameter("KeyWord", hobby).list();
        survey1.addAll(survey2);
        return survey1;
    }

    @Override
    public List<Question> getQuestionaire(int SId) {
        Survey su = sessionFactory.getCurrentSession().load(Survey.class, SId);
        Query query = sessionFactory.getCurrentSession().createQuery("from Question where  QType=:type and survey=:survey");
        query.setParameter("type", "MultipleChoice");
        query.setParameter("survey", su);
        List<Question> QuestionList = query.list();
//        setParameter("type", "MultipleChoice").setParameter("survey", su).list();
////        Query query = sessionFactory.getCurrentSession().createQuery("from Question where  QType=?0 and Survey=?1");
////        query.setParameter(0, "MultipleChoice");
////        query.setParameter(1, su);
////        List<Question> QuestionList = query.executeUpdate();
        return QuestionList;
    }

    @Override
    public List<Question> getTextQuestion(int SId) {
        Survey su = sessionFactory.getCurrentSession().load(Survey.class, SId);
        Query query = sessionFactory.getCurrentSession().createQuery("from Question where  QType=:type and survey=:survey");
        query.setParameter("type", "TextQuestion");
        query.setParameter("survey", su);
        List<Question> TextQuestion = query.list();
//        setParameter("type", "TextQuestion").setParameter("survey", su)
        return TextQuestion;
    }

    @Override
    public void addChoiceAnswer(String[] option, String user, int Sid, int[] Qid) {

        for (int i = 0; i < option.length; i++) {
            sessionFactory.getCurrentSession().createSQLQuery("insert into user_answer values('" + Sid + "','" + Qid[i] + "','" + option[i] + "','" + user + "')").executeUpdate();
        }
    }

    @Override
    public void addTextAnswer(String user, int Sid, int[] Tid, String[] Answer) {
        for (int i = 0; i < Tid.length; i++) {
            sessionFactory.getCurrentSession().createSQLQuery("insert into user_answer values('" + Sid + "','" + Tid[i] + "','" + Answer[i] + "','" + user + "')").executeUpdate();
        }
    }

    @Override
    public void updateFinish(int Sid) {
        Survey su = sessionFactory.getCurrentSession().load(Survey.class, Sid);
        su.setSFinish(su.getSFinish() + 1);
        sessionFactory.getCurrentSession().update(su);
    }
}
