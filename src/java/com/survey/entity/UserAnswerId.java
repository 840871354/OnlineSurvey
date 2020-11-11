package com.survey.entity;



import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserAnswerId generated by hbm2java
 */
@Embeddable
public class UserAnswerId  implements java.io.Serializable {


     private int SId;
     private int QId;
     private String ouName;

    public UserAnswerId() {
    }

    public UserAnswerId(int SId, int QId, String ouName) {
       this.SId = SId;
       this.QId = QId;
       this.ouName = ouName;
    }
   


    @Column(name="s_id", nullable=false)
    public int getSId() {
        return this.SId;
    }
    
    public void setSId(int SId) {
        this.SId = SId;
    }


    @Column(name="q_id", nullable=false)
    public int getQId() {
        return this.QId;
    }
    
    public void setQId(int QId) {
        this.QId = QId;
    }


    @Column(name="ou_name", nullable=false, length=10)
    public String getOuName() {
        return this.ouName;
    }
    
    public void setOuName(String ouName) {
        this.ouName = ouName;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UserAnswerId) ) return false;
		 UserAnswerId castOther = ( UserAnswerId ) other; 
         
		 return (this.getSId()==castOther.getSId())
 && (this.getQId()==castOther.getQId())
 && ( (this.getOuName()==castOther.getOuName()) || ( this.getOuName()!=null && castOther.getOuName()!=null && this.getOuName().equals(castOther.getOuName()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getSId();
         result = 37 * result + this.getQId();
         result = 37 * result + ( getOuName() == null ? 0 : this.getOuName().hashCode() );
         return result;
   }   


}





