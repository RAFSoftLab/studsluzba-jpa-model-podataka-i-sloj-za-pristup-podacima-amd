package studsluzba.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name="StudIndex.findAll", query="SELECT s FROM StudIndex s")
public class StudIndex implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIndex;
	
	private int godinaUpisa;
	
	private int broj;
	
	@OneToOne
	@JoinColumn(name="idstudProgram")
	private Studprogram studProgram;
	
	private Boolean aktivan;
	
	private String datumaktivnosti;
	
	public StudIndex() {
		
	}
	
	public StudIndex(int godinaUpisa, int broj, Studprogram studProgram, Boolean aktivan, String datumaktivnosti) {
		super();
		this.godinaUpisa = godinaUpisa;
		this.broj = broj;
		this.studProgram = studProgram;
		this.aktivan = aktivan;
		this.datumaktivnosti = datumaktivnosti;
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

	public String getDatumaktivnosti() {
		return datumaktivnosti;
	}

	public void setDatumaktivnosti(String datumaktivnosti) {
		this.datumaktivnosti = datumaktivnosti;
	}

}
