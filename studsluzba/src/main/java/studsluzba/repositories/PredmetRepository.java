package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Predmet;

public interface PredmetRepository extends CrudRepository<Predmet, Integer> {

	@Query("select avg(ini.ocena) from Predmet p"
			+ " join Ispit i on (p.idPredmeta = i.predmet.idPredmeta)"
			+ " join IzlazakNaIspit ini on (ini.ispit.idIspit = i.idIspit)"
			+ " join IspitniRok ir on (ir.idIspitniRok = i.ispitniRok.idIspitniRok)"
			+ " join SkolskaGodina sg on (sg.idSkolskeGodine = ir.skolskaGodina.idSkolskeGodine)"
			+ " where (p.idPredmeta = :predmetId) and ((SUBSTRING_INDEX(sg.godina, '-', 1)+0) between :start and :end)")
	double findProsecnaOcenaURasponu(int predmetId, int start, int end);

}
