package studsluzba.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.DrziPredmet;
import studsluzba.model.Nastavnik;
import studsluzba.model.NastavnikZvanja;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.SrednjaSkola;
import studsluzba.model.Zvanje;
import studsluzba.repositories.DrziPredmetRepository;
import studsluzba.repositories.NastavnikRepository;
import studsluzba.repositories.NastavnikZvanjaRepository;
import studsluzba.repositories.ZvanjeRepository;

@Service
public class NastavnikService {
	
	@Autowired
	NastavnikRepository nastavnikRepo;
	@Autowired
	NastavnikZvanjaRepository nzRepo;
	@Autowired
	ZvanjeRepository zvanjeRepo;
	@Autowired
	DrziPredmetRepository dpRepo;
	
	public Nastavnik saveNastavnik(Nastavnik n) {
		return nastavnikRepo.save(n);
	}
	
	public NastavnikZvanja saveNastavnikZvanja(NastavnikZvanja nz) {
		return nzRepo.save(nz);
	}
	
	public void deleteNastavnikZvanja(NastavnikZvanja nz) {
		nzRepo.delete(nz);
	}
	
	public List<Nastavnik> findAll() {
		Iterable<Nastavnik> iter = nastavnikRepo.findAll();
		List<Nastavnik> rez = new ArrayList<Nastavnik>();
		iter.forEach(rez::add);
		return rez;
	}
	
	public List<Nastavnik> findNastavnici(String ime, String prezime, String srednje, String obrazovanje, String email) {
		return nastavnikRepo.findAllByParams(ime, prezime, srednje, obrazovanje, email);
	}
	
	public List<Zvanje> findZvanjaByNastavnik(Nastavnik n) {
		Integer i = n.getIdNastavnik();
		return nzRepo.findZvanjeByNastavnik(i);
	}
	
	public List<DrziPredmet> findInfoByNastavnik(Nastavnik n) {
		Integer i = n.getIdNastavnik();
		return dpRepo.findInfoByNastavnik(i);
	}
	
}
