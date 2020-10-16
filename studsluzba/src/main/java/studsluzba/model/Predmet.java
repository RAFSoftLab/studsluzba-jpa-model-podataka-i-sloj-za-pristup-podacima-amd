package studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Predmet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPredmeta;
	
	private String sifra;
	
	private String naziv;
		
	@ManyToOne
	private Studprogram studProgram;
	

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
	
	
	
}
