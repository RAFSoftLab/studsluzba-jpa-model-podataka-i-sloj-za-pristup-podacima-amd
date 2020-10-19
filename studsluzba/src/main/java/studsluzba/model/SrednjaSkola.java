package studsluzba.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name="SrednjaSkola.findAll", query="SELECT s FROM SrednjaSkola s")
public class SrednjaSkola implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSkole;
	
	private String imeSkole;
	
	private String mesto;
	
	private String vrsta;
	
	@OneToMany(mappedBy = "srednjaSkola")
	private List<Student> students;
	
	public SrednjaSkola() {
		
	}
	
	public SrednjaSkola(String imeSkole, String mesto, String vrsta) {
			super();
			this.imeSkole = imeSkole;
			this.mesto = mesto;
			this.vrsta = vrsta;
	}

	public int getIdSkole() {
		return idSkole;
	}

	public void setIdSkole(int idSkole) {
		this.idSkole = idSkole;
	}

	public String getImeSkole() {
		return imeSkole;
	}

	public void setImeSkole(String imeSkole) {
		this.imeSkole = imeSkole;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getVrsta() {
		return vrsta;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setSrednjaSkola(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setSrednjaSkola(null);

		return student;
	}
	
}
