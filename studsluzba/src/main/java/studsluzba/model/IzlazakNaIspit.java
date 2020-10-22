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
@NamedQuery(name = "IzlazakNaIspit.findAll", query = "SELECT i FROM IzlazakNaIspit i")
public class IzlazakNaIspit implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIzlazakNaIspit;
	
	private int brPoena;
	
	private String napomena;
	
	private boolean ponistava;
	
	private double ocena;
	
	private boolean polozen;
	
	private boolean priznatVS;
	
	@ManyToOne
	@JoinColumn(name = "idStudent")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "idIspit")
	private Ispit ispit;
	
	public IzlazakNaIspit() {
		
	}
	
	public IzlazakNaIspit(int brPoena, String napomena, boolean ponistava, double ocena, boolean polozen, Student student, Ispit ispit) {
		
		this.brPoena = brPoena;
		this.napomena = napomena;
		this.ponistava = ponistava;
		this.ocena = ocena;
		this.polozen = polozen;
		this.student = student;
		this.ispit = ispit;
		
	}

	public int getIdIzlazakNaIspit() {
		return idIzlazakNaIspit;
	}

	public void setIdIzlazakNaIspit(int idIzlazakNaIspit) {
		this.idIzlazakNaIspit = idIzlazakNaIspit;
	}

	public int getBrPoena() {
		return brPoena;
	}

	public void setBrPoena(int brPoena) {
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

	public double getOcena() {
		return ocena;
	}

	public void setOcena(double ocena) {
		this.ocena = ocena;
	}

	public boolean isPolozen() {
		return polozen;
	}

	public void setPolozen(boolean polozen) {
		this.polozen = polozen;
	}

	public boolean isPriznatVS() {
		return priznatVS;
	}

	public void setPriznatVS(boolean priznatVS) {
		this.priznatVS = priznatVS;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Ispit getIspit() {
		return ispit;
	}

	public void setIspit(Ispit ispit) {
		this.ispit = ispit;
	}
	
	
	
}
