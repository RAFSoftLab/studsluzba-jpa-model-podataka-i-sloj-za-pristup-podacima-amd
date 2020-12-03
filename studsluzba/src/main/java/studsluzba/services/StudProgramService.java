package studsluzba.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import studsluzba.model.Studprogram;
import studsluzba.repositories.StudProgramRepository;

@Service
public class StudProgramService {

	@Autowired
	StudProgramRepository studProgramRepo;

	public Studprogram saveStudProgram(String punNaziv, String skraceniNaziv) {
		Studprogram sp = new Studprogram();
		sp.setNaziv(punNaziv);
		sp.setSkraceniNaziv(skraceniNaziv);
		return studProgramRepo.save(sp);
	}

	public List<Studprogram> getAllPrograms() {

		Iterable<Studprogram> iter = studProgramRepo.findAll();
		List<Studprogram> rez = new ArrayList<Studprogram>();
		iter.forEach(rez::add);
		return rez;

	}

}
