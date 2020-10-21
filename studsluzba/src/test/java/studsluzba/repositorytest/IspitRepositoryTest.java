package studsluzba.repositorytest;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.repositories.IspitRepository;
import studsluzba.repositories.IspitniRokRepository;
import studsluzba.repositories.NastavnikRepository;
import studsluzba.repositories.PredmetRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IspitRepositoryTest {
//
	@Autowired
	IspitRepository ispitRepo;

	@Autowired
	IspitniRokRepository ispitniRokRepo;

	@Autowired
	NastavnikRepository nastavnikRepo;

	@Autowired
	PredmetRepository predmetRepo;

	@Test
	public void saveISpitTest() {

		IspitniRok irJ = new IspitniRok();
		irJ.setDatumPocetka("23/01/2020");
		irJ.setDatumZavrsetka("01/02/2020");

		IspitniRok irF = new IspitniRok();
		irF.setDatumPocetka("01/02/2020");
		irF.setDatumZavrsetka("13/02/2020");

		ispitniRokRepo.save(irJ);
		ispitniRokRepo.save(irF);

		Predmet p2 = new Predmet();
		p2.setNaziv("UUP");
		p2.setSifra("324");

		Predmet p3 = new Predmet();
		p3.setNaziv("OS");
		p3.setSifra("634");

		Predmet p4 = new Predmet();
		p4.setNaziv("MA");
		p4.setSifra("943");

		Predmet p5 = new Predmet();
		p5.setNaziv("UI");
		p5.setSifra("684");

		predmetRepo.save(p2);
		predmetRepo.save(p3);
		predmetRepo.save(p4);
		predmetRepo.save(p5);

		Nastavnik n1 = new Nastavnik("Bojana", "Dimic", "Surla", "bsurla@gmail.com", null, null);
		Nastavnik n2 = new Nastavnik("Igor", "Ciganovic", "Cigan", "iciganovic@gmail.com", null, null);
		Nastavnik n3 = new Nastavnik("Marta", "Markovic", "Marija", "mmarkovic@gmail.com", null, null);

		nastavnikRepo.save(n1);
		nastavnikRepo.save(n2);
		nastavnikRepo.save(n3);

		Ispit i1 = new Ispit("23/01/2020", "13:00", n1, p2, false);
		i1.setIspitniRok(irJ);
		Ispit i2 = new Ispit("24/01/2020", "14:00", n2, p3, false);
		i2.setIspitniRok(irJ);
		Ispit i3 = new Ispit("25/01/2020", "15:00", n3, p4, false);
		i3.setIspitniRok(irJ);
		Ispit i4 = new Ispit("02/02/2020", "11:00", n1, p5, false);
		i4.setIspitniRok(irF);
		Ispit i5 = new Ispit("03/02/2020", "16:00", n3, p4, false);
		i5.setIspitniRok(irF);

		ispitRepo.save(i1);
		ispitRepo.save(i2);
		ispitRepo.save(i3);
		ispitRepo.save(i4);
		ispitRepo.save(i5);

	}
}
