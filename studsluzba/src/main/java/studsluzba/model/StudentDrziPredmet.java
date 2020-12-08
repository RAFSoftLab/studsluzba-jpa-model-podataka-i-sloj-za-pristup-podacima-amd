package studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="StudentDrziPredmet.findAll", query="SELECT d FROM StudentDrziPredmet d")
public class StudentDrziPredmet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStudentDrziPredmet;

	@ManyToOne
    @JoinColumn(name = "idIndex")
    StudIndex studIndex;
 
    @ManyToOne
    @JoinColumn(name = "idDrziPremet")
    DrziPredmet drziPredmet;
    
    public StudentDrziPredmet() {
    	
    }
    
    // komentar
    
    public StudentDrziPredmet(DrziPredmet dp, StudIndex si) {
    	this.studIndex = si;
    	this.drziPredmet = dp;
    }

	public StudIndex getStudIndex() {
		return studIndex;
	}

	public void setStudIndex(StudIndex studIndex) {
		this.studIndex = studIndex;
	}

	public DrziPredmet getDrziPredmet() {
		return drziPredmet;
	}

	public void setDrziPredmet(DrziPredmet drziPredmet) {
		this.drziPredmet = drziPredmet;
	}
    
    
}
