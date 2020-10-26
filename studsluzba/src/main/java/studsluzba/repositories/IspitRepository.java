package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Ispit;
import studsluzba.model.Student;
import studsluzba.model.PrijavaIspita;

public interface IspitRepository extends CrudRepository<Ispit, Integer> {
	
	// znaci mora da se pristupa preko polja u klasi a ne preko polja u tabeli
	@Query("select s from Student s join PrijavaIspita p on (s.idstudent = p.student.idstudent) where p.ispit.idIspit = :id")
	List<Student> findPrijavljeni(int id); // prosleis id ispita 
}
