package studsluzba.repositorytest;

import java.text.DateFormat;
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

import studsluzba.model.DrziPredmet;
import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.IzlazakNaIspit;
import studsluzba.model.Nastavnik;
import studsluzba.model.ObnovaGodine;
import studsluzba.model.PredispitnaObaveza;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.SrednjaSkola;
import studsluzba.model.StudIndex;
import studsluzba.model.Student;
import studsluzba.model.StudentPredispitneObaveze;
import studsluzba.model.Studprogram;
import studsluzba.model.TokStudija;
import studsluzba.model.UpisGodine;
import studsluzba.model.VisokaSkola;
import studsluzba.model.VrstaStudija;
import studsluzba.model.Zvanje;
import studsluzba.model.prijavaIspita;
import studsluzba.repositories.DrziPredmetRepository;
import studsluzba.repositories.IspitRepository;
import studsluzba.repositories.IspitniRokRepository;
import studsluzba.repositories.IzlazakNaIspitrepository;
import studsluzba.repositories.NastavnikRepository;
import studsluzba.repositories.ObnovaGodineRepository;
import studsluzba.repositories.PredispitnaObavezaRepository;
import studsluzba.repositories.PredmetRepository;
import studsluzba.repositories.PrijavaIspitarepository;
import studsluzba.repositories.SkolskaGodinaRepository;
import studsluzba.repositories.SrednjeSkoleRepository;
import studsluzba.repositories.StudIndexRepository;
import studsluzba.repositories.StudProgramRepository;
import studsluzba.repositories.StudentPredispitneObavezeRepository;
import studsluzba.repositories.StudentRepository;
import studsluzba.repositories.TokStudijaRepository;
import studsluzba.repositories.UpisGodineRepository;
import studsluzba.repositories.VisokaSkolaRepository;
import studsluzba.repositories.VrstaStudijaRepository;
import studsluzba.repositories.ZvanjeRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
	
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
	@Autowired
	NastavnikRepository nasRepo;
	@Autowired
	IspitniRokRepository isrokRepo;
	@Autowired
	IspitRepository ispitRepo;
	@Autowired
	SkolskaGodinaRepository sgRepo;
	@Autowired
	ZvanjeRepository zvanjeRepo;
	@Autowired
	DrziPredmetRepository  drziPredmetRepo;
	@Autowired
	StudentPredispitneObavezeRepository spoRepo;
	@Autowired
	PredispitnaObavezaRepository poRepo;
	
	
	
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
	    
	    
		
		IzlazakNaIspit in1 = new IzlazakNaIspit(91, "Polozio!", false, 10.0, true, s1, null);
		IzlazakNaIspit in2 = new IzlazakNaIspit(31, "Pao!", false, 5.0, false, s3, null);
		
		izlazakRepo.save(in1);
		izlazakRepo.save(in2);
		
		
		
		Zvanje zv1 = new Zvanje();
		zv1.setDatumIzbora(new Date(2020,2,2));
		zv1.setNaziv("DOKTOR");
		zv1.setUzaNaucnaOblast("austronaut");
		zvanjeRepo.save(zv1);

		Nastavnik n1 = new Nastavnik();
		n1.setIme("Pera");
		List<Zvanje> zvanja = new ArrayList<Zvanje>();
		zvanja.add(zv1);
		n1.setZvanja(zvanja);
		n1.setEmail("pera@raf.rs");
		n1.setObrazovanje("Visoko");
		n1.setPrezime("Peric");
		n1.setSrednjeIme("Peki");
		nasRepo.save(n1);
		
		
		Predmet p4 = new Predmet();
		p4.setNaziv("MA");
		p4.setSifra("943");
		p4.setEspb(20);
		p4.setStudProgram(sp1);
		predmetRepo.save(p4);
		
		SkolskaGodina sg = new SkolskaGodina();
		sg.setGodina("2020-2021");
		sg.setAktivna(true);
		sgRepo.save(sg);
		
		IspitniRok ir = new IspitniRok(new Date(2020,5,2),new Date(2020,6,2), null, sg);
		isrokRepo.save(ir);
		
		Ispit ispit = new Ispit();
		ispit.setDatumOdrzavanja(new Date(2020,5,5));
		ispit.setNastavnik(n1);
		ispit.setVremePocetka("08:00");
		ispit.setVremeZavrsetka("10:00");
		ispit.setPredmet(p4);
		ispit.setZakljucen(false);
		ispit.setIspitniRok(ir);
		
		ispitRepo.save(ispit);
		
		
		prijavaIspita pr1 = new prijavaIspita(null, ispit, s1, true);
	    prijavaIspita pr2 = new prijavaIspita(null, null, s2, false);
	    prijavaIspita pr3 = new prijavaIspita(null, ispit, s, true);
	    
		prijavaRepo.save(pr1);
		prijavaRepo.save(pr2);
		prijavaRepo.save(pr3);
		
		UpisGodine uGodine = new UpisGodine(3, p4,"....",null);
		UpisGodine uGodine1 = new UpisGodine(1, p4, null, d);
		UpisGodine uGodine2 = new UpisGodine(1, p4, null, null);
		
		
		upisRepo.save(uGodine);
		upisRepo.save(uGodine1);
		upisRepo.save(uGodine2);
		
		TokStudija tStud = new TokStudija(s1, uGodine1, null, "Prvi put!", d);
		TokStudija tStud3 = new TokStudija(s, uGodine, null,null,null);
		
		tokRepo.save(tStud);
		tokRepo.save(tStud3);


		
		ObnovaGodine oGodine = new ObnovaGodine(3, p4, "napomena neka", new Date(2020,6,7));
		List<TokStudija> tss = new ArrayList<TokStudija>();
		tss.add(tStud);
		oGodine.setTokStudija(tss);
		obnovaRepo.save(oGodine);

		
		
		DrziPredmet dPredmet = new DrziPredmet(sg, p4, n1, s1);
		drziPredmetRepo.save(dPredmet);
		
		PredispitnaObaveza po = new PredispitnaObaveza("Kolokvijum", 100);
		poRepo.save(po);
		
		StudentPredispitneObaveze spo = new StudentPredispitneObaveze(95, po, dPredmet);
		spoRepo.save(spo);
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