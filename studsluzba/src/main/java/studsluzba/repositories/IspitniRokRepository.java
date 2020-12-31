package studsluzba.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.IspitniRok;
import studsluzba.model.SkolskaGodina;

public interface IspitniRokRepository extends CrudRepository<IspitniRok, Integer> {
	
	@Query("select ir.skolskaGodina from IspitniRok ir where ir = :ir")
	SkolskaGodina findSkolskaGodina(IspitniRok ir);

	@Query("select ir from IspitniRok ir where ir.skolskaGodina = :sg and lower(ir.mesec) like lower(:mesec)")
	IspitniRok findByParams(SkolskaGodina sg, String mesec);
	
}
