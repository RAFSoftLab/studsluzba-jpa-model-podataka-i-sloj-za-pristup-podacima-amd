package studsluzba.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "Ispit.findAll", query = "SELECT i FROM Ispit i")
public class Ispit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIspit;
	
	private String datumOdrzavanja;
	private String vremePocetka;

	private Predmet predmet;
	
	@OneToOne(mappedBy = "idNastavnik")
	private Nastavnik nastavnik;

	private boolean zakljucen;
	
	@OneToOne(mappedBy = "idIspitniRok")
	private IspitniRok ispitniRok;

	public Ispit(String datumOdrzavanja, String vremePocetka, Predmet predmet, boolean zakljucen) {
		super();
		this.datumOdrzavanja = datumOdrzavanja;
		this.vremePocetka = vremePocetka;
		this.predmet = predmet;
		this.nastavnik = nastavnik;
		this.zakljucen = zakljucen;
	}
	
	public Ispit() {
		
	}

	public String getDatumOdrzavanja() {
		return datumOdrzavanja;
	}

	public void setDatumOdrzavanja(String datumOdrzavanja) {
		this.datumOdrzavanja = datumOdrzavanja;
	}

	public String getVremePocetka() {
		return vremePocetka;
	}

	public void setVremePocetka(String vremePocetka) {
		this.vremePocetka = vremePocetka;
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

	public boolean isZakljucen() {
		return zakljucen;
	}

	public void setZakljucen(boolean zakljucen) {
		this.zakljucen = zakljucen;
	}

}
