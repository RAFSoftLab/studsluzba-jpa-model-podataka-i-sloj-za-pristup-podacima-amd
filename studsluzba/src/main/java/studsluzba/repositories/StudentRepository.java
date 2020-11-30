package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.ObnovaGodine;
import studsluzba.model.PolozenPredmet;
import studsluzba.model.Student;
import studsluzba.model.UpisGodine;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	@Query("select s from Student s where " + "(:ime is null or lower(s.ime) like :ime) and"
			+ "(:prezime is null or lower(s.prezime) like :prezime)")
	List<Student> findStudentbyName(String ime, String prezime);

	// @Query("select s from Student s join StudIndex si on (s.idstudent =
	// si.student.idstudent and :index = si.broj)")
	@Query("select s from Student s where s.idstudent = (select si from StudIndex si where " + "(:index = si.broj and "
			+ ":studProgram like si.studProgram.skraceniNaziv and " + ":godina = si.godinaUpisa))")
	Student findStudentbyIndex(int index, String studProgram, int godina);

	@Query("select s from Student s where (s.srednjaSkola.imeSkole like :srednjaSkola and s.srednjaSkola.mesto like :mesto)")
	List<Student> selectAllStudFromHighSchool(String srednjaSkola, String mesto);

	@Query("select ug from UpisGodine ug where ug.tokStudija.studIndex.broj = :index and ug.tokStudija.studIndex.studProgram.skraceniNaziv like :studProgram and ug.tokStudija.studIndex.godinaUpisa = :godina")
	List<UpisGodine> selectAllEnrolledYearsForIndex(int index, String studProgram, int godina);
	
	@Query("select og from ObnovaGodine og where og.tokStudija.studIndex.broj = :index and og.tokStudija.studIndex.studProgram.skraceniNaziv like :studProgram and og.tokStudija.studIndex.godinaUpisa = :godina")
	List<ObnovaGodine> selectAllRenewYearsForIndex(int index, String studProgram, int godina);

	@Query("select po from PolozenPredmet po where po.studIndex.broj = :index and po.studIndex.studProgram.skraceniNaziv like :studProgram and po.studIndex.godinaUpisa = :godina ")
	List<PolozenPredmet> selectAllPassedSub(int index, String studProgram, int godina);
	
	@Query("select s from Student s join fetch s.indexs i where i.aktivan=true")
	List<Student> getStudentAktivanIndex();
	
	@Query("select s from Student s left join s.indexs i where i.studProgram.skraceniNaziv like :naziv ")
	List<Student> getStudenteiIndekse(String naziv);
	

}
