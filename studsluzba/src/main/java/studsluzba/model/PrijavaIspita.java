package studsluzba.model;

import java.time.LocalDate;
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
@NamedQuery(name = "PrijavaIspita.findAll", query = "SELECT p FROM PrijavaIspita p")
public class PrijavaIspita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPrijavaIpita;
	
	private LocalDate datumPrijave;

	@ManyToOne
	@JoinColumn(name = "idIspit")
	private Ispit ispit;

	@ManyToOne
	@JoinColumn(name = "idStudIndex")
	private StudIndex student;

	private boolean izlazak;

	public PrijavaIspita() {

	}

	public PrijavaIspita(LocalDate datumPrijave, Ispit ispit, StudIndex prijavljuje_student, boolean izlazak) {
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

	public LocalDate getDatumPrijave() {
		return datumPrijave;
	}

	public void setDatumPrijave(LocalDate datumPrijave) {
		this.datumPrijave = datumPrijave;
	}

	public Ispit getIspit() {
		return ispit;
	}

	public void setIspit(Ispit ispit) {
		this.ispit = ispit;
	}

	public StudIndex getStudent() {
		return student;
	}

	public void setStudent(StudIndex student) {
		this.student = student;
	}

	public boolean isIzlazak() {
		return izlazak;
	}

	public void setIzlazak(boolean izlazak) {
		this.izlazak = izlazak;
	}

}
