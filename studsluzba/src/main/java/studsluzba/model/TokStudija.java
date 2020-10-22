package studsluzba.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "TokStudija.findAll", query = "SELECT ts FROM TokStudija ts")
public class TokStudija implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTokStudija;
	
	@ManyToOne
	@JoinColumn(name = "idStudenta")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "idUpisaGodine")
	private UpisGodine upisGodine;

	@ManyToOne
	@JoinColumn(name = "idObnovaGodine")
	private ObnovaGodine obnovaGodine;
	
	private Date datum;
	
	private String napomena;

	public TokStudija() {

	}

	public TokStudija(Student student, UpisGodine upisGodine, ObnovaGodine obnovaGodine, String napomena, Date datum ) {

		this.student = student;
		this.upisGodine = upisGodine;
		this.obnovaGodine = obnovaGodine;
		this.datum = datum;
		this.napomena = napomena;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public UpisGodine getUpisGodine() {
		return upisGodine;
	}

	public void setUpisGodine(UpisGodine upisGodine) {
		this.upisGodine = upisGodine;
	}

	public ObnovaGodine getObnovaGodine() {
		return obnovaGodine;
	}

	public void setObnovaGodine(ObnovaGodine obnovaGodine) {
		this.obnovaGodine = obnovaGodine;
	}

	public int getIdTokStudija() {
		return idTokStudija;
	}

	public void setIdTokStudija(int idTokStudija) {
		this.idTokStudija = idTokStudija;
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
