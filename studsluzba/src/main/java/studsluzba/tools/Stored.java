package studsluzba.tools;

import java.util.List;

import studsluzba.model.SkolskaGodina;
import studsluzba.sifarnici.SmerSemestar;
import studsluzba.sifarnici.SmerSemestarLoader;

public class Stored {
	
	private static Stored singleton = null;
	
	private Stored() {
		// sifarnici init itd
		smerSemestarList = SmerSemestarLoader.getEntitites();
	}
	
	public static Stored getInstance() {
		if (singleton == null)
			singleton = new Stored();
		return singleton;
	}
	

	private SkolskaGodina aktivna;
	private List<SmerSemestar> smerSemestarList;
	
	public SkolskaGodina getAktivnaSkolskaGodina() {
		return aktivna;
	}

	public void setAktivnaSkolskaGodina(SkolskaGodina a) {
		aktivna = a;
	}
	
	public List<SmerSemestar> getSmerSemestarList() {
		return smerSemestarList;
	}
	
}
