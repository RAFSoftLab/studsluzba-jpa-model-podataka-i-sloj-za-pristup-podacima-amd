package studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "NastavnikZvanja.findAll", query = "SELECT nz FROM NastavnikZvanja nz")
public class NastavnikZvanja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNastavnikZvanja;
	
	@ManyToOne
    @JoinColumn(name = "idNastavnik")
    Nastavnik nastavnik;
 
    @ManyToOne
    @JoinColumn(name = "idZvanje")
    Zvanje zvanje;

	public NastavnikZvanja(Nastavnik nastavnik, Zvanje zvanje) {
		super();
		this.nastavnik = nastavnik;
		this.zvanje = zvanje;
	}
	
	public NastavnikZvanja() {
		
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Zvanje getZvanje() {
		return zvanje;
	}

	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}
	
    
    
}
