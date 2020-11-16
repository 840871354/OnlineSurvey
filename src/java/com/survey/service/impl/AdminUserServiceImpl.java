package com.survey.service.impl;
import com.survey.dao.AdminUserDao;
import com.survey.entity.Manager;
import com.survey.service.AdminUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author NIIT
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private  AdminUserDao adminUserDao;

    @Override
    public boolean adminUserLogin(String id,String password) {
        return adminUserDao.getLogin(id,password);
    }

    @Override
    public List getManagerInformation() {
        return adminUserDao.getAllManager();
    }

    @Override
    public void addManager(Manager m) {
        adminUserDao.addOne(m);
    }

    @Override
    public List getOrdinaryUserInformation() {
        return adminUserDao.getAllOrdinaryUser();
    }

    @Override
    public List getCompanyUserInformation() {
        return adminUserDao.getAllCompanyUser();
    }

    @Override
    public void deleteOneCompanyUser(String cuName) {
        adminUserDao.deleteCompanyUser(cuName);
    }

    @Override
    public void deleteOneOrdinaryUser(String ouName) {
        adminUserDao.deleteOrdinaryUser(ouName);
    }

    @Override
    public List getOneOrdinaryUser(String ouName) {
        return adminUserDao.getOneOrdinaryUser(ouName);
    }

    @Override
    public List getOneCompanyUser(String cuName) {
        return adminUserDao.getOneCompanyUser(cuName);
    }

    @Override
    public boolean confirmOrdinaryUserPassword(String pass, String cpass) {
        return adminUserDao.getConfirm(pass, cpass);
    }

//    @Override
//    public String getOrdinaryUserPhoto(MultipartFile photo) {
//        return adminUserDao.getPhoto(photo);
//    }

    @Override
    public void updateOrdinaryUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass) {
        adminUserDao.updateOrdinaryUser(name, phone, email, dob, hobby, Gender, pass);
    }

    @Override
    public boolean confirmCorporateUserPassword(String pass, String cpass) {
        return adminUserDao.getConfirm(pass, cpass);
    }

    @Override
    public void updateCorporateUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass) {
        adminUserDao.updateCompanyUser(name, phone, email, dob, hobby, Gender, pass);
    }

    @Override
    public List searchOrdinaryUserInformation(String search) {
        return adminUserDao.searchOrdinaryUser(search);
    }

    @Override
    public List searchCompanyUserInformation(String search) {
        return adminUserDao.searchCompanyUser(search);
    }

    @Override
    public List getUnpublishedList() {
        return adminUserDao.getUnpublishedList();
    }

    @Override
    public void updateApprovedQuestionnaire(int SId) {
        adminUserDao.updateApprovedQuestionnaire(SId);
    }

    @Override
    public void updateDisapprovedQuestionnaire(int SId) {
      adminUserDao.updateDisapprovedQuestionnaire(SId);
    }

    @Override
    public List getPublishedList() {
       return adminUserDao.getPublishedList();
    }
    

}
