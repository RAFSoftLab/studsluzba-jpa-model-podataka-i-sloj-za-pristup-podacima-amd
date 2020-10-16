package studsluzba.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idstudent;

	private int godinaUpisa;

	private String ime;

	private String prezime;
	
	private String srednjeIme;

	//bi-directional many-to-one association to Studprogram
	@ManyToOne
	@JoinColumn(name="idstudProgram")
	private Studprogram studprogram;

	public Student() {
	}

	
	
	public Student(int godinaUpisa, String ime, String prezime, Studprogram studprogram) {
		super();
		this.godinaUpisa = godinaUpisa;
		this.ime = ime;
		this.prezime = prezime;
		this.studprogram = studprogram;
	}



	public int getIdstudent() {
		return this.idstudent;
	}

	public void setIdstudent(int idstudent) {
		this.idstudent = idstudent;
	}

	public int getGodinaUpisa() {
		return this.godinaUpisa;
	}

	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Studprogram getStudprogram() {
		return this.studprogram;
	}

	public void setStudprogram(Studprogram studprogram) {
		this.studprogram = studprogram;
	}

	

	public String getSrednjeIme() {
		return srednjeIme;
	}



	public void setSrednjeIme(String srednjeIme) {
		this.srednjeIme = srednjeIme;
	}



	@Override
	public String toString() {
		return "Student [idstudent=" + idstudent + ", godinaUpisa=" + godinaUpisa + ", ime=" + ime + ", prezime="
				+ prezime + ", studprogram=" + studprogram + "]";
	}
	
	

}