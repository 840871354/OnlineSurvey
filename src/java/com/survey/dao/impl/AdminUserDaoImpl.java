package com.survey.dao.impl;

import com.survey.dao.AdminUserDao;
import com.survey.entity.CompanyUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.survey.entity.Manager;
import com.survey.entity.OrdinaryUser;
import com.survey.entity.Survey;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class AdminUserDaoImpl implements AdminUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean getLogin(String id, String password) {
        try {
            Manager ma = sessionFactory.getCurrentSession().load(Manager.class, id);
            String user_password = ma.getMPassword();
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
    public void addOne(Manager m) {
        sessionFactory.getCurrentSession().save(m);
    }

    @Override
    public List<Manager> getAllManager() {
        return sessionFactory.getCurrentSession().createQuery("from Manager").list();
    }

    @Override
    public List<OrdinaryUser> getAllOrdinaryUser() {
        return sessionFactory.getCurrentSession().createQuery("from OrdinaryUser").list();
    }

    @Override
    public List<CompanyUser> getAllCompanyUser() {
        return sessionFactory.getCurrentSession().createQuery("from CompanyUser").list();
    }

    @Override
    public void deleteCompanyUser(String cuName) {
        CompanyUser cu = sessionFactory.getCurrentSession().load(CompanyUser.class, cuName);
        sessionFactory.getCurrentSession().delete(cu);
    }

    @Override
    public void deleteOrdinaryUser(String ouName) {
        OrdinaryUser ou = sessionFactory.getCurrentSession().load(OrdinaryUser.class, ouName);
        sessionFactory.getCurrentSession().delete(ou);
    }

    @Override
    public List<OrdinaryUser> getOneOrdinaryUser(String ouName) {
        return sessionFactory.getCurrentSession().createQuery("from OrdinaryUser where ouName=:ouName").setParameter("ouName", ouName).list();
    }

    @Override
    public List<CompanyUser> getOneCompanyUser(String cuName) {
        return sessionFactory.getCurrentSession().createQuery("from CompanyUser where cuName=:cuName").setParameter("cuName", cuName).list();
    }

    @Override
    public boolean getConfirm(String pass, String cpass) {
        if (pass.equals(cpass)) {
            return true;
        } else {
            return false;
        }
    }

//    @Override
//    public String getPhoto(MultipartFile photo) {
//        try {
//            String path = "C:\\Users\\13704\\Desktop\\OnlineSurvey\\UserImage\\";
////            String path = "C:\\Program Files\\Tomcat\\UserImage\\";
//            String relativePath = "../../../UserImage/";
//            String originalFileName = photo.getOriginalFilename();
//            String newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
//            File newFile = new File(path + newFileName);
//            photo.transferTo(newFile);
//            return relativePath + newFileName;
//        } catch (IOException ex) {
//            System.out.println("Error in Transfer : " + ex);
//            return null;
//        }
//    }
    @Override
    public void updateOrdinaryUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass) {
        OrdinaryUser ou = sessionFactory.getCurrentSession().load(OrdinaryUser.class, name);
        ou.setOuDateOfBirth(dob);
        ou.setOuEmail(email);
        ou.setOuHobby(hobby);
        ou.setOuPassword(pass);
        ou.setOuPhone(phone);
        sessionFactory.getCurrentSession().update(ou);
    }

    @Override
    public void updateCompanyUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass) {
        CompanyUser cu = sessionFactory.getCurrentSession().load(CompanyUser.class, name);
        cu.setCuDateOfBirth(dob);
        cu.setCuEmail(email);
        cu.setCuHobby(hobby);
        cu.setCuPassword(pass);
        cu.setCuPhone(phone);
        sessionFactory.getCurrentSession().update(cu);
    }

    @Override
    public List<OrdinaryUser> searchOrdinaryUser(String search) {
        return sessionFactory.getCurrentSession().createQuery("from OrdinaryUser where ouName = :search or ouPhone = :search or ouEmail = :search or ouSex = :search or ouHobby = :search").setParameter("search", search).list();
    }

    @Override
    public List<CompanyUser> searchCompanyUser(String search) {
        return sessionFactory.getCurrentSession().createQuery("from CompanyUser where cuName = :search or cuPhone = :search or cuEmail = :search or cuSex = :search or cuHobby = :search").setParameter("search", search).list();
    }

    @Override
    public List getUnpublishedList() {
        return sessionFactory.getCurrentSession().createQuery("from Survey where  SIsRelease=:Release").setParameter("Release", "UnderReview").list();
    }

    @Override
    public void updateApprovedQuestionnaire(int SId) {
        Survey su = sessionFactory.getCurrentSession().load(Survey.class, SId);
        System.out.println(su.getSId());
        su.setSIsRelease("Yes");
        sessionFactory.getCurrentSession().update(su);
    }

    public void updateDisapprovedQuestionnaire(int SId) {
        Survey su = sessionFactory.getCurrentSession().load(Survey.class, SId);
        System.out.println(su.getSId());
        su.setSIsRelease("No");
        sessionFactory.getCurrentSession().update(su);
    }

    @Override
    public List getPublishedList() {
          return sessionFactory.getCurrentSession().createQuery("from Survey where  SIsRelease=:Release").setParameter("Release", "Yes").list();
    }
}
