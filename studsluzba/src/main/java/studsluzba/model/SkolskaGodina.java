package studsluzba.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "skolskagodina")
public class SkolskaGodina implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSkolskeGodine;

	private boolean aktivna;
	private String godina;

	@OneToMany(mappedBy = "sg")
	private List<DrziPredmet> drziPredmet;

	@OneToMany(mappedBy = "skolskaGodina")
	private List<IspitniRok> rokovi;

	public SkolskaGodina() {

	}
	
	public SkolskaGodina(String godina, boolean aktivna) {
		this.godina = godina;
		this.aktivna = aktivna;
	}

	public int getIdSkolskeGodine() {
		return idSkolskeGodine;
	}

	public void setIdSkolskeGodine(int idSkolskeGodine) {
		this.idSkolskeGodine = idSkolskeGodine;
	}

	public boolean isAktivna() {
		return aktivna;
	}

	public void setAktivna(boolean aktivna) {
		this.aktivna = aktivna;
	}

	public String getGodina() {
		return godina;
	}

	public void setGodina(String godina) {
		this.godina = godina;
	}

	public List<IspitniRok> getRokovi() {
		return rokovi;
	}

	public void setRokovi(List<IspitniRok> rokovi) {
		this.rokovi = rokovi;
	}

	public List<DrziPredmet> getDrziPredmet() {
		return drziPredmet;
	}

	public void setDrziPredmet(List<DrziPredmet> drziPredmet) {
		this.drziPredmet = drziPredmet;
	}

	
	@Override
	public String toString() {
		return this.godina + "";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null) {
			if (this.idSkolskeGodine == ((SkolskaGodina)obj).idSkolskeGodine)
				return true;			
		}
		return false;
	}
}
