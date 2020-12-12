package studsluzba.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "StudIndex.findAll", query = "SELECT si FROM StudIndex si")
public class StudIndex implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIndex;

	private int godinaUpisa;

	private int broj;

	@OneToOne
	@JoinColumn(name = "idstudProgram")
	private Studprogram studProgram;

	private Boolean aktivan;

	private LocalDate datumaktivnosti;

	@ManyToOne
	@JoinColumn(name = "idstudent")
	private Student student;

	@OneToMany(mappedBy = "studIndex")
	private List<PolozenPredmet> polozenPredmet;

	@OneToMany(mappedBy = "studIndex")
	private List<TokStudija> tokStudija;

	@OneToMany(mappedBy = "studIndex")
	private List<IzlazakNaIspit> izlazakNaIspit;

	@OneToMany(mappedBy = "student")
	private List<PrijavaIspita> prijavaIspita;

	@OneToMany(mappedBy = "studIndex")
	private List<PriznatPredmet> priznatiPredmeti;
	
	@OneToMany(mappedBy = "studIndex")
	private List<StudentPredispitneObaveze> spo;

	public StudIndex() {

	}

	public StudIndex(int broj, int godinaUpisa) {
		super();
		this.broj = broj;
		this.godinaUpisa = godinaUpisa;
	}

	public StudIndex(int broj, int godinaUpisa, Studprogram studProgram,  Student student, Boolean aktivan, LocalDate datumaktivnosti) {
		super();
		this.godinaUpisa = godinaUpisa;
		this.broj = broj;
		this.studProgram = studProgram;
		this.aktivan = aktivan;
		this.datumaktivnosti = datumaktivnosti;
		this.student = student;
	}

	public StudIndex(int broj, int godinaUpisa, Studprogram studProgram, boolean aktivan) {
		super();
		this.broj = broj;
		this.godinaUpisa = godinaUpisa;
		this.studProgram = studProgram;
		this.aktivan = aktivan;
	}

	public int getIdIndex() {
		return idIndex;
	}

	public void setIdIndex(int idIndex) {
		this.idIndex = idIndex;
	}

	public int getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public Studprogram getStudProgram() {
		return studProgram;
	}

	public void setStudProgram(Studprogram studProgram) {
		this.studProgram = studProgram;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}

	public LocalDate getDatumaktivnosti() {
		return datumaktivnosti;
	}

	public void setDatumaktivnosti(LocalDate datum) {
		this.datumaktivnosti = datum;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<TokStudija> getTokStudija() {
		return tokStudija;
	}

	public void setTokStudija(List<TokStudija> tokStudija) {
		this.tokStudija = tokStudija;
	}

	@Override
	public String toString() {
		return broj + "/" + godinaUpisa + " " + studProgram.getSkraceniNaziv();
	}

	public List<IzlazakNaIspit> getIzlazakNaIspit() {
		return izlazakNaIspit;
	}

	public void setIzlazakNaIspit(List<IzlazakNaIspit> izlazakNaIspit) {
		this.izlazakNaIspit = izlazakNaIspit;
	}

	public List<PrijavaIspita> getPrijavaIspita() {
		return prijavaIspita;
	}

	public void setPrijavaIspita(List<PrijavaIspita> prijavaIspita) {
		this.prijavaIspita = prijavaIspita;
	}

	public List<PriznatPredmet> getPriznatiPredmeti() {
		return priznatiPredmeti;
	}

	public void setPriznatiPredmeti(List<PriznatPredmet> priznatiPredmeti) {
		this.priznatiPredmeti = priznatiPredmeti;
	}

}
