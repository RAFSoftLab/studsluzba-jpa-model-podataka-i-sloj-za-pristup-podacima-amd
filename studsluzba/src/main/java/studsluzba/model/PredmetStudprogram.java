package studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "PredmetStudprogram.findAll", query = "SELECT psp FROM PredmetStudprogram psp")
public class PredmetStudprogram {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPredmetStudprogram;

	@ManyToOne
    @JoinColumn(name = "idPredmeta")
	Predmet predmet;
 
    @ManyToOne
    @JoinColumn(name = "idstudProgram")
    Studprogram studProgram;
    
    public PredmetStudprogram(Predmet p, Studprogram sp) {
    	this.predmet = p;
    	this.studProgram = sp;
    }

    public PredmetStudprogram() {
    	
    }

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Studprogram getStudProgram() {
		return studProgram;
	}

	public void setStudProgram(Studprogram studProgram) {
		this.studProgram = studProgram;
	}

	public int getIdPredmetStudprogram() {
		return idPredmetStudprogram;
	}
    
}
