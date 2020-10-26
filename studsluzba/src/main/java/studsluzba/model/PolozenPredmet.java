package studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "PolozenPredmet.findAll", query = "SELECT po FROM PolozenPredmet po")
public class PolozenPredmet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPolozenogPredmet;

	@ManyToOne
	@JoinColumn(name = "idSudIndex")
	private StudIndex studIndex;

	@ManyToOne
	@JoinColumn(name = "idPredmet")
	private Predmet predmet;

	private boolean polozenNaIspitu;

	public PolozenPredmet() {

	}

	public PolozenPredmet(StudIndex studIndex, Predmet predmet, int ocena, boolean polozenNaIspitu) {

		this.studIndex = studIndex;
		this.predmet = predmet;
		this.polozenNaIspitu = polozenNaIspitu;
	}

	public int getIdPolozenogPredmet() {
		return idPolozenogPredmet;
	}

	public void setIdPolozenogPredmet(int idPolozenogPredmet) {
		this.idPolozenogPredmet = idPolozenogPredmet;
	}

	public boolean isPolozenNaIspitu() {
		return polozenNaIspitu;
	}

	public void setPolozenNaIspitu(boolean polozenNaIspitu) {
		this.polozenNaIspitu = polozenNaIspitu;
	}

	public StudIndex getStudIndex() {
		return studIndex;
	}

	public void setStudIndex(StudIndex studIndex) {
		this.studIndex = studIndex;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	@Override
	public String toString() {
		return "[" + predmet + "]";
	}

}
