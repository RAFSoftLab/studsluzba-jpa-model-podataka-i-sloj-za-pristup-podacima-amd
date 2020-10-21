package studsluzba.repositories;

import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Nastavnik;

public interface NastavnikRepository extends CrudRepository<Nastavnik, Integer>{
	
	// dodatne komande tipa query pod uslovima

}
