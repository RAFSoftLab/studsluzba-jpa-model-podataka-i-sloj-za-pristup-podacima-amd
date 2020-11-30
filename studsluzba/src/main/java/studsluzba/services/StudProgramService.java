package studsluzba.services;

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

}
