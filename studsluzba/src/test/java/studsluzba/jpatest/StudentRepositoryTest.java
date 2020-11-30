package studsluzba.jpatest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.model.Studprogram;
import studsluzba.model.StudIndex;
import studsluzba.model.Student;
import studsluzba.repositories.StudIndexRepository;
import studsluzba.repositories.StudProgramRepository;
import studsluzba.repositories.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

	@Autowired
	StudentRepository studRepo;

	@Autowired
	StudProgramRepository studProgramRepo;

	@Autowired
	StudIndexRepository studIndeksRepo;

	@Test
	public void saveStudentTest() throws Exception {

		Studprogram sp = new Studprogram();
		sp.setNaziv("Racunarske nauke");
		sp.setSkraceniNaziv("RN");
		studProgramRepo.save(sp);

		Studprogram sp1 = new Studprogram();
		sp1.setNaziv("Racunarsko inzenjerstvo");
		sp1.setSkraceniNaziv("RI");
		studProgramRepo.save(sp1);

		Student s = new Student();
		s.setIme("Misa");
		s.setPrezime("Misic");
		s.setSrednjeIme("Marko");

		Student s1 = new Student();
		s1.setIme("Petar");
		s1.setPrezime("Petrovic");

		StudIndex si = new StudIndex(4, 2018, sp1, s, false, null);
		StudIndex si1 = new StudIndex(78, 2019, sp, s, true, null);
		StudIndex si2 = new StudIndex(35, 2014, sp, s, false, null);

		studRepo.save(s);
		studRepo.save(s1);

		studIndeksRepo.save(si);
		studIndeksRepo.save(si1);
		studIndeksRepo.save(si2);

		List<Student> studenti = studRepo.getStudentAktivanIndex();
		for (Student st : studenti) {
			System.out
					.println(st.getIme() + " " + st.getPrezime() + " broj aktivnih indeksa: " + st.getIndexs().size());
			if (st.getIndexs().size() > 0)
				System.out.println("Aktivan indeks = " + st.getIndexs().get(0));
		}

		System.out.println(
				"select s from Student s left join s.indeksi i where i.studProgram.skraceniNaziv like :naziv ");
		studenti = studRepo.getStudenteiIndekse("RN");
		for (Student st : studenti) {
			System.out.println(st.getIme() + " " + st.getPrezime());
		}

	}

	@Test
	public void findStudentTest() throws Exception {
		List<Student> studenti = studRepo.findStudentbyName("misa", null);
		// for(Student s:studenti)
		// System.out.println(s);
	}

}
