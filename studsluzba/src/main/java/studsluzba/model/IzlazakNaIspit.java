package studsluzba.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "IzlazakNaIspit.findAll", query = "SELECT i FROM IzlazakNaIspit i")
public class IzlazakNaIspit implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIzlazakNaIspit;

	private double brPoena;

	private String napomena;

	private boolean ponistava;

	private int ocena;

	private boolean polozen;

	@ManyToOne
	@JoinColumn(name = "idIndex")
	private StudIndex studIndex;

	@ManyToOne
	@JoinColumn(name = "idIspit")
	private Ispit ispit;

	public IzlazakNaIspit() {

	}

	public IzlazakNaIspit(double brPoena, String napomena, boolean ponistava,boolean polozen, int ocena, 
			StudIndex studIndex, Ispit ispit) {

		this.brPoena = brPoena;
		this.napomena = napomena;
		this.ponistava = ponistava;
		this.ocena = ocena;
		this.studIndex = studIndex;
		this.ispit = ispit;
		this.polozen = polozen;

	}

	public int getIdIzlazakNaIspit() {
		return idIzlazakNaIspit;
	}

	public void setIdIzlazakNaIspit(int idIzlazakNaIspit) {
		this.idIzlazakNaIspit = idIzlazakNaIspit;
	}

	public double getBrPoena() {
		return brPoena;
	}

	public void setBrPoena(double brPoena) {
		this.brPoena = brPoena;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public boolean isPonistava() {
		return ponistava;
	}

	public void setPonistava(boolean ponistava) {
		this.ponistava = ponistava;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public boolean isPolozen() {
		return polozen;
	}

	public void setPolozen(boolean polozen) {
		this.polozen = polozen;
	}

	public StudIndex getStudIndex() {
		return studIndex;
	}

	public void setStudIndex(StudIndex studIndex) {
		this.studIndex = studIndex;
	}

	public Ispit getIspit() {
		return ispit;
	}

	public void setIspit(Ispit ispit) {
		this.ispit = ispit;
	}
		
	
}
