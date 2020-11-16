package com.survey.service;

import com.survey.entity.Manager;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface AdminUserService {

    boolean adminUserLogin(String id, String password);

    List getManagerInformation();

    void addManager(Manager m);

    List getOrdinaryUserInformation();

    List getCompanyUserInformation();

    void deleteOneCompanyUser(String cuName);

    void deleteOneOrdinaryUser(String ouName);

    List getOneOrdinaryUser(String ouName);

    List getOneCompanyUser(String cuName);

    boolean confirmOrdinaryUserPassword(String pass, String cpass);

//    String getOrdinaryUserPhoto(MultipartFile photo);
    void updateOrdinaryUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass);

    boolean confirmCorporateUserPassword(String pass, String cpass);

    void updateCorporateUser(String name, String phone, String email, String dob, String hobby, String Gender, String pass);

    List searchOrdinaryUserInformation(String search);

    List searchCompanyUserInformation(String search);

    List getUnpublishedList();

    List getPublishedList();

    void updateApprovedQuestionnaire(int SId);

    void updateDisapprovedQuestionnaire(int SId);
}
