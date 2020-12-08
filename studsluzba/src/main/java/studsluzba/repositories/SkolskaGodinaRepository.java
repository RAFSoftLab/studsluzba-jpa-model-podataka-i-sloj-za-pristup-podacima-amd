package studsluzba.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.SkolskaGodina;
import studsluzba.model.Student;

public interface SkolskaGodinaRepository extends CrudRepository<SkolskaGodina, Integer> {
	

	@Query("select sg from SkolskaGodina sg where sg.id = :id")
	SkolskaGodina findSkolskaGodina(int id);
	
	@Query("select sg from SkolskaGodina sg where sg.aktivna = 1")
	SkolskaGodina getAktivna();

}
