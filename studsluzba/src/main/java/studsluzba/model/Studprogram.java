package studsluzba.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the studprogram database table.
 * 
 */
@Entity
@NamedQuery(name="Studprogram.findAll", query="SELECT s FROM Studprogram s")
public class Studprogram implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idstudProgram;

	private String naziv;

	private String skraceniNaziv;
	

	//bi-directional many-to-one association to Student
	@OneToMany(mappedBy="studprogram")
	private List<Student> students;

	@OneToMany(mappedBy = "studProgram")
	private List<Predmet> predmeti;
	
	public Studprogram() {
	}

	public int getIdstudProgram() {
		return this.idstudProgram;
	}

	public void setIdstudProgram(int idstudProgram) {
		this.idstudProgram = idstudProgram;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSkraceniNaziv() {
		return this.skraceniNaziv;
	}

	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setStudprogram(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setStudprogram(null);

		return student;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	

}