package studsluzba.tools;

import java.util.ArrayList;
import java.util.List;

import studsluzba.model.StudIndex;

public class RezultatiClass {

	StudIndex si;
	String ime, prezime;
	double poeni;
	int ocena;
	
	public RezultatiClass(StudIndex si, String ime, String prezime, double poeni, int ocena) {
		this.si = si;
		this.ime = ime;
		this.prezime = prezime;
		this.poeni = poeni;
		this.ocena = ocena;
	}

	public StudIndex getSi() {
		return si;
	}

	public void setSi(StudIndex si) {
		this.si = si;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public double getPoeni() {
		return poeni;
	}

	public void setPoeni(double poeni) {
		this.poeni = poeni;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	
	
}
