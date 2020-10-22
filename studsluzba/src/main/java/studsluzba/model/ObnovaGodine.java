package studsluzba.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@OneToMany(mappedBy = "obnovaGodine")
	private List<TokStudija> tokStudija;

	@OneToMany
	@JoinColumn(name = "idPredmeta")
	private List<Predmet> ponovljeniPredmeti;

	
	private Date datum;
	
	private String napomena;


	public ObnovaGodine(int godina, List<Predmet> ponovljeniPredmeti, String napomena, Date datum) {

		this.godina = godina;
		this.ponovljeniPredmeti =  ponovljeniPredmeti;
		this.datum = datum;
		this.napomena = napomena;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public List<Predmet> getPonovljeniPredmeti() {
		return ponovljeniPredmeti;
	}

	public void setPonovljeniPredmeti(List<Predmet> ponovljeniPredmeti) {
		this.ponovljeniPredmeti = ponovljeniPredmeti;
	}

	public int getIdObnovaGodine() {
		return idObnovaGodine;
	}

	public void setIdObnovaGodine(int idObnovaGodine) {
		this.idObnovaGodine = idObnovaGodine;
	}

	public List<TokStudija> getTokStudija() {
		return tokStudija;
	}

	public void setTokStudija(List<TokStudija> tokStudija) {
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
	
	

}
