package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.DrziPredmet;

public interface DrziPredmetRepository  extends CrudRepository<DrziPredmet, Integer>{

	@Query("select dp from DrziPredmet dp where dp.nastavnik.idNastavnik = :id")
	public List<DrziPredmet> findInfoByNastavnik(Integer id);
	
	
}
