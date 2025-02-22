package studsluzba.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="DrziPredmet.findAll", query="SELECT d FROM DrziPredmet d")
public class DrziPredmet {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDrziPremet;
	
	@ManyToOne
	@JoinColumn(name = "idSkolskeGodine")
	private SkolskaGodina sg;
	
	@ManyToOne
	@JoinColumn(name = "idPredmeta")
	private Predmet predmet;
	
	@ManyToOne
	@JoinColumn(name = "idNastavnika")
	private Nastavnik nastavnik;
	
	@ManyToMany(mappedBy = "drziPredmet")
	private List<TokStudijaDrziPredmet> tokStudijaDrziPredmet;

	public DrziPredmet() {
		
	}

	public DrziPredmet(SkolskaGodina sg, Predmet p, Nastavnik n) {
		this.nastavnik = n;
		this.sg = sg;
		this.predmet = p;
	}

	public int getIdDrziPremet() {
		return idDrziPremet;
	}

	public void setIdDrziPremet(int idDrziPremet) {
		this.idDrziPremet = idDrziPremet;
	}

	public SkolskaGodina getSg() {
		return sg;
	}

	public void setSg(SkolskaGodina sg) {
		this.sg = sg;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	
	@Override
	public boolean equals(Object obj) {
		DrziPredmet dp = (DrziPredmet) obj;
		if (this.nastavnik.equals(dp.nastavnik) && this.sg.equals(dp.sg) && this.predmet.equals(dp.predmet)) {
			return true;
		}
		return false;
	}
	
}
