package com.survey.dao.impl;

import com.survey.dao.CorporateUserDao;
import com.survey.entity.Company;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.survey.entity.CompanyUser;
import com.survey.entity.OrdinaryUser;
import com.survey.entity.Question;
import com.survey.entity.QuestionId;
import com.survey.entity.Survey;
import com.survey.entity.UserAnswer;
import com.survey.entity.UserAnswerId;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.hibernate.query.Query;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class CorporateUserDaoImpl implements CorporateUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean getLogin(String id, String password) {
        try {
            CompanyUser co = sessionFactory.getCurrentSession().load(CompanyUser.class, id);
            String user_password = co.getCuPassword();
            if (password.equals(user_password)) {
                return true;
            } else {
                return false;
            }
        } catch (RuntimeException re) {
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
            String relativePath = "/pic/";
            String originalFileName = photo.getOriginalFilename();
            String newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
            File dirs = new File("d:/upload");
            if(!dirs.exists()){
                dirs.mkdirs();
            }
            File newFile = new File(dirs, newFileName);
            photo.transferTo(newFile);
            return relativePath + newFileName;
        } catch (IOException ex) {
            System.out.println("Error in Transfer : " + ex);
            return null;
        }
    }

    @Override
    public void addUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String fphoto, String companyName) {
        CompanyUser cu = new CompanyUser();
        Company c = new Company();
        c.setCompanyName(companyName);
        cu.setCompany(c);
        cu.setCuDateOfBirth(dob);
        cu.setCuEmail(email);
        cu.setCuHobby(hobby);
        cu.setCuName(name);
        cu.setCuPassword(pass);
        cu.setCuPhone(phone);
        cu.setCuSex(Gender);
        cu.setCuPhoto(fphoto);
        sessionFactory.getCurrentSession().save(cu);
    }

    @Override
    public List<Survey> getSurveyByName(String cuName) {
        CompanyUser cu = sessionFactory.getCurrentSession().load(CompanyUser.class, cuName);
//        selefct SId,SName,SKeyWord,SFinish,SIsRelease,SDateOfRelease
        return sessionFactory.getCurrentSession().createQuery("from Survey where  companyUser=:cuName").setParameter("cuName", cu).list();
    }

    @Override
    public String getCompany(String cuName) {
        CompanyUser cu = sessionFactory.getCurrentSession().load(CompanyUser.class, cuName);
        String CompanyName = cu.getCompany().getCompanyName();
        return CompanyName;
    }

    @Override
    public void addQuestionnaire(String Sname, String Cname, String Uname, String KeyWord, String date) {
        int finish = 0;
        String IsRelease = "No";
        String sql = "insert into survey values('" + Sname + "','" + Cname + "','" + Uname + "','" + KeyWord + "','" + finish + "','" + IsRelease + "','" + date + "')";
        sessionFactory.getCurrentSession().createSQLQuery(sql).executeUpdate();
    }

    @Override
    public Survey getOneSurveyByName(int SId) {
        return sessionFactory.getCurrentSession().get(Survey.class, SId);
    }

    @Override
    public void updateSurvey(Survey s) {
        sessionFactory.getCurrentSession().update(s);
    }

    @Override
    public List<CompanyUser> getOneByName(String cuName) {
//        List<CompanyUser> cu = sessionFactory.getCurrentSession().createQuery("from CompanyUser where cuName=:cuName").setParameter("cuName", cuName).list();
        return sessionFactory.getCurrentSession().createQuery("from CompanyUser where cuName=:cuName").setParameter("cuName", cuName).list();
    }

    @Override
    public void updateUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass, String fphoto) {
        CompanyUser cu = new CompanyUser();
        cu.setCuDateOfBirth(dob);
        cu.setCuEmail(email);
        cu.setCuHobby(hobby);
        cu.setCuName(name);
        cu.setCuPassword(pass);
        cu.setCuPhone(phone);
        cu.setCuPhoto(fphoto);
        cu.setCuSex(Gender);
//        sessionFactory.getCurrentSession().createSQLQuery("update companyUser set cu_photo ='" + fphoto + "',cu_phone = '" + phone + "',cu_email='" + email + "',cu_password='" + pass + "',cu_sex='" + Gender + "',cu_dateOfBirth='" + dob + "',cu_hobby='" + hobby + "' where cu_name='" + name + "' ");
        sessionFactory.getCurrentSession().update(cu);
    }

    @Override
    public List<Question> getQuestionListBySId(int SId) {
        Survey su = sessionFactory.getCurrentSession().load(Survey.class, SId);
        List<Question> list = sessionFactory.getCurrentSession().createQuery("from Question where survey=:S").setParameter("S", su).list();
        return list;
    }

    @Override
    public void deleteSurveyBySid(int sid) {
        Survey su = sessionFactory.getCurrentSession().load(Survey.class, sid);

        Query deleteAs = sessionFactory.getCurrentSession().createQuery("delete UserAnswer  as u where  u.survey=?0");
        deleteAs.setParameter(0, su);
        deleteAs.executeUpdate();

        Query deleteQs = sessionFactory.getCurrentSession().createQuery("delete Question  as q where  q.survey=?0");
        deleteQs.setParameter(0, su);
        deleteQs.executeUpdate();

        sessionFactory.getCurrentSession().delete(su);
    }

    @Override
    public void deleteQuestion(int qid, int sid, String uid) {
        Survey su = new Survey();
        su.setSId(sid);

        System.out.println("QID" + qid + "SID" + sid + "UID" + uid);
        UserAnswerId uai = new UserAnswerId();
        uai.setQId(qid);
        uai.setSId(sid);
        OrdinaryUser ou = new OrdinaryUser();
        ou.setOuName(uid);
        Query DelAns = sessionFactory.getCurrentSession().createQuery("delete UserAnswer as ua where ua.survey=?0");
//        DelAns.setParameter(0, uai);s
//        DelAns.setParameter(1, ou);
        DelAns.setParameter(0, su);
        DelAns.executeUpdate();

        QuestionId qi = new QuestionId();
        qi.setQId(qid);
        qi.setSId(sid);
        Query DelQue = sessionFactory.getCurrentSession().createQuery("delete Question as q where q.survey=?0 and q.id=?1");
        DelQue.setParameter(0, su);
        DelQue.setParameter(1, qi);
        DelQue.executeUpdate();
//                Query deleteQs = sessionFactory.getCurrentSession().createQuery("delete Question  as q where  q.survey=?0");
//        deleteQs.setParameter(0, su);
//        deleteQs.executeUpdate();
    }

    @Override
    public void addMultipleChoice(Question q) {
        String sql = "insert into question values('" + q.getSurvey().getSId() + "','" + q.getQContent() + "','" + q.getAoption() + "','" + q.getBoption() + "','" + q.getCoption() + "','" + q.getDoption() + "','" + q.getEoption() + "','" + q.getFoption() + "','" + q.getQType() + "','" + q.getQSize() + "')";
        sessionFactory.getCurrentSession().createSQLQuery(sql).executeUpdate();
    }

    @Override
    public void addTextQuestion(Question q) {
        String sql = "insert into question values('" + q.getSurvey().getSId() + "','" + q.getQContent() + "','" + q.getAoption() + "','" + q.getBoption() + "','" + q.getCoption() + "','" + q.getDoption() + "','" + q.getEoption() + "','" + q.getFoption() + "','" + q.getQType() + "','" + q.getQSize() + "')";
        sessionFactory.getCurrentSession().createSQLQuery(sql).executeUpdate();
    }
    
    @Override
    public List<UserAnswer> getResult(int sid) {
        List<UserAnswer> list = sessionFactory.getCurrentSession().createSQLQuery("select * from user_answer where s_id = '"+sid+"'").addEntity(UserAnswer.class).list();
        return list;
    }

    @Override
    public List<Company> getAllCompany() {
        List<Company> list = sessionFactory.getCurrentSession().createQuery("from Company").list();
        System.out.println(list.get(0).getCompanyName());
        return list;
    }
    
    @Override
    public void add(Company c) {
        sessionFactory.getCurrentSession().save(c);
    }

    @Override
    public void updateSubmitQuestionnaire(int s) {
        Survey su = sessionFactory.getCurrentSession().load(Survey.class, s);
        String re = su.getSIsRelease();
        if (re.equals("No")) {
            su.setSIsRelease("UnderReview");
        }
        sessionFactory.getCurrentSession().update(su);
    }
}
