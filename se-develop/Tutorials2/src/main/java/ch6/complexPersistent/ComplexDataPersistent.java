
package ch6.complexPersistent;
import java.io.Serializable;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.IndexColumn;
import shared.SetByAttribute;
import shared.AttributeType;

@Entity
public class ComplexDataPersistent implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Long id;
    
    @Id
    @GeneratedValue 
    public Long getId() { return id; }

    @SuppressWarnings("unused")
	private void setId(Long id) { this.id = id; }

    protected String secretCode;
    protected int happiness;
    protected String[] extra;
    protected String comments;
    protected double grade;
    protected String[] team;
    
    public ComplexDataPersistent() {
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

    @ElementCollection
    @IndexColumn(name="extra_pos", base=0)
    @SetByAttribute(type=AttributeType.CHECKED)
    @NotNull(message=": must select at least one extra.")
    public String[] getExtra() {
        return extra;
    }
 
    @ElementCollection
    @IndexColumn(name="team_pos", base=0)
    @SetByAttribute(type=AttributeType.SELECTED)
    @Size(min=0, max=3, message=": cannot select all teams.")
    public String[] getTeam() {
        return team;
    }

}
