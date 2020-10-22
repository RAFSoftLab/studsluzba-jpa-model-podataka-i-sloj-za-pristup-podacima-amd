package studsluzba.model;

import java.io.Serializable;
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
	private Date godinaAkreditovanja;
	private int semestriTrajanje;
	
	@ManyToOne
	@JoinColumn(name = "idVrstaStudija")
	private VrstaStudija vrstaStudija;

	@OneToMany(mappedBy = "studProgram", fetch = FetchType.EAGER)
	private List<Predmet> predmeti;
	
	public Studprogram() {
	}
	
	public Studprogram(String naziv,String skraceniNaziv, String nazivZvanja, Date godinaAkreditovanja, int semestriTrajanje, VrstaStudija vrstaStudija) {

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
		getPredmeti().add(predmet);
		predmet.setStudProgram(this);

		return predmet;
	}

	public Predmet removePredmet(Predmet predmet) {
		getPredmeti().remove(predmet);
		predmet.setStudProgram(null);

		return predmet;
	}
	
	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public String getNazivZvanja() {
		return nazivZvanja;
	}

	public void setNazivZvanja(String nazivZvanja) {
		this.nazivZvanja = nazivZvanja;
	}

	public Date getGodinaAkreditovanja() {
		return godinaAkreditovanja;
	}

	public void setGodinaAkreditovanja(Date godinaAkreditovanja) {
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

	@Override
	public String toString() {
		return "Studprogram [idstudProgram=" + idstudProgram + ", naziv=" + naziv + ", skraceniNaziv=" + skraceniNaziv
				+ ", nazivZvanja=" + nazivZvanja + ", godinaAkreditovanja=" + godinaAkreditovanja
				+ ", semestriTrajanje=" + semestriTrajanje + ", vrstaStudija=" + vrstaStudija + ", predmeti=" + predmeti
				+ "]";
	}
	
	

}