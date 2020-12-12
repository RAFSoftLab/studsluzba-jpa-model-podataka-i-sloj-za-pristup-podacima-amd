package studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "TokStudijaDrziPredmet.findAll", query = "SELECT z FROM TokStudijaDrziPredmet z")
public class TokStudijaDrziPredmet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTokStudijaDrziPredmet;
	
	@ManyToOne
    @JoinColumn(name = "idTokStudija")
	TokStudija tokStudija;
 
    @ManyToOne
    @JoinColumn(name = "idDrziPredmet")
    DrziPredmet drziPredmet;
    
    public TokStudijaDrziPredmet(TokStudija ts, DrziPredmet p) {
    	this.tokStudija = ts;
    	this.drziPredmet = p;
    }
    
    public TokStudijaDrziPredmet() {}

	public TokStudija getUpisGodine() {
		return tokStudija;
	}

	public void setUpisGodine(TokStudija upisGodine) {
		this.tokStudija = upisGodine;
	}

	public DrziPredmet getDrziPredmet() {
		return drziPredmet;
	}

	public void setDrziPredmet(DrziPredmet predmet) {
		this.drziPredmet = predmet;
	}
    
}
