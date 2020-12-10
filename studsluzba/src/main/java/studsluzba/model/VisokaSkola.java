package studsluzba.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="VisokaSkola.findAll", query="SELECT s FROM VisokaSkola s")
public class VisokaSkola implements Serializable{
	
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVisokeSkole;
	
	private String imeUstanove;
	
	private String mestoUstanove;
	
	private String smer;
	
	@OneToMany(mappedBy = "visokaSkola")
	private List<Student> students;
	
	public VisokaSkola() {
		
	}
	
	public VisokaSkola(String imeUstanove, String mestoUstanove, String smer) {

		this.imeUstanove = imeUstanove;
		this.mestoUstanove = mestoUstanove;
		this.smer = smer;
	}

	public int getIdVisokeSkole() {
		return idVisokeSkole;
	}

	public void setIdVisokeSkole(int idVisokeSkole) {
		this.idVisokeSkole = idVisokeSkole;
	}

	public String getImeUstanove() {
		return imeUstanove;
	}

	public void setImeUstanove(String imeUstanove) {
		this.imeUstanove = imeUstanove;
	}

	public String getMestoUstanove() {
		return mestoUstanove;
	}

	public void setMestoUstanove(String mestoUstanove) {
		this.mestoUstanove = mestoUstanove;
	}

	public String getSmer() {
		return smer;
	}

	public void setSmer(String smer) {
		this.smer = smer;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setVisokaSkola(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setVisokaSkola(null);

		return student;
	}

	@Override
	public String toString() {
		return  imeUstanove + ", "
				+ mestoUstanove + ", " + smer;
	}
	
	
}
