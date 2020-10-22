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
	
	
	@ManyToOne
	@JoinColumn(name = "idNastavnik")
	private Nastavnik nastavnik;
	
	@ManyToOne
	@JoinColumn(name = "idPredmeta")
	private Predmet predmet;
	
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

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
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
