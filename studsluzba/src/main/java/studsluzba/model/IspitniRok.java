
package studsluzba.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "IspitniRok.findAll", query = "SELECT ir FROM IspitniRok ir")
public class IspitniRok implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIspitniRok;

	private String datumPocetka;
	private String datumZavrsetka;

	@OneToMany(mappedBy = "ispitniRok")
	private List<Ispit> ispiti;

	@ManyToOne
	private SkolskaGodina skolskaGodina;
	
	public IspitniRok() {

	}

	public IspitniRok(String datumPocetka, String datumZavrsetka, List<Ispit> ispiti) {
		super();
		this.datumPocetka = datumPocetka;
		this.datumZavrsetka = datumZavrsetka;
		this.ispiti = ispiti;
	}

	public String getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(String datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public String getDatumZavrsetka() {
		return datumZavrsetka;
	}

	public void setDatumZavrsetka(String datumZavrsetka) {
		this.datumZavrsetka = datumZavrsetka;
	}

	public List<Ispit> getIspiti() {
		return ispiti;
	}

	public void setIspiti(List<Ispit> ispiti) {
		this.ispiti = ispiti;
	}

}
