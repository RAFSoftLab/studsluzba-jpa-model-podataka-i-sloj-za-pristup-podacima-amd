package studsluzba.repositories;

import org.springframework.data.repository.CrudRepository;

import studsluzba.model.SrednjaSkola;
import studsluzba.model.Student;

public interface SrednjeSkoleRepository extends CrudRepository<SrednjaSkola, Integer>{

	
}
