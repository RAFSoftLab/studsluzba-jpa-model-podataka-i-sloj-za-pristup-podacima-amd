package studsluzba.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Ispit;
import studsluzba.model.Student;
import studsluzba.model.PrijavaIspita;
import studsluzba.model.IzlazakNaIspit;
import studsluzba.model.StudIndex;
import studsluzba.model.StudentPredispitneObaveze;

public interface IspitRepository extends CrudRepository<Ispit, Integer> {
	
	@Query("select s from Student s join StudIndex si on (s.idstudent = si.student.idstudent) join PrijavaIspita p on (si.idIndex = p.student.idIndex) where p.ispit= :i")
	List<Student> findPrijavljeni(Ispit i); 
	
	@Query("select avg(i.ocena) from IzlazakNaIspit i where i.ispit.idIspit = :idIspita")
	double findProsek(int idIspita);
	
	// kad je query sa value i nativequery onda se pristupa preko polja u tabeli
	// da proverim da li ovaj query daje ono sto bi trebalo da daje !!!!
	@Query( value = "select s.idIndex, (spo.poeni + i.brPoena) from StudIndex s"
			+ " join IzlazakNaIspit i on (i.idStudIndex = s.idIndex)"
			+ " join DrziPredmet dp on (s.idstudent = dp.idStudent)"
			+ " join StudentPredispitneObaveze spo on (spo.idDrziPremet = dp.idDrziPremet)"
			+ " where i.idIspit = :idIspita"
			+ " order by s.idstudProgram, s.godinaUpisa, s.broj", nativeQuery = true)
	List<Object[]> findRezultatiIspita(int idIspita);
	
//	@Query("select spo.poeni from StudentPredispitneObaveze spo"
//			+ " join DrziPredmet dp on (spo.drziPredmet.idDrziPremet = dp.idDrziPremet)"
//			+ " join StudIndex s on (dp.studIndex.idIndex = s.idIndex)"
//			+ " where dp.sg.idSkolskeGodine = :idSkolskeGodine and s.idIndex = :idIndex and dp.predmet.idPredmeta = :idPredmeta")
//	Double findPoeniStudentPredmet(int idIndex, int idPredmeta, int idSkolskeGodine);
//
	
	@Query("select si, s.ime, s.prezime, ini.brPoena + spo.poeni, ini.ocena from StudIndex si"
			+ " join Student s on(s = si.student)"
			+ " join StudentPredispitneObaveze spo on(si = spo.studIndex)"
			+ " join IzlazakNaIspit ini on (si = ini.studIndex)"
			+ " where ini.ispit = :ispit"
			+ " order by si.studProgram, si.godinaUpisa, si.broj")
	List<Object[]> findRezultatiIspitaPoIspitu(Ispit ispit);
	
}
