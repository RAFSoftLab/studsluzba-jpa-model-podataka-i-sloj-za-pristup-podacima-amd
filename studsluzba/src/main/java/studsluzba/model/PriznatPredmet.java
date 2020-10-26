package studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "PriznatPredmet.findAll", query = "SELECT p FROM PriznatPredmet p")
public class PriznatPredmet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPriznatPredmet;
	
	@ManyToOne
	@JoinColumn(name = "idPredmeta")
	private Predmet predmet;
	
	@ManyToOne
	@JoinColumn(name = "idStudenta")
	private StudIndex studIndex;
	
	private int ocena;
	
	public PriznatPredmet() {
		
	}
	
	public PriznatPredmet(Predmet predmet, StudIndex studIndex, int ocena) {
		this.predmet = predmet;
		this.studIndex = studIndex;
		this.ocena = ocena;
	}

	public int getIdPriznatPredmet() {
		return idPriznatPredmet;
	}

	public void setIdPriznatPredmet(int idPriznatPredmet) {
		this.idPriznatPredmet = idPriznatPredmet;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public StudIndex getStudIndex() {
		return studIndex;
	}

	public void setStudIndex(StudIndex studIndex) {
		this.studIndex = studIndex;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	
	
	
}
