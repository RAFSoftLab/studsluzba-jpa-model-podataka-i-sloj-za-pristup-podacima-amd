package studsluzba.sifarnici;

import java.util.List;

public class SmerSemestar {

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

	public void setSmer(String smer) {
		this.smer = smer;
	}

	public String getSemestar() {
		return semestar;
	}

	public void setSemestar(String semestar) {
		this.semestar = semestar;
	}

	public String[] getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(String[] predmeti) {
		this.predmeti = predmeti;
	}
	
	@Override
	public String toString() {
		return smer + " " + semestar;
	}
	
}
