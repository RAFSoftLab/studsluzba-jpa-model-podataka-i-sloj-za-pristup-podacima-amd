package studsluzba.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "UpisGodine.findAll", query = "SELECT ug FROM UpisGodine ug")
public class UpisGodine implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUpisGodine;
	
	public int godina;

	@ManyToOne
	@JoinColumn(name = "idPrenetogPredmeta")
	private Predmet prenetiPredmeti;

	
	@ManyToOne
	@JoinColumn(name = "tokStudija")
	private TokStudija tokStudija;
	
	private Date datum;
	
	private String napomena;
	
	public UpisGodine() {

	}

	public UpisGodine(int godina, Predmet p5, String napomena, Date datum, TokStudija tokStudija) {

		this.godina = godina;
		this.prenetiPredmeti =  p5;
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

	public Predmet getPrenetiPredmeti() {
		return prenetiPredmeti;
	}

	public void setPrenetiPredmeti(Predmet prenetiPredmeti) {
		this.prenetiPredmeti = prenetiPredmeti;
	}

	@Override
	public String toString() {
		return "UpisGodine [godina=" + godina + ", datum=" + datum + ", napomena=" + napomena + "]";
	}

	public TokStudija getTokStudija() {
		return tokStudija;
	}

	public void setTokStudija(TokStudija tokStudija) {
		this.tokStudija = tokStudija;
	}
	
	

}
