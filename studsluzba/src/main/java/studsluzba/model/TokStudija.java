package studsluzba.model;

import java.io.Serializable;
import java.time.LocalDate;
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

@Entity
@NamedQuery(name = "TokStudija.findAll", query = "SELECT ts FROM TokStudija ts")
public class TokStudija implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTokStudija;

	@ManyToMany(mappedBy = "tokStudija")
	private List<UpisGodine> upisGodine;

	@ManyToMany(mappedBy = "tokStudija")
	private List<ObnovaGodine> obnovaGodine;
	
	@ManyToMany(mappedBy = "tokStudija")
	private List<TokStudijaDrziPredmet> tokStudijaDrziPredmet;

	@ManyToOne
	@JoinColumn(name = "idStudIndex")
	private StudIndex studIndex;

	private LocalDate datum;

	private String napomena;

	public TokStudija() {

	}

	public TokStudija(String napomena, LocalDate datum, StudIndex studIndex) {

		this.datum = datum;
		this.napomena = napomena;
		this.studIndex = studIndex;
	}

	public List<UpisGodine> getUpisGodine() {
		return upisGodine;
	}

	public void setUpisGodine(List<UpisGodine> upisGodine) {
		this.upisGodine = upisGodine;
	}

	public List<ObnovaGodine> getObnovaGodine() {
		return obnovaGodine;
	}

	public void setObnovaGodine(List<ObnovaGodine> obnovaGodine) {
		this.obnovaGodine = obnovaGodine;
	}

	public int getIdTokStudija() {
		return idTokStudija;
	}

	public void setIdTokStudija(int idTokStudija) {
		this.idTokStudija = idTokStudija;
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

	public StudIndex getStudIndex() {
		return studIndex;
	}

	public void setStudIndex(StudIndex studIndex) {
		this.studIndex = studIndex;
	}

}
