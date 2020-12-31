package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.client.reports.entities.StudentPoeniOcena;
import studsluzba.model.Ispit;
import studsluzba.model.IzlazakNaIspit;
import studsluzba.model.StudIndex;

public interface IzlazakNaIspitrepository extends CrudRepository<IzlazakNaIspit, Integer>{

	@Query("select count(ini) from IzlazakNaIspit ini where ini.ispit = :i and ini.studIndex = :si")
	Integer findBrojIzlazakaNaIspit(StudIndex si, Ispit i);
	
	@Query("select new studsluzba.client.reports.entities.StudentPoeniOcena(ini.studIndex, ini.brPoena, ini.ocena, ini.napomena) from IzlazakNaIspit ini"
			+ " where ini.ispit = :i and ini.studIndex = :si")
	StudentPoeniOcena findRezultatiIspita(StudIndex si, Ispit i); 
	
}
