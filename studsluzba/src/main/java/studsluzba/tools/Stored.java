package studsluzba.tools;

import java.util.ArrayList;
import java.util.Collection;
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
	private List<String> srednjeSkoleList;
	
	public void refreshAll() {
		smerSemestarList = sifarniciManager.getSmerSemestarData();
		drzavaList = sifarniciManager.getDrzavaData();
		srednjeSkoleList = sifarniciManager.getSrednjeSkoleData();
	}
	
	public SkolskaGodina getAktivnaSkolskaGodina() {
		return aktivna;
	}

	public void setAktivnaSkolskaGodina(SkolskaGodina a) {
		aktivna = a;
	}
	
	public List<SmerSemestar> getSmerSemestarList() {
		if (smerSemestarList == null) {
			smerSemestarList = sifarniciManager.getSmerSemestarData();
		}
		return smerSemestarList;
	}

	public List<DrzavaGradovi> getDrzavaList() {
		if (drzavaList == null) {
			drzavaList = sifarniciManager.getDrzavaData();
		}
		return drzavaList;
	}

	public void setDrzavaList(List<DrzavaGradovi> drzavaList) {
		this.drzavaList = drzavaList;
	}

	public List<String> getSrednjeSkoleList() {
		if (srednjeSkoleList == null) {
			srednjeSkoleList = sifarniciManager.getSrednjeSkoleData();
		}
		return srednjeSkoleList;
	}

	public void setSrednjeSkoleList(List<String> srednjeSkoleList) {
		this.srednjeSkoleList = srednjeSkoleList;
	}
	
	public List<String> getAllGradovi() {
		List<String> svi = new ArrayList<String>();
		for (DrzavaGradovi dg : drzavaList) {
			svi.addAll(List.of(dg.getGradovi()));
		}
		return svi;
	}
	
}
