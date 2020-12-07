package studsluzba.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "PredispitnaObaveza.findAll", query = "SELECT spo FROM PredispitnaObaveza spo")
public class PredispitnaObaveza implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPredispitnaObaveza;

	private String vrsta;
	private int maxPoeni;

	public PredispitnaObaveza() {
	}

	public PredispitnaObaveza(String vrsta, int maxPoeni) {
		this.vrsta = vrsta;
		this.maxPoeni = maxPoeni;
		
	}


	public String getVrsta() {
		return vrsta;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	public int getMaxPoeni() {
		return maxPoeni;
	}

	public void setMaxPoeni(int maxPoeni) {
		this.maxPoeni = maxPoeni;
	}

}
