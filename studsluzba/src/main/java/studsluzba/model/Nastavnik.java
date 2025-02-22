
package studsluzba.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "Nastavnik.findAll", query = "SELECT n FROM Nastavnik n")
public class Nastavnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNastavnik;

	private String ime;
	private String prezime;
	private String srednjeIme;
	private String email;
	private String obrazovanje;

	@ManyToMany(mappedBy = "nastavnik")
	private List<NastavnikZvanja> nastavnikZvanja;

	@OneToMany(mappedBy = "nastavnik")
	private List<DrziPredmet> drziPredmet;

//
//	@ManyToOne
//	private SkolskaGodina skolskaGodina;


	public Nastavnik() {

	}
	

	public Nastavnik(String ime, String prezime, String srednjeIme, String email, String obrazovanje) {

		this.ime = ime;
		this.prezime = prezime;
		this.srednjeIme = srednjeIme;
		this.email = email;
		this.obrazovanje = obrazovanje;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getSrednjeIme() {
		return srednjeIme;
	}

	public void setSrednjeIme(String srednjeIme) {
		this.srednjeIme = srednjeIme;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObrazovanje() {
		return obrazovanje;
	}

	public void setObrazovanje(String obrazovanje) {
		this.obrazovanje = obrazovanje;
	}

	public List<NastavnikZvanja> getNastavnikZvanja() {
		return nastavnikZvanja;
	}

	public void setNastavnikZvanja(List<NastavnikZvanja> nastavnikZvanja) {
		this.nastavnikZvanja = nastavnikZvanja;
	}

	public List<DrziPredmet> getDrziPredmet() {
		return drziPredmet;
	}

	public void setDrziPredmet(List<DrziPredmet> drziPredmet) {
		this.drziPredmet = drziPredmet;
	}

	
	public int getIdNastavnik() {
		return idNastavnik;
	}

	@Override
	public String toString() {
		return this.ime + " " + this.prezime;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null)
			return this.idNastavnik == ((Nastavnik)obj).idNastavnik;
		return false;
			
	}

}
