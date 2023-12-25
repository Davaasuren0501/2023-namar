
package ch6.complexValid;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import shared.SetByAttribute;
import shared.AttributeType;

public class ComplexDataValid {

    protected String secretCode;
    protected int happiness;
    protected String[] extra;
    protected String comments;
    protected double grade;
    protected String[] team;
    
    public ComplexDataValid() {
    }
      
    public void setSecretCode(String code) {
        this.secretCode = code;
    }
    
    public String getSecretCode() {
        return secretCode;
    }
    
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }
        
    public void setExtra(String[] extra) {
        this.extra = extra;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    public String getComments() {
        return comments;
    }
    
    public void setGrade(double grade) {
        this.grade = grade;
    }
    
    public void setTeam(String[] team) {
        this.team = team;
    }
    
    @SetByAttribute(type=AttributeType.CHECKED)
    public int getHappiness() {
        return happiness;
    }
    
    @SetByAttribute(type=AttributeType.SELECTED)
    public double getGrade() {
        return grade;
    }

    @NotNull(message=": must select at least one extra.")
    @SetByAttribute(type=AttributeType.CHECKED)
    public String[] getExtra() {
        return extra;
    }
    
    @Size(min=0, max=3, message=": cannot select all teams.")
    @SetByAttribute(type=AttributeType.SELECTED)
    public String[] getTeam() {
        return team;
    }

}
