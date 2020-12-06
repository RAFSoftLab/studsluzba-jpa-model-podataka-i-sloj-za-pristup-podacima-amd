package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.DrziPredmet;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;

public interface DrziPredmetRepository  extends CrudRepository<DrziPredmet, Integer>{

	@Query("select dp from DrziPredmet dp where dp.nastavnik = :n")
	public List<DrziPredmet> findInfoByNastavnik(Nastavnik n);
	
	@Query("select dp.predmet from DrziPredmet dp where dp.nastavnik = :n")
	public List<Predmet> findPredmetByNastavnik(Nastavnik n);
	
}
