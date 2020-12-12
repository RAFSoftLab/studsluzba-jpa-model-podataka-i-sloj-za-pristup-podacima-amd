package studsluzba.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Predmet;
import studsluzba.model.Studprogram;
import studsluzba.repositories.PredmetRepository;

@Service
public class PredmetService {

	@Autowired
	PredmetRepository predmetRepo;
	
	public List<Predmet> findAll() {
		Iterable<Predmet> iter = predmetRepo.findAll();
		List<Predmet> rez = new ArrayList<Predmet>();
		iter.forEach(rez::add);
		return rez;
	}
	
	public Predmet savePredmet(Predmet p) {
		return predmetRepo.save(p);
	}
	
	public void deletePredmet(Predmet p) {
		predmetRepo.delete(p);
	}
	
	public List<Predmet> findByNazivOrSifra(String s) {
		return predmetRepo.findByNazivOrSifra(s);
	}
	
	public Predmet findBySifra(String s) {
		return predmetRepo.findBySifra(s);
	}
}
