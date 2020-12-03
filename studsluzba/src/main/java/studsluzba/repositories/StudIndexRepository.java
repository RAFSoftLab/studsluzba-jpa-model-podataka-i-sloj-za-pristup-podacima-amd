package studsluzba.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.StudIndex;

public interface StudIndexRepository extends CrudRepository<StudIndex, Integer>{
	
	@Query("select si from StudIndex si where idStudent = (select s from Student s where " + "(:ime is null or lower(s.ime) like :ime) and"
			+ "(:prezime is null or lower(s.prezime) like :prezime) and (:jmbg is null or lower(s.jmbg) like :jmbg)) and si.aktivan=1")
	StudIndex getActiveIndexForStud(String ime, String prezime, String jmbg);
/*
	@Query("update StudIndex si set aktivan=0 where si.idstudent = (select s from Student s where (:ime is null or lower(s.ime) like :ime) or "
			+ "(:prezime is null or lower(s.prezime) like :prezime))")
	StudIndex updateStudentIndex(String ime, String prezime);
*/
}
