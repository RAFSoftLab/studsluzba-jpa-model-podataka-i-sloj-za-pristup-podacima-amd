package studsluzba.sifarnici;

public class SmerSemestar{

	private String smer;
	private String semestar;
	private String[] predmeti;
	
	public SmerSemestar(String smer, String semestar, String[] predmeti) {
		this.smer = smer;
		this.semestar = semestar;
		this.predmeti = predmeti;
	}

	public String getSmer() {
		return smer;
	}

	public String getSemestar() {
		return semestar;
	}

	public String[] getPredmeti() {
		return predmeti;
	}
	
	@Override
	public String toString() {
		return smer + " " + semestar;
	}
	
}
