package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.PredispitnaObaveza;
import studsluzba.model.Predmet;

public interface PredispitnaObavezaRepository extends CrudRepository<PredispitnaObaveza, Integer>{
	
	@Query("select po from PredispitnaObaveza po where po.idPredispitnaObaveza = :id")
	List<PredispitnaObaveza> findByPredispitnaObaveza(int id);
	
	@Query("select po from PredispitnaObaveza po where po.vrsta like :naziv and po.maxPoeni = :poeni")
	PredispitnaObaveza findByParams(String naziv, int poeni);
	
}
