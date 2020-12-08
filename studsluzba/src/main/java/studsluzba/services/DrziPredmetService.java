package studsluzba.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.DrziPredmet;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.Studprogram;
import studsluzba.repositories.DrziPredmetRepository;

@Service
public class DrziPredmetService {
	
	@Autowired
	DrziPredmetRepository dpRepo;
	
	public DrziPredmet save(DrziPredmet dp) {
		return dpRepo.save(dp);
	}
	
	public List<Predmet> getPredmetiByNastavnik(Nastavnik n) {
		return dpRepo.findPredmetByNastavnik(n);
	}

	public List<DrziPredmet> findInfoByNastavnik(Nastavnik n) {
		return dpRepo.findInfoByNastavnik(n);
	}
	
	public List<DrziPredmet> findAll() {
		Iterable<DrziPredmet> iter = dpRepo.findAll();
		List<DrziPredmet> rez = new ArrayList<DrziPredmet>();
		iter.forEach(rez::add);
		return rez;
	}
	
	public List<DrziPredmet> findAllByStudProgram(Studprogram sp) {
		return dpRepo.findAllByStudProgram(sp);
	}
	
	public DrziPredmet findBySifraPredmeta(String sifra) {
		return dpRepo.findBySifraPredmeta(sifra);
	}
}
