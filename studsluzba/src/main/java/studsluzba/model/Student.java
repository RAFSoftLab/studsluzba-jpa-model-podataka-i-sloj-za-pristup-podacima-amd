package studsluzba.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Any;

/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idstudent;
	private String ime;
	private String prezime;
	private String srednjeIme;
	private String jmbg;
	private LocalDate datumRodj;
	private String mestoRodj;
	private String drzavaRodj;
	private String drzavljanstvo;
	private String nacionalnost;
	private String pol;
	private String emFax;
	private String emPers;
	private String brLK;
	private String adresa;
	private String izdavacLk;
	private String brTel;
	private float ukupanUspeh;

	@ManyToOne
	@JoinColumn(name = "idSkole")
	private SrednjaSkola srednjaSkola;

	@ManyToOne
	@JoinColumn(name = "idVisokeSkole")
	private VisokaSkola visokaSkola;

	@OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
	private List<StudIndex> indexs;

	public Student() {
	}

	public Student(String ime, String prezime, String srednjeIme, String jmbg, LocalDate datumRodjenja,
			String mestoRodj, String drzavaRodj, String drzavljanstvo, String nacionalnost, String pol, String emFax,
			String emPers, String brLk, String adresa, String izdavacLk, String brTel, SrednjaSkola srednjaSkola,
			float ukupanUspeh) {

		this.ime = ime;
		this.prezime = prezime;
		this.srednjeIme = srednjeIme;
		this.jmbg = jmbg;
		this.datumRodj = datumRodjenja;
		this.mestoRodj = mestoRodj;
		this.drzavaRodj = drzavaRodj;
		this.drzavljanstvo = drzavljanstvo;
		this.nacionalnost = nacionalnost;
		this.pol = pol;
		this.emFax = emFax;
		this.emPers = emPers;
		this.brLK = brLk;
		this.adresa = adresa;
		this.izdavacLk = izdavacLk;
		this.brTel = brTel;
		this.srednjaSkola = srednjaSkola;
		this.ukupanUspeh = ukupanUspeh;
	}

	public int getIdstudent() {
		return this.idstudent;
	}

	public void setIdstudent(int idstudent) {
		this.idstudent = idstudent;
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

	public String getSrednjeIme() {
		return srednjeIme;
	}

	public void setSrednjeIme(String srednjeIme) {
		this.srednjeIme = srednjeIme;
	}

	public SrednjaSkola getSrednjaSkola() {
		return srednjaSkola;
	}

	public void setSrednjaSkola(SrednjaSkola srednjaSkola2) {
		this.srednjaSkola = srednjaSkola2;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public LocalDate getDatumRodj() {
		return datumRodj;
	}

	public void setDatumRodj(LocalDate datumRodj2) {
		this.datumRodj = datumRodj2;
	}

	public String getMestoRodj() {
		return mestoRodj;
	}

	public void setMestoRodj(String mestoRodj) {
		this.mestoRodj = mestoRodj;
	}

	public String getDrzavaRodj() {
		return drzavaRodj;
	}

	public void setDrzavaRodj(String drzavaRodj) {
		this.drzavaRodj = drzavaRodj;
	}

	public String getDrzavljanstvo() {
		return drzavljanstvo;
	}

	public void setDrzavljanstvo(String drzavljanstvo) {
		this.drzavljanstvo = drzavljanstvo;
	}

	public String getNacionalnost() {
		return nacionalnost;
	}

	public void setNacionalnost(String nacionalnost) {
		this.nacionalnost = nacionalnost;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getEmFax() {
		return emFax;
	}

	public void setEmFax(String emFax) {
		this.emFax = emFax;
	}

	public String getEmPers() {
		return emPers;
	}

	public void setEmPers(String emPers) {
		this.emPers = emPers;
	}

	public String getBrLK() {
		return brLK;
	}

	public void setBrLK(String brLK) {
		this.brLK = brLK;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getIzdavacLk() {
		return izdavacLk;
	}

	public void setIzdavacLk(String izdavacLk) {
		this.izdavacLk = izdavacLk;
	}

	public String getBrTel() {
		return brTel;
	}

	public void setBrTel(String brTel) {
		this.brTel = brTel;
	}

	public float getUkupanUspeh() {
		return ukupanUspeh;
	}

	public void setUkupanUspeh(float ukupanUspeh) {
		this.ukupanUspeh = ukupanUspeh;
	}

	public VisokaSkola getVisokaSkola() {
		return visokaSkola;
	}

	public void setVisokaSkola(VisokaSkola visokaSkola) {
		this.visokaSkola = visokaSkola;
	}

	public List<StudIndex> getIndexs() {
		return indexs;
	}

	public void setIndexs(List<StudIndex> indexs) {
		this.indexs = indexs;
	}

	@Override
	public String toString() {
		StudIndex aktivan = null;
		for (StudIndex si : indexs) {
			if (si.getAktivan())
				aktivan = si;
		}
		return ime + " " + prezime + " " + aktivan;
	}

}