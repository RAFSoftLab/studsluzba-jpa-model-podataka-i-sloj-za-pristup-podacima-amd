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
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "Ispit.findAll", query = "SELECT i FROM Ispit i")
public class Ispit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIspit;

	private LocalDate datumOdrzavanja;
	private String vremePocetka;
	private String vremeZavrsetka;

	@ManyToOne
	@JoinColumn(name = "idPredmeta")
	private Predmet predmet;

	@ManyToOne
	@JoinColumn(name = "idNastavnik")
	private Nastavnik nastavnik;

	private boolean zakljucen;

	@ManyToOne
	@JoinColumn(name = "idIspitniRok")
	private IspitniRok ispitniRok;

	@OneToMany(mappedBy = "ispit")
	private List<IzlazakNaIspit> izlazakNaIspit;

	public Ispit(LocalDate datumOdrzavanja2, String vremePocetka,String vremeZavrsetka, Nastavnik nastavnik, Predmet predmet, IspitniRok ispitniRok, boolean zakljucen) {

		this.datumOdrzavanja = datumOdrzavanja2;
		this.vremePocetka = vremePocetka;
		this.vremeZavrsetka = vremeZavrsetka;
		this.predmet = predmet;
		this.ispitniRok= ispitniRok;
		this.nastavnik = nastavnik;
		this.zakljucen = zakljucen;
	}

	public Ispit() {

	}

	public LocalDate getDatumOdrzavanja() {
		return datumOdrzavanja;
	}

	public void setDatumOdrzavanja(LocalDate datumOdrzavanja) {
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

	public int getIdIspit() {
		return idIspit;
	}

	public void setIdIspit(int idIspit) {
		this.idIspit = idIspit;
	}

	public IspitniRok getIspitniRok() {
		return ispitniRok;
	}

	public void setIspitniRok(IspitniRok ispitniRok) {
		this.ispitniRok = ispitniRok;
	}

	public String getVremeZavrsetka() {
		return vremeZavrsetka;
	}

	public void setVremeZavrsetka(String vremeZavrsetka) {
		this.vremeZavrsetka = vremeZavrsetka;
	}

	@Override
	public String toString() {
		return this.predmet.getNaziv();
	}

	

}
