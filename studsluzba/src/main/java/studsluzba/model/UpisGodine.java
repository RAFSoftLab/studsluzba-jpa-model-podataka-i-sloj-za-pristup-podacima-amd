package studsluzba.model;

import java.io.Serializable;
import java.time.LocalDate;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUpisGodine;

	public int godina;

	@ManyToMany(mappedBy = "upisGodine")
	private List<UpisGodinePredmet> upisGodinePredmet;

	@ManyToOne
	@JoinColumn(name = "tokStudija")
	private TokStudija tokStudija;

	private LocalDate datum;

	private String napomena;

	public UpisGodine() {

	}

	public UpisGodine(int godina, String napomena, LocalDate datum, TokStudija tokStudija) {

		this.godina = godina;
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

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	
	
	public List<UpisGodinePredmet> getUpisGodinePredmet() {
		return upisGodinePredmet;
	}

	public void setUpisGodinePredmet(List<UpisGodinePredmet> upisGodinePredmet) {
		this.upisGodinePredmet = upisGodinePredmet;
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
