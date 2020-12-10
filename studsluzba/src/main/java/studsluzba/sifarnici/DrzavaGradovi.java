package studsluzba.sifarnici;

public class DrzavaGradovi {
	
	private String drzava;
	private String[] gradovi;

	
	public DrzavaGradovi(String drzava, String[] gradovi) {
		this.setDrzava(drzava);
		this.setGradovi(gradovi);
	}


	public String getDrzava() {
		return drzava;
	}


	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}


	public String[] getGradovi() {
		return gradovi;
	}


	public void setGradovi(String[] gradovi) {
		this.gradovi = gradovi;
	}
}
