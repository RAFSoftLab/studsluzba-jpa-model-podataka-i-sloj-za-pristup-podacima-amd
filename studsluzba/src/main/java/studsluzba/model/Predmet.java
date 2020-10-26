package studsluzba.model;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.Table;

@Entity
@Table(name = "predmet")
@NamedQuery(name = "Predmet.findAll", query = "SELECT p FROM Predmet p")
public class Predmet implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPredmeta;
	private String sifra;
	private String naziv;
	private String opis;
	private int espb;
	private int semestar;
	private int fondCasovaPredavanja;
	private int fondCasovaVezbi;

	@OneToMany(mappedBy = "predmet", fetch = FetchType.EAGER)
	private List<DrziPredmet> drziPredmet;

	@ManyToOne
	@JoinColumn(name = "idstudProgram")
	private Studprogram studProgram;

	@OneToMany(mappedBy = "ponovljeniPredmeti")
	private List<ObnovaGodine> og;
	

	@OneToMany(mappedBy = "predmet")
	private List<PriznatPredmet> priznatPredmet;
	
	@OneToMany(mappedBy = "predmet")
	private List<PolozenPredmet> polozenPredmet;


	public Predmet() {
	}

	public int getIdPredmeta() {
		return idPredmeta;
	}

	public void setIdPredmeta(int idPredmeta) {
		this.idPredmeta = idPredmeta;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Studprogram getStudProgram() {
		return studProgram;
	}

	public void setStudProgram(Studprogram studProgram) {
		this.studProgram = studProgram;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public int getSemestar() {
		return semestar;
	}

	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}

	public int getFondCasovaPredavanja() {
		return fondCasovaPredavanja;
	}

	public void setFondCasovaPredavanja(int fondCasovaPredavanja) {
		this.fondCasovaPredavanja = fondCasovaPredavanja;
	}

	public int getFondCasovaVezbi() {
		return fondCasovaVezbi;
	}

	public void setFondCasovaVezbi(int fondCasovaVezbi) {
		this.fondCasovaVezbi = fondCasovaVezbi;
	}

	public List<DrziPredmet> getDrziPredmet() {
		return drziPredmet;
	}

	public void setDrziPredmet(List<DrziPredmet> drziPredmet) {
		this.drziPredmet = drziPredmet;
	}
	
	

	public List<PriznatPredmet> getPriznatPredmet() {
		return priznatPredmet;
	}

	public void setPriznatPredmet(List<PriznatPredmet> priznatPredmet) {
		this.priznatPredmet = priznatPredmet;
	}
	
	

	@Override
	public String toString() {
		return "Predmet [sifra=" + sifra + ", naziv=" + naziv + ", opis=" + opis + ", espb=" + espb + ", semestar="
				+ semestar + ", fondCasovaPredavanja=" + fondCasovaPredavanja + ", fondCasovaVezbi=" + fondCasovaVezbi
				+ "]";
	}

}
