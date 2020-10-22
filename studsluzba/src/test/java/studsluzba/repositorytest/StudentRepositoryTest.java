package studsluzba.repositorytest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.model.IzlazakNaIspit;
import studsluzba.model.ObnovaGodine;
import studsluzba.model.Predmet;
import studsluzba.model.SrednjaSkola;
import studsluzba.model.StudIndex;
import studsluzba.model.Student;
import studsluzba.model.Studprogram;
import studsluzba.model.TokStudija;
import studsluzba.model.UpisGodine;
import studsluzba.model.VisokaSkola;
import studsluzba.model.VrstaStudija;
import studsluzba.model.prijavaIspita;
import studsluzba.repositories.IzlazakNaIspitrepository;
import studsluzba.repositories.ObnovaGodineRepository;
import studsluzba.repositories.PredmetRepository;
import studsluzba.repositories.PrijavaIspitarepository;
import studsluzba.repositories.SrednjeSkoleRepository;
import studsluzba.repositories.StudIndexRepository;
import studsluzba.repositories.StudProgramRepository;
import studsluzba.repositories.StudentRepository;
import studsluzba.repositories.TokStudijaRepository;
import studsluzba.repositories.UpisGodineRepository;
import studsluzba.repositories.VisokaSkolaRepository;
import studsluzba.repositories.VrstaStudijaRepository;





@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
	
	@Autowired 
	PredmetRepository predmetRepo;
	
	@Autowired //spring pravi sam instancu repositorija -------------------------
	StudentRepository studentRepo;
	
	@Autowired
	StudIndexRepository studIndex;
	
	@Autowired //spring pravi sam instancu repositorija -------------------------
	VisokaSkolaRepository visokaRepo;
	
	@Autowired //spring pravi sam instancu repositorija -------------------------
	SrednjeSkoleRepository srednjeRepo;

	@Autowired
	VrstaStudijaRepository vrstaRepo;
	
	@Autowired
	StudProgramRepository studProgramRepo;
	
	@Autowired
	PrijavaIspitarepository prijavaRepo;
	
	@Autowired
	IzlazakNaIspitrepository izlazakRepo;
	
	@Autowired
	ObnovaGodineRepository obnovaRepo;
	
	@Autowired
	UpisGodineRepository upisRepo;
	
	@Autowired
	TokStudijaRepository tokRepo;
	
	
	@Test
	public void saveStudentTest() throws ParseException {
		
		
		VrstaStudija vrsta1 = new VrstaStudija("Osnovne akademske studije", "OAS");
		VrstaStudija vrsta2 = new VrstaStudija("Master akademske studije", "MAS");
		
		vrstaRepo.save(vrsta1);
		vrstaRepo.save(vrsta2);
		
		Studprogram sp1 = new Studprogram("Racunarske nauke", "RN", "Dipl. informaticar", null, 8, vrsta1);
		Studprogram sp2 = new Studprogram("Racunarkso inzenjerstvo", "RI", "Dipl. inzenjer elektro tehnike i racunarstva", null, 8, vrsta1);
		
		studProgramRepo.save(sp1);
		studProgramRepo.save(sp2);
		
		SrednjaSkola sk = new SrednjaSkola();
		sk.setImeSkole("Mileta Micka");
		sk.setMesto("Sombor");
		sk.setVrsta("srednja");
		
		srednjeRepo.save(sk);
		
		VisokaSkola vs = new VisokaSkola();
		vs.setImeUstanove("Fakultet dramskih umetnosti");
		vs.setMestoUstanove("Beograd");
		vs.setSmer("Gluma");
		visokaRepo.save(vs);
		
		Student s = new Student(2019, "David", "Nikolic", "Aleksa", "2602000790030", null,"Ivanjica", null, null, null, null, null, null, null, null, null, null, sk, 0);
		s.setVisokaSkola(vs);
		
		Student s1 = new Student(2018, "David", "Lukic", "Aleksa", "2602000790030", null,"Ivanjica", null, null, null, null, null, null, null, null, null, null, sk, 0);
		Student s2 = new Student(2018, "David", "Petrovic", "Aleksa", "2602000790030", null,"Ivanjica", null, null, null, null, null, null, null, null, null, null, sk, 0);
		Student s3 = new Student(2018, "David", "Milic", "Aleksa", "2602000790030", null,"Ivanjica", null, null, null, null, null, null, null, null, null, null, sk, 0);
		Student s4 = new Student(2018, "Aleksa", "Nikolic", "Aleksa", "2602000790030", null,"Ivanjica", null, null, null, null, null, null, null, null, null, null, sk, 0);
		
		studentRepo.save(s);
		studentRepo.save(s1);
		studentRepo.save(s2);
		studentRepo.save(s3);
		studentRepo.save(s4);
		
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse("2019-10-01");
		
	
		StudIndex index = new StudIndex();
		index.setDatumaktivnosti(d);
		index.setBroj(93);
		index.setAktivan(true);
		index.setGodinaUpisa(2019);
		index.setStudent(s);
		index.setStudProgram(sp1);
		
		StudIndex index1 = new StudIndex();
		index1.setDatumaktivnosti(d);
		index1.setBroj(94);
		index1.setAktivan(true);
		index1.setGodinaUpisa(2019);
		index1.setStudent(s1);
		index1.setStudProgram(sp1);
		
		StudIndex index2 = new StudIndex();
		index2.setDatumaktivnosti(d);
		index2.setBroj(100);
		index2.setAktivan(true);
		index2.setGodinaUpisa(2019);
		index2.setStudent(s2);
		index2.setStudProgram(sp2);
		
	    studIndex.save(index);
	    studIndex.save(index1);
	    studIndex.save(index2);
	    
	    prijavaIspita pr1 = new prijavaIspita(null, null, s1, true);
	    prijavaIspita pr2 = new prijavaIspita(null, null, s2, false);
	    prijavaIspita pr3 = new prijavaIspita(null, null, s, true);
	    
		prijavaRepo.save(pr1);
		prijavaRepo.save(pr2);
		prijavaRepo.save(pr3);
		
		IzlazakNaIspit in1 = new IzlazakNaIspit(91, "Polozio!", false, 10.0, true, s1, null);
		IzlazakNaIspit in2 = new IzlazakNaIspit(31, "Pao!", false, 5.0, false, s3, null);
		
		izlazakRepo.save(in1);
		izlazakRepo.save(in2);
		
		Predmet p4 = new Predmet();
		p4.setNaziv("MA");
		p4.setSifra("943");

		Predmet p5 = new Predmet();
		p5.setNaziv("UI");
		p5.setSifra("684");
		
		predmetRepo.save(p4);
		predmetRepo.save(p5);
		
		ObnovaGodine oGodine = new ObnovaGodine(3, p5, null, null);
		ObnovaGodine oGodine1 = new ObnovaGodine(1, p4, null, null);
		ObnovaGodine oGodine2 = new ObnovaGodine(1, p5, "Obnova zbog zbog", d);
		
		obnovaRepo.save(oGodine);
		obnovaRepo.save(oGodine1);
		obnovaRepo.save(oGodine2);
		
		UpisGodine uGodine = new UpisGodine(3, p5,"....",null);
		UpisGodine uGodine1 = new UpisGodine(1, p4, null, d);
		UpisGodine uGodine2 = new UpisGodine(1, p5, null, null);
		
		upisRepo.save(uGodine);
		upisRepo.save(uGodine1);
		upisRepo.save(uGodine2);
		
		TokStudija tStud = new TokStudija(s1, uGodine1, null, "Prvi put!", d);
		TokStudija tStud2 = new TokStudija(s3, uGodine1, oGodine1, "Obnovljena godina zbog...", null);
		TokStudija tStud3 = new TokStudija(s, uGodine, null,null,null);
		
		tokRepo.save(tStud);
		tokRepo.save(tStud2);
		tokRepo.save(tStud3);
	}

	@Test
	public void findStudentTest() {
		System.out.println("Po imenu:");
		List<Student> students = studentRepo.findStudentbyName("david", null);
		for(Student s : students) {
			System.out.println(s);
		}
		
		System.out.println("Po prezimenu:");
	
		List<Student> studentiPrezime = studentRepo.findStudentbyName("David", "Nikolic");
		for(Student s: studentiPrezime) {
			System.out.println(s.getIndexs().get(0).getStudProgram());
		}
			
	}
	
}
