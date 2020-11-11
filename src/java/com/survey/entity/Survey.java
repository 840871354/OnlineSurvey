package com.survey.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Survey generated by hbm2java
 */
@Entity
@Table(name="survey"
    ,schema="dbo"
    ,catalog="onlineSurvey"
)
public class Survey  implements java.io.Serializable {


     private int SId;
     private Company company;
     private CompanyUser companyUser;
     private String SName;
     private String SKeyWord;
     private Integer SFinish;
     private String SIsRelease;
     private Date SDateOfRelease;
     private Set<UserAnswer> userAnswers = new HashSet(0);
     private Set<Question> questions = new HashSet(0);

    public Survey() {
    }

	
    public Survey(int SId) {
        this.SId = SId;
    }
    public Survey(int SId, Company company, CompanyUser companyUser, String SName, String SKeyWord, Integer SFinish, String SIsRelease, Date SDateOfRelease, Set userAnswers, Set questions) {
       this.SId = SId;
       this.company = company;
       this.companyUser = companyUser;
       this.SName = SName;
       this.SKeyWord = SKeyWord;
       this.SFinish = SFinish;
       this.SIsRelease = SIsRelease;
       this.SDateOfRelease = SDateOfRelease;
       this.userAnswers = userAnswers;
       this.questions = questions;
    }
   
     @Id 

    
    @Column(name="s_id", unique=true, nullable=false)
    public int getSId() {
        return this.SId;
    }
    
    public void setSId(int SId) {
        this.SId = SId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="companyName")
    public Company getCompany() {
        return this.company;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cu_name")
    public CompanyUser getCompanyUser() {
        return this.companyUser;
    }
    
    public void setCompanyUser(CompanyUser companyUser) {
        this.companyUser = companyUser;
    }

    
    @Column(name="s_name", length=100)
    public String getSName() {
        return this.SName;
    }
    
    public void setSName(String SName) {
        this.SName = SName;
    }

    
    @Column(name="s_keyWord", length=10)
    public String getSKeyWord() {
        return this.SKeyWord;
    }
    
    public void setSKeyWord(String SKeyWord) {
        this.SKeyWord = SKeyWord;
    }

    
    @Column(name="s_finish")
    public Integer getSFinish() {
        return this.SFinish;
    }
    
    public void setSFinish(Integer SFinish) {
        this.SFinish = SFinish;
    }

    
    @Column(name="s_isRelease", length=20)
    public String getSIsRelease() {
        return this.SIsRelease;
    }
    
    public void setSIsRelease(String SIsRelease) {
        this.SIsRelease = SIsRelease;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="s_dateOfRelease", length=10)
    public Date getSDateOfRelease() {
        return this.SDateOfRelease;
    }
    
    public void setSDateOfRelease(Date SDateOfRelease) {
        this.SDateOfRelease = SDateOfRelease;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="survey",targetEntity=UserAnswer.class)
    public Set getUserAnswers() {
        return this.userAnswers;
    }
    
    public void setUserAnswers(Set<UserAnswer> userAnswers) {
        this.userAnswers = userAnswers;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="survey",targetEntity=Question.class)
    public Set getQuestions() {
        return this.questions;
    }
    
    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }




}


