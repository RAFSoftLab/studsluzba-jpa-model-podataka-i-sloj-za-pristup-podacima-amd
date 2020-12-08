package studsluzba.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the studprogram database table.
 * 
 */
@Entity
@NamedQuery(name="Studprogram.findAll", query="SELECT s FROM Studprogram s")
public class Studprogram implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idstudProgram;
	
	private String naziv;
	private String skraceniNaziv;
	private String nazivZvanja;
	private Year godinaAkreditovanja;
	private int semestriTrajanje;
	
	@ManyToOne
	@JoinColumn(name = "idVrstaStudija")
	private VrstaStudija vrstaStudija;

	@ManyToMany(mappedBy = "studProgram")
	private List<PredmetStudprogram> predmetStudprogram;
	
	public Studprogram() {
	}
	
	public Studprogram(String naziv,String skraceniNaziv, String nazivZvanja, Year godinaAkreditovanja, int semestriTrajanje, VrstaStudija vrstaStudija) {

		this.naziv = naziv;
		this.skraceniNaziv = skraceniNaziv;
		this.nazivZvanja = nazivZvanja;
		this.godinaAkreditovanja = godinaAkreditovanja;
		this.semestriTrajanje = semestriTrajanje;
		this.vrstaStudija = vrstaStudija;
	}

	public int getIdstudProgram() {
		return this.idstudProgram;
	}

	public void setIdstudProgram(int idstudProgram) {
		this.idstudProgram = idstudProgram;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSkraceniNaziv() {
		return this.skraceniNaziv;
	}

	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}


	public Predmet addPredmet(Predmet predmet) {
		predmet.getPredmetStudprogram().add(new PredmetStudprogram(predmet, this));

		return predmet;
	}

	public Predmet removePredmet(Predmet predmet) {
		PredmetStudprogram temp = null;
		for (PredmetStudprogram psp : getPredmetStudprogram()) {
			if (psp.getPredmet().equals(predmet))
				temp = psp;
		}
		getPredmetStudprogram().remove(temp);
		
		return predmet;
	}

	public String getNazivZvanja() {
		return nazivZvanja;
	}

	public void setNazivZvanja(String nazivZvanja) {
		this.nazivZvanja = nazivZvanja;
	}

	public Year getGodinaAkreditovanja() {
		return godinaAkreditovanja;
	}

	public void setGodinaAkreditovanja(Year godinaAkreditovanja) {
		this.godinaAkreditovanja = godinaAkreditovanja;
	}

	public int getSemestriTrajanje() {
		return semestriTrajanje;
	}

	public void setSemestriTrajanje(int semestriTrajanje) {
		this.semestriTrajanje = semestriTrajanje;
	}

	public VrstaStudija getVrstaStudija() {
		return vrstaStudija;
	}

	public void setVrstaStudija(VrstaStudija vrstaStudija) {
		this.vrstaStudija = vrstaStudija;
	}
	
	public List<PredmetStudprogram> getPredmetStudprogram() {
		return predmetStudprogram;
	}

	public void setPredmetStudprogram(List<PredmetStudprogram> predmetStudprogram) {
		this.predmetStudprogram = predmetStudprogram;
	}

	@Override
	public String toString() {
		return skraceniNaziv +", " +godinaAkreditovanja;
	}
	
	

}