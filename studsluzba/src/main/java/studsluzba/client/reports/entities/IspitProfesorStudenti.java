package studsluzba.client.reports.entities;

public class IspitProfesorStudenti {
	
	private String skolskaGodina;
	private String predmet;
	private String imeIPrezimeNastavnika;
	private String imeIPrezimeStudenta;
	private String napomena;
	private String poeni;
	private String ispitniRok;
	private String brojIndeksa;
	private String brojPolaganja;
	private String ocena;
	private String sifraPredmeta;
	
	
	
	public IspitProfesorStudenti(String skolskaGodina, String predmet, String imeIPrezimeNastavnika,
			String imeIPrezimeStudenta, String napomena, String poeni, String ispitniRok, String brojIndeksa,
			String brojPolaganja, String ocena, String sifraPredmeta) {
		super();
		this.skolskaGodina = skolskaGodina;
		this.predmet = predmet;
		this.imeIPrezimeNastavnika = imeIPrezimeNastavnika;
		this.imeIPrezimeStudenta = imeIPrezimeStudenta;
		this.napomena = napomena;
		this.poeni = poeni;
		this.ispitniRok = ispitniRok;
		this.brojIndeksa = brojIndeksa;
		this.brojPolaganja = brojPolaganja;
		this.ocena = ocena;
		this.sifraPredmeta = sifraPredmeta;
	}
	public String getSkolskaGodina() {
		return skolskaGodina;
	}
	public void setSkolskaGodina(String skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}
	public String getPredmet() {
		return predmet;
	}
	public void setPredmet(String predmet) {
		this.predmet = predmet;
	}
	public String getImeIPrezimeNastavnika() {
		return imeIPrezimeNastavnika;
	}
	public void setImeIPrezimeNastavnika(String imeIPrezimeNastavnika) {
		this.imeIPrezimeNastavnika = imeIPrezimeNastavnika;
	}
	public String getImeIPrezimeStudenta() {
		return imeIPrezimeStudenta;
	}
	public void setImeIPrezimeStudenta(String imeIPrezimeStudenta) {
		this.imeIPrezimeStudenta = imeIPrezimeStudenta;
	}
	public String getNapomena() {
		return napomena;
	}
	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	public String getPoeni() {
		return poeni;
	}
	public void setPoeni(String poeni) {
		this.poeni = poeni;
	}
	public String getIspitniRok() {
		return ispitniRok;
	}
	public void setIspitniRok(String ispitniRok) {
		this.ispitniRok = ispitniRok;
	}
	public String getBrojIndeksa() {
		return brojIndeksa;
	}
	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}
	public String getBrojPolaganja() {
		return brojPolaganja;
	}
	public void setBrojPolaganja(String brojPolaganja) {
		this.brojPolaganja = brojPolaganja;
	}
	public String getOcena() {
		return ocena;
	}
	public void setOcena(String ocena) {
		this.ocena = ocena;
	}
	public String getSifraPredmeta() {
		return sifraPredmeta;
	}
	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}
	@Override
	public String toString() {
		return "IspitProfesorStudenti [skolskaGodina=" + skolskaGodina + ", predmet=" + predmet
				+ ", imeIPrezimeNastavnika=" + imeIPrezimeNastavnika + ", imeIPrezimeStudenta=" + imeIPrezimeStudenta
				+ ", napomena=" + napomena + ", poeni=" + poeni + ", ispitniRok=" + ispitniRok + ", brojIndeksa="
				+ brojIndeksa + ", brojPolaganja=" + brojPolaganja + ", ocena=" + ocena + ", sifraPredmeta="
				+ sifraPredmeta + "]";
	}
	
	
	
}
