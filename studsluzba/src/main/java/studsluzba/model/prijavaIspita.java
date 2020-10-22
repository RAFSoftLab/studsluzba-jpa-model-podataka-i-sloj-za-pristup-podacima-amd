package studsluzba.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.crypto.Data;

@Entity
@NamedQuery(name = "pijavaIpita.findAll", query = "SELECT i FROM prijavaIspita i")
public class prijavaIspita {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPrijavaIpita;
	private Date datumPrijave;
	
	@ManyToOne
	@JoinColumn(name = "idIspit")
	private Ispit ispit;
	
	@ManyToOne
	@JoinColumn(name = "idStudenta")
	private Student student;
	
	private boolean izlazak;
	
	public prijavaIspita() {
		
	}
	
	public prijavaIspita(Date datumPrijave, Ispit ispit, Student prijavljuje_student, boolean izlazak) {
		this.datumPrijave = datumPrijave;
		this.ispit = ispit;
		this.student = prijavljuje_student;
		this.izlazak = izlazak;
		
	}

	public int getIdPrijavaIpita() {
		return idPrijavaIpita;
	}

	public void setIdPrijavaIpita(int idPrijavaIpita) {
		this.idPrijavaIpita = idPrijavaIpita;
	}

	public Date getDatumPrijave() {
		return datumPrijave;
	}

	public void setDatumPrijave(Date datumPrijave) {
		this.datumPrijave = datumPrijave;
	}

	public Ispit getIspit() {
		return ispit;
	}

	public void setIspit(Ispit ispit) {
		this.ispit = ispit;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public boolean isIzlazak() {
		return izlazak;
	}

	public void setIzlazak(boolean izlazak) {
		this.izlazak = izlazak;
	}
	
	
}
