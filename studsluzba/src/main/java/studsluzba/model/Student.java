package studsluzba.model;

import java.io.Serializable;
import java.util.List;

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
	
	private long jmbg;
	
	private String datumRodj;
	
	private String mestoRodj;
	
	private String drzavaRodj;
	
	private String drzavljanstvo;
	
	private String nacionalnost;
	
	private String pol;
	
	private String emFax;
	
	private String emPers;
	
	private long brLK;
	
	private String adresa;
	
	private String izdavacLk;
	
	private long brTel;
	
	private int ukupanUspeh;
	
	//bi-directional many-to-one association to Studprogram
	@ManyToOne
	@JoinColumn(name="idstudProgram")
	private Studprogram studprogram;
	
	@ManyToOne
	@JoinColumn(name="idSkole")
	private SrednjaSkola srednjaSkola;
	
	@ManyToOne
	@JoinColumn(name="idVisokeSkole")
	private VisokaSkola visokaSkola;
	
	@OneToMany(mappedBy = "student")
	private List<StudIndex> indexs;

	public Student() {
	}

	
	
	public Student(int godinaUpisa, String ime, String prezime, Studprogram studprogram, String srednjeIme, long jmbg, String datumRodjenja, String mestoRodj, String drzavaRodj, String drzavljanstvo, String nacionalnost, 
			String pol, String emFax, String emPers, long brLk, String adresa, String izdavacLk, long brTel, SrednjaSkola srednjaSkola, int ukupanUspeh, List<StudIndex> indexs) {
		
		this.godinaUpisa = godinaUpisa;
		this.ime = ime;
		this.prezime = prezime;
		this.studprogram = studprogram;
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
		this.indexs = indexs;
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

	

	public SrednjaSkola getSrednjaSkola() {
		return srednjaSkola;
	}



	public void setSrednjaSkola(SrednjaSkola srednjaSkola) {
		this.srednjaSkola = srednjaSkola;
	}



	public long getJmbg() {
		return jmbg;
	}



	public void setJmbg(int jmbg) {
		this.jmbg = jmbg;
	}



	public String getDatumRodj() {
		return datumRodj;
	}



	public void setDatumRodj(String datumRodj) {
		this.datumRodj = datumRodj;
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



	public long getBrLK() {
		return brLK;
	}



	public void setBrLK(int brLK) {
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



	public long getBrTel() {
		return brTel;
	}



	public void setBrTel(int brTel) {
		this.brTel = brTel;
	}

	


	public int getUkupanUspeh() {
		return ukupanUspeh;
	}



	public void setUkupanUspeh(int ukupanUspeh) {
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
		return "Student [idstudent=" + idstudent + ", godinaUpisa=" + godinaUpisa + ", ime=" + ime + ", prezime="
				+ prezime + ", studprogram=" + studprogram + "]";
	}
	
	

}