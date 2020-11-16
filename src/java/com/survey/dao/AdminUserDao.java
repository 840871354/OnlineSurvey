package com.survey.dao;

import com.survey.entity.CompanyUser;
import com.survey.entity.Manager;
import com.survey.entity.OrdinaryUser;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface AdminUserDao {

    boolean getLogin(String id, String password);

    List<Manager> getAllManager();

    void addOne(Manager m);

    List<OrdinaryUser> getAllOrdinaryUser();

    List<CompanyUser> getAllCompanyUser();

    void deleteCompanyUser(String cuName);

    void deleteOrdinaryUser(String ouName);

    List<OrdinaryUser> getOneOrdinaryUser(String ouName);

    List<CompanyUser> getOneCompanyUser(String cuName);

    boolean getConfirm(String pass, String cpass);

//    String getPhoto(MultipartFile photo);
    void updateOrdinaryUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass);

    void updateCompanyUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass);

    List<OrdinaryUser> searchOrdinaryUser(String search);

    List<CompanyUser> searchCompanyUser(String search);

    List getUnpublishedList();

    List getPublishedList();

    void updateApprovedQuestionnaire(int SId);

    void updateDisapprovedQuestionnaire(int SId);
}
