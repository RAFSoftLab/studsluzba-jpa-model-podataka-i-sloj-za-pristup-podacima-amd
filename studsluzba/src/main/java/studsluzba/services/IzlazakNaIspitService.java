package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.client.reports.entities.StudentPoeniOcena;
import studsluzba.model.Ispit;
import studsluzba.model.IzlazakNaIspit;
import studsluzba.model.StudIndex;
import studsluzba.repositories.IzlazakNaIspitrepository;

@Service
public class IzlazakNaIspitService {

	@Autowired
	IzlazakNaIspitrepository iniRepo;
	
	
	public int countIzlazciNaIspit(StudIndex si, Ispit i) {
		return iniRepo.findBrojIzlazakaNaIspit(si, i);
	}
	
	public StudentPoeniOcena findRezultati(StudIndex si, Ispit i) {
		return iniRepo.findRezultatiIspita(si, i);
	}
	
	public IzlazakNaIspit save(IzlazakNaIspit ini) {
		return iniRepo.save(ini);
	}
	
}
