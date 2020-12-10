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

	public StudIndex saveStudentIndex(LocalDate datum, int broj, Boolean aktivan, int godinaUpisa, Student student,
			Studprogram studProgram) {
		StudIndex si = new StudIndex();
		si.setDatumaktivnosti(datum);
		si.setBroj(broj);
		si.setAktivan(aktivan);
		si.setGodinaUpisa(godinaUpisa);
		si.setStudent(student);
		si.setStudProgram(studProgram);

		return studentIndexRepo.save(si);
	}

	public StudIndex getActiveIndexForStudent(Student s) {

		return studentIndexRepo.getActiveIndexForStud(s);
	}

	public void deleteIndexForStudent(StudIndex studIndexStari) {
		studentIndexRepo.delete(studIndexStari);

	}
}
