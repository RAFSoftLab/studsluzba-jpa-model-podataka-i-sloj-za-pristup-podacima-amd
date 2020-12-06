
package studsluzba.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.mysql.cj.x.protobuf.MysqlxCursor.Fetch;

@Entity
@NamedQuery(name = "IspitniRok.findAll", query = "SELECT ir FROM IspitniRok ir")
public class IspitniRok implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIspitniRok;

	private LocalDate datumPocetka;
	private LocalDate datumZavrsetka;

	@OneToMany(mappedBy = "ispitniRok" , fetch = FetchType.EAGER) 
	private List<Ispit> ispiti;

	@ManyToOne
	@JoinColumn(name = "idSkolskeGodine")
	private SkolskaGodina skolskaGodina;

	public IspitniRok() {

	}

	public IspitniRok(LocalDate datumPocetka, LocalDate datumZavrsetka, List<Ispit> ispiti, SkolskaGodina skolskaGodina) {
		super();
		this.datumPocetka = datumPocetka;
		this.datumZavrsetka = datumZavrsetka;
		this.ispiti = ispiti;
		this.skolskaGodina = skolskaGodina;
	}

	public LocalDate getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(LocalDate datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public LocalDate getDatumZavrsetka() {
		return datumZavrsetka;
	}

	public void setDatumZavrsetka(LocalDate datumZavrsetka) {
		this.datumZavrsetka = datumZavrsetka;
	}

	public List<Ispit> getIspiti() {
		return ispiti;
	}

	public void setIspiti(List<Ispit> ispiti) {
		this.ispiti = ispiti;
	}

	@Override
	public String toString() {
		return "IspitniRok [datumPocetka=" + datumPocetka + ", datumZavrsetka=" + datumZavrsetka + ", skolskaGodina=" + skolskaGodina + "]";
	}

}
