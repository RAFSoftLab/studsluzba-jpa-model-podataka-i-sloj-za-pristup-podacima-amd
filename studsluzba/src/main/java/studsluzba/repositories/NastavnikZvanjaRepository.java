package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.NastavnikZvanja;
import studsluzba.model.Zvanje;

public interface NastavnikZvanjaRepository extends CrudRepository<NastavnikZvanja, Integer> {

	@Query("select nz.zvanje from NastavnikZvanja nz where nz.nastavnik.idNastavnik = :id")
	public List<Zvanje> findZvanjeByNastavnik(Integer id);
	
}
