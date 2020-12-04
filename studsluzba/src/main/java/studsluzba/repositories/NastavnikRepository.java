package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Nastavnik;

public interface NastavnikRepository extends CrudRepository<Nastavnik, Integer>{
	
	@Query("select n from Nastavnik n where" +
			" (:ime like '' or lower(n.ime) like lower(:ime)) and" +
			" (:prezime like '' or lower(n.prezime) like lower(:prezime)) and" +
			" (:srednje like '' or lower(n.srednjeIme) like lower(:srednje)) and" +
			" (:obrazovanje like '' or lower(n.obrazovanje) like lower(:obrazovanje)) and" +
			" (:email like '' or lower(n.email) like lower(:email))")
	public List<Nastavnik> findAllByParams(String ime, String prezime, String srednje, String obrazovanje, String email);

}
