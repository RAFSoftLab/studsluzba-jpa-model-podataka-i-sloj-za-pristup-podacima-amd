package studsluzba.client.reports.entities;

import studsluzba.model.StudIndex;

public class StudentPoeniOcena {
	
	private StudIndex si;
	private double poeni;
	private int ocena;
	private String napomena;
	
	public StudentPoeniOcena(StudIndex si, double poeni, int ocena, String napomena) {
		super();
		this.si = si;
		this.poeni = poeni;
		this.ocena = ocena;
		this.napomena = napomena;
	}
	
	
	public String getNapomena() {
		return napomena;
	}


	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}


	public StudIndex getSi() {
		return si;
	}
	public void setSi(StudIndex si) {
		this.si = si;
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
