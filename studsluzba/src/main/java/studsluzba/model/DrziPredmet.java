package studsluzba.model;

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
@NamedQuery(name="DrziPredmet.findAll", query="SELECT d FROM DrziPredmet d")
public class DrziPredmet {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDrziPremet;
	
	@ManyToOne
	@JoinColumn(name = "idSkolskeGodine")
	private SkolskaGodina sg;
	
	@ManyToOne
	@JoinColumn(name = "idPredmeta")
	private Predmet predmet;
	
	@ManyToOne
	@JoinColumn(name = "idNastavnika")
	private Nastavnik nastavnik;
	
	@ManyToOne
	@JoinColumn(name = "idStudent")
	private Student student;
	
	@OneToMany(mappedBy = "drziPredmet")
	private List<StudentPredispitneObaveze> spo;
	
	public DrziPredmet( SkolskaGodina sg, Predmet predmet,  Nastavnik nastavnik, Student student) {
		this.nastavnik = nastavnik;
		this.predmet = predmet;
		this.sg = sg;
		this.student = student;
	}

	public int getIdDrziPremet() {
		return idDrziPremet;
	}

	public void setIdDrziPremet(int idDrziPremet) {
		this.idDrziPremet = idDrziPremet;
	}

	public SkolskaGodina getSg() {
		return sg;
	}

	public void setSg(SkolskaGodina sg) {
		this.sg = sg;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
}
