package studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "UpisGodinePredmet.findAll", query = "SELECT z FROM UpisGodinePredmet z")
public class UpisGodinePredmet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUpisGodinePredmet;
	
	@ManyToOne
    @JoinColumn(name = "idUpisGodine")
    UpisGodine upisGodine;
 
    @ManyToOne
    @JoinColumn(name = "idPredmeta")
    Predmet predmet;
    
    public UpisGodinePredmet(UpisGodine ug, Predmet p) {
    	this.upisGodine = ug;
    	this.predmet = p;
    }
    
    public UpisGodinePredmet() {}

	public UpisGodine getUpisGodine() {
		return upisGodine;
	}

	public void setUpisGodine(UpisGodine upisGodine) {
		this.upisGodine = upisGodine;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
    
}
