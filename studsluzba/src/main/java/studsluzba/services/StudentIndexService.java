package studsluzba.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.StudIndex;
import studsluzba.model.Student;
import studsluzba.model.Studprogram;
import studsluzba.repositories.StudIndexRepository;
import studsluzba.repositories.StudentRepository;

@Service
public class StudentIndexService {

	@Autowired
	StudIndexRepository studentIndexRepo;

	public StudIndex save(StudIndex si) {

		return studentIndexRepo.save(si);
	}

	public StudIndex getActiveIndexForStudent(Student s) {

		return studentIndexRepo.getActiveIndexForStud(s);
	}

	public void delete(StudIndex studIndexStari) {
		studentIndexRepo.delete(studIndexStari);

	}
	
	public List<StudIndex> findIndexByParams(int broj, int godina, Studprogram sp) {
		return studentIndexRepo.findByParams(sp, godina, broj);
	}
	
}
