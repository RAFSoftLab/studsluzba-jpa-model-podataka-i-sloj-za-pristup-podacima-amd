package studsluzba.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Zvanje.findAll", query = "SELECT z FROM Zvanje z")
public class Zvanje implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idZvanje;

	private Date datumIzbora;
	private String uzaNaucnaOblast;
	private String naziv;

	public Zvanje() {

	}

	public Zvanje(Date datumIzbora, String uzaNaucnaOblast, String naziv) {

		this.datumIzbora = datumIzbora;
		this.uzaNaucnaOblast = uzaNaucnaOblast;
		this.naziv = naziv;
	}

	public Date getDatumIzbora() {
		return datumIzbora;
	}

	public void setDatumIzbora(Date datumIzbora) {
		this.datumIzbora = datumIzbora;
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

}
