package studsluzba.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.StudIndex;
import studsluzba.model.Student;
import studsluzba.model.Studprogram;
import studsluzba.repositories.StudIndexRepository;
import studsluzba.repositories.StudProgramRepository;
import studsluzba.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	StudIndexRepository studentIndeksRepository;
	
	@Autowired
	StudProgramRepository studProgramRepository;

	public List<Student> findStudentByIndex(Integer index, String studProgram, Integer godina) {

		return studentRepo.findStudentbyIndex(index, studProgram, godina);
	}

	public List<Student> findStudentByName(String ime, String prezime) {

		return studentRepo.findStudentbyName(ime, prezime);
	}

	public List<Student> findAll() { 
		Iterable<Student> iter = studentRepo.findAll();
		List<Student> rez = new ArrayList<Student>();
		iter.forEach(rez::add);
		return rez;
	}

	public Student saveStudent(Student s) {

		return studentRepo.save(s);
	}

	public void delete(Student s) {
		studentRepo.delete(s);
	}

	public StudIndex saveStudentAndIndex(String ime, String prezime, String studProgram, int broj, int godinaUpisa) {

		Student s = new Student(ime, prezime);
		s = studentRepo.save(s);
		Studprogram sp = studProgramRepository.getStudProgramBySkraceniNaziv(studProgram);
		StudIndex si = new StudIndex(broj, godinaUpisa, sp, true);
		si.setStudent(s);
		return studentIndeksRepository.save(si);

	}

	public StudIndex getStudentIndeks(String studProgram, int broj, int godinaUpisa) {
		List<StudIndex> indeksi = studentIndeksRepository.findByParams(studProgram, godinaUpisa, broj);
		if (indeksi.isEmpty())
			return null;
		return indeksi.get(0);
	}
}
