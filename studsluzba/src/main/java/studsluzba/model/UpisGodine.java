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

	
	@OneToMany(mappedBy = "upisGodine")
	private List<TokStudija> tokStudija;
	
	private Date datum;
	
	private String napomena;
	
	public UpisGodine() {

	}

	public UpisGodine(int godina, Predmet p5, String napomena, Date datum) {

		this.godina = godina;
		this.prenetiPredmeti =  p5;
		this.datum = datum;
		this.napomena = napomena;
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

}
