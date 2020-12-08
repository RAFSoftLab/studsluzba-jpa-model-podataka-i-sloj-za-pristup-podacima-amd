package studsluzba.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="VrstaStudija.findAll", query="SELECT s FROM VrstaStudija s")
public class VrstaStudija implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVrsteStudija;
	
	private String punNaziv;
	
	private String skracenNaziv;
	
	public VrstaStudija() {
		
	}
	
	public VrstaStudija(String punNaziv, String skracenNaziv) {
		this.punNaziv = punNaziv;
		this.skracenNaziv = skracenNaziv;
	}

	public int getIdVrsteStudija() {
		return idVrsteStudija;
	}

	public void setIdVrsteStudija(int idVrsteStudija) {
		this.idVrsteStudija = idVrsteStudija;
	}

	public String getPunNaziv() {
		return punNaziv;
	}

	public void setPunNaziv(String punNaziv) {
		this.punNaziv = punNaziv;
	}

	public String getSkracenNaziv() {
		return skracenNaziv;
	}

	public void setSkracenNaziv(String skracenNaziv) {
		this.skracenNaziv = skracenNaziv;
	}

	@Override
	public String toString() {
		return skracenNaziv;
	}
	
}
