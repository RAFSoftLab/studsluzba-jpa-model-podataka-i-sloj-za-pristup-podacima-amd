package studsluzba.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "skolskagodina")
public class SkolskaGodina implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSkolskeGodine;
	
	private boolean aktivna;
	private String godina;
	
	@OneToMany
	private List<Nastavnik> nastavnici;
	
	@OneToMany
	private List<Predmet> predmeti;
	
	@OneToMany
	private List<Student> studenti;
	
	@OneToMany
	private List<IspitniRok> rokovi;
	
	public SkolskaGodina() {}

	public int getIdSkolskeGodine() {
		return idSkolskeGodine;
	}

	public void setIdSkolskeGodine(int idSkolskeGodine) {
		this.idSkolskeGodine = idSkolskeGodine;
	}

	public boolean isAktivna() {
		return aktivna;
	}

	public void setAktivna(boolean aktivna) {
		this.aktivna = aktivna;
	}

	public String getGodina() {
		return godina;
	}

	public void setGodina(String godina) {
		this.godina = godina;
	}

	public List<Nastavnik> getNastavnici() {
		return nastavnici;
	}

	public void setNastavnici(List<Nastavnik> nastavnici) {
		this.nastavnici = nastavnici;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public List<IspitniRok> getRokovi() {
		return rokovi;
	}

	public void setRokovi(List<IspitniRok> rokovi) {
		this.rokovi = rokovi;
	}
	
	
	
}
