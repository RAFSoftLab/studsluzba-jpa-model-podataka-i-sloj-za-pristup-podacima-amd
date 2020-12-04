package studsluzba.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Student;
import studsluzba.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepo;

	public List<Student> findStudentByIndex(Integer index, String studProgram, Integer godina) {

		return studentRepo.findStudentbyIndex(index, studProgram, godina);
	}

	public List<Student> findStudentByName(String ime, String prezime) {

		return studentRepo.findStudentbyName(ime, prezime);
	}


	public Student saveStudent(String ime, String prezime, String srednjeIme, String jmbg, LocalDate datumRodj,
			String mestoRodj, String drzavaRodj, String pol, String drzavljanstvo, String nacionalnost, String brLK,
			String brTel, String izdavacLk, String adresa, String emFax, String emPers, int godinaUpisa) {
		
		Student s = new Student();
		s.setIme(ime);
		s.setPrezime(prezime);
		s.setSrednjeIme(srednjeIme);
		s.setJmbg(jmbg);
		s.setDatumRodj(datumRodj);
		s.setMestoRodj(mestoRodj);
		s.setDrzavaRodj(drzavaRodj);
		s.setPol(pol);
		s.setDrzavljanstvo(drzavljanstvo);
		s.setNacionalnost(nacionalnost);
		s.setBrLK(brLK);
		s.setBrTel(brTel);
		s.setIzdavacLk(izdavacLk);
		s.setAdresa(adresa);
		s.setEmFax(emFax);
		s.setEmPers(emPers);
		s.setGodinaUpisa(godinaUpisa);

		return studentRepo.save(s);
	}

}
