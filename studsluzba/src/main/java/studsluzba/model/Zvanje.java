package studsluzba.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
@NamedQuery(name = "Zvanje.findAll", query = "SELECT z FROM Zvanje z")
public class Zvanje implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idZvanje;

	private LocalDate datumIzbora;
	private String uzaNaucnaOblast;
	private String naziv;
	
	@ManyToMany(mappedBy = "zvanje")
	private List<NastavnikZvanja> nastavnikZvanja;

	public List<NastavnikZvanja> getNastavnikZvanja() {
		return nastavnikZvanja;
	}

	public void setNastavnikZvanja(List<NastavnikZvanja> nastavnikZvanja) {
		this.nastavnikZvanja = nastavnikZvanja;
	}

	public Zvanje() {

	}

	public Zvanje(LocalDate datumIzbora, String uzaNaucnaOblast, String naziv) {

		this.datumIzbora = datumIzbora;
		this.uzaNaucnaOblast = uzaNaucnaOblast;
		this.naziv = naziv;
	}

	public LocalDate getDatumIzbora() {
		return datumIzbora;
	}

	public void setDatumIzbora(LocalDate localDate) {
		this.datumIzbora = localDate;
	}

	public String getUzaNaucnaOblast() {
		return uzaNaucnaOblast;
	}

	public void setUzaNaucnaOblast(String uzaNaucnaOblast) {
		this.uzaNaucnaOblast = uzaNaucnaOblast;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	@Override
	public String toString() {
		return naziv;
	}

}
