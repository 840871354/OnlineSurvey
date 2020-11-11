package com.survey.entity;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserAnswer generated by hbm2java
 */
@Entity
@Table(name="user_answer"
    ,schema="dbo"
    ,catalog="onlineSurvey"
)
public class UserAnswer  implements java.io.Serializable {


     private UserAnswerId id;
     private OrdinaryUser ordinaryUser;
     private Survey survey;
     private String answer;

    public UserAnswer() {
    }

	
    public UserAnswer(UserAnswerId id, OrdinaryUser ordinaryUser, Survey survey) {
        this.id = id;
        this.ordinaryUser = ordinaryUser;
        this.survey = survey;
    }
    public UserAnswer(UserAnswerId id, OrdinaryUser ordinaryUser, Survey survey, String answer) {
       this.id = id;
       this.ordinaryUser = ordinaryUser;
       this.survey = survey;
       this.answer = answer;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="SId", column=@Column(name="s_id", nullable=false) ), 
        @AttributeOverride(name="QId", column=@Column(name="q_id", nullable=false) ), 
        @AttributeOverride(name="ouName", column=@Column(name="ou_name", nullable=false, length=10) ) } )
    public UserAnswerId getId() {
        return this.id;
    }
    
    public void setId(UserAnswerId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ou_name", nullable=false, insertable=false, updatable=false)
    public OrdinaryUser getOrdinaryUser() {
        return this.ordinaryUser;
    }
    
    public void setOrdinaryUser(OrdinaryUser ordinaryUser) {
        this.ordinaryUser = ordinaryUser;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="s_id", nullable=false, insertable=false, updatable=false)
    public Survey getSurvey() {
        return this.survey;
    }
    
    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    
    @Column(name="answer", length=100)
    public String getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}