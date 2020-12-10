package studsluzba.tools;

import java.util.List;

import studsluzba.model.SkolskaGodina;
import studsluzba.sifarnici.DrzavaGradovi;
import studsluzba.sifarnici.SifarniciManager;
import studsluzba.sifarnici.SmerSemestar;

public class Stored {
	
	private static Stored singleton = null;
	private SifarniciManager sifarniciManager;
	
	private Stored() {
		sifarniciManager = new SifarniciManager();
	}
	
	public static Stored getInstance() {
		if (singleton == null)
			singleton = new Stored();
		return singleton;
	}
	
	private SkolskaGodina aktivna;
	private List<SmerSemestar> smerSemestarList;
	private List<DrzavaGradovi> drzavaList;
	
	public SkolskaGodina getAktivnaSkolskaGodina() {
		return aktivna;
	}

	public void setAktivnaSkolskaGodina(SkolskaGodina a) {
		aktivna = a;
	}
	
	public List<SmerSemestar> getSmerSemestarList() {
		if (smerSemestarList == null || SifarniciManager.refreshFlag) {
			smerSemestarList = sifarniciManager.getSmerSemestarData();
			SifarniciManager.refreshFlag = false;
		}
		return smerSemestarList;
	}

	public List<DrzavaGradovi> getDrzavaList() {
		if (drzavaList == null || SifarniciManager.refreshFlag) {
			drzavaList = sifarniciManager.getDrzavaData();
			SifarniciManager.refreshFlag = false;			
		}
		return drzavaList;
	}

	public void setDrzavaList(List<DrzavaGradovi> drzavaList) {
		this.drzavaList = drzavaList;
	}
	
}
