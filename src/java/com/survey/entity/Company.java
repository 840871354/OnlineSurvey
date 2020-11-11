package com.survey.entity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Company generated by hbm2java
 */
@Entity
@Table(name="company"
    ,schema="dbo"
    ,catalog="onlineSurvey"
)
public class Company  implements java.io.Serializable {


     private String companyName;
     private String companyType;
     private String companyIndustry;
     private String companyScale;
     private String companyIntroduction;
     private Set<Survey> surveys = new HashSet(0);
     private Set<CompanyUser> companyUsers = new HashSet(0);

    public Company() {
    }

	
    public Company(String companyName) {
        this.companyName = companyName;
    }
    public Company(String companyName, String companyType, String companyIndustry, String companyScale, String companyIntroduction, Set surveys, Set companyUsers) {
       this.companyName = companyName;
       this.companyType = companyType;
       this.companyIndustry = companyIndustry;
       this.companyScale = companyScale;
       this.companyIntroduction = companyIntroduction;
       this.surveys = surveys;
       this.companyUsers = companyUsers;
    }
   
     @Id 

    
    @Column(name="companyName", unique=true, nullable=false, length=50)
    public String getCompanyName() {
        return this.companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    
    @Column(name="companyType", length=30)
    public String getCompanyType() {
        return this.companyType;
    }
    
    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    
    @Column(name="companyIndustry", length=30)
    public String getCompanyIndustry() {
        return this.companyIndustry;
    }
    
    public void setCompanyIndustry(String companyIndustry) {
        this.companyIndustry = companyIndustry;
    }

    
    @Column(name="companyScale", length=10)
    public String getCompanyScale() {
        return this.companyScale;
    }
    
    public void setCompanyScale(String companyScale) {
        this.companyScale = companyScale;
    }

    
    @Column(name="companyIntroduction", length=1000)
    public String getCompanyIntroduction() {
        return this.companyIntroduction;
    }
    
    public void setCompanyIntroduction(String companyIntroduction) {
        this.companyIntroduction = companyIntroduction;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="company",targetEntity=Survey.class)
    public Set getSurveys() {
        return this.surveys;
    }
    
    public void setSurveys(Set<Survey> surveys) {
        this.surveys = surveys;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="company",targetEntity=CompanyUser.class)
    public Set getCompanyUsers() {
        return this.companyUsers;
    }
    
    public void setCompanyUsers(Set<CompanyUser> companyUsers) {
        this.companyUsers = companyUsers;
    }




}


