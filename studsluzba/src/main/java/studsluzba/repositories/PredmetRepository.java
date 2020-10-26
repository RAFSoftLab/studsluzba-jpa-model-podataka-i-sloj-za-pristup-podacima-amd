package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Predmet;

public interface PredmetRepository extends CrudRepository<Predmet, Integer> {

	
	
	
}
