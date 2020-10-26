package studsluzba.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "obnovagodine")
@NamedQuery(name = "ObnovaGodine.findAll", query = "SELECT og FROM ObnovaGodine og")
public class ObnovaGodine implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idObnovaGodine;
	
	private int godina;
	
	@ManyToOne
	@JoinColumn(name = "tokStudija")
	private TokStudija tokStudija;
	
	@ManyToOne
	@JoinColumn(name = "idPredmeta")
	private Predmet ponovljeniPredmeti;

	
	private Date datum;
	
	private String napomena;

	public ObnovaGodine() {
		
	}

	public ObnovaGodine(int godina, Predmet ponovljeniPredmeti, String napomena, Date datum, TokStudija tokStudija) {

		this.godina = godina;
		this.ponovljeniPredmeti =  ponovljeniPredmeti;
		this.datum = datum;
		this.napomena = napomena;
		this.tokStudija = tokStudija;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public Predmet getPonovljeniPredmeti() {
		return ponovljeniPredmeti;
	}

	public void setPonovljeniPredmeti(Predmet ponovljeniPredmeti) {
		this.ponovljeniPredmeti = ponovljeniPredmeti;
	}

	public int getIdObnovaGodine() {
		return idObnovaGodine;
	}

	public void setIdObnovaGodine(int idObnovaGodine) {
		this.idObnovaGodine = idObnovaGodine;
	}

	

	public TokStudija getTokStudija() {
		return tokStudija;
	}

	public void setTokStudija(TokStudija tokStudija) {
		this.tokStudija = tokStudija;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	@Override
	public String toString() {
		return "ObnovaGodine [idObnovaGodine=" + idObnovaGodine + ", godina=" + godina + ", datum=" + datum + ", napomena=" + napomena + "]";
	}
	
	

}
