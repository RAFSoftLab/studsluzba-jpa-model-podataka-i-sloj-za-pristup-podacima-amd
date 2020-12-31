package studsluzba.client.importer;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.cj.result.LocalDateValueFactory;

import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.IzlazakNaIspit;
import studsluzba.model.Nastavnik;
import studsluzba.model.PolozenPredmet;
import studsluzba.model.PredispitnaObaveza;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.StudIndex;
import studsluzba.model.StudentPredispitneObaveze;
import studsluzba.repositories.IzlazakNaIspitrepository;
import studsluzba.services.IspitService;
import studsluzba.services.IspitniRokService;
import studsluzba.services.IzlazakNaIspitService;
import studsluzba.services.NastavnikService;
import studsluzba.services.PolozenPredmetService;
import studsluzba.services.PredispitnaObavezaService;
import studsluzba.services.PredmetService;
import studsluzba.services.SkolskaGodinaService;
import studsluzba.services.StudentPredispitneObavezeService;
import studsluzba.services.StudentService;

@Component
public class CSVPoeniImporter {
	
	@Autowired
	StudentService studService;
	
	@Autowired
	PredmetService predmetService;
	
	@Autowired
	SkolskaGodinaService sgservice;
	
	@Autowired
	PredispitnaObavezaService poservice;
	
	@Autowired
	StudentPredispitneObavezeService spoService;
	
	@Autowired
	IspitniRokService irservice;
	
	@Autowired
	NastavnikService nastavnikService;
	
	@Autowired
	IzlazakNaIspitService iniservice;
	
	@Autowired
	IspitService iservice;
	
	@Autowired
	PolozenPredmetService ppservice;
	
	private static final int minimum = 50; //minimum za prolaz sa predispitnim
	
	private int poeniUkupno(double poeni, double poeniPredispitno) {
		return (int) (poeni + poeniPredispitno);
	}
	
	// vraca poruku
	public String importCSV(File f) {
		Scanner sc = null;
		StringBuilder poruka = new StringBuilder();
		System.out.println("importer");
		
		try {
			sc = new Scanner(f,"UTF-8");
			String lineP = sc.nextLine().split(",")[0];
			List<Predmet> temp = predmetService.findByNazivOrSifra(lineP);
			Predmet p;
			if (temp.size() > 0) {
				p = temp.get(0);
			}
			else {
				return "Greska pri ucitavanju, ne postoji predmet u bazi!";
			}
			
			String sgod = sc.nextLine().split(",")[0];
			SkolskaGodina sg = sgservice.getByValue(sgod);
			if (sg == null) {
				return "Greska pri ucitavanju, ne postoji skolska godina u bazi!";
			}
			
			sc.nextLine();
			
			//hardcode predispitne, verovatno se u realnosti ne unosi ovako
			PredispitnaObaveza kol = poservice.find("Kolokvijum", 100);
			PredispitnaObaveza test = poservice.find("Test", 25);
			PredispitnaObaveza kviz = poservice.find("Kviz", 10);
			
			if (kol == null) {
				kol = poservice.save(new PredispitnaObaveza("Kolokvijum", 100));
			}
			if (test == null) {
				test = poservice.save(new PredispitnaObaveza("Test", 25));
			}
			if (kviz == null) {
				kviz = poservice.save(new PredispitnaObaveza("Kviz", 10));
			}
			///////////////////////////////////////////////////////////////
			
			//ispitni rok preko mysql hardcode, ovde samo hvatamo
			IspitniRok jun = irservice.findByParams(sg, "jun");
			IspitniRok jul = irservice.findByParams(sg, "jul");
			IspitniRok avgust = irservice.findByParams(sg, "avgust");
			IspitniRok septembar = irservice.findByParams(sg, "septembar");
			
			Nastavnik n = new Nastavnik("Bojana", "Dimic Surla", "", "bdimicsurla@raf.rs", "");
			nastavnikService.saveNastavnik(n);
			LocalDate ldjun = LocalDate.of(2020, 6, 1);
			LocalDate ldjul = LocalDate.of(2020, 7, 1);
			LocalDate ldavg = LocalDate.of(2020, 8, 1);
			LocalDate ldsept = LocalDate.of(2020, 9, 1);
			
			Ispit ijul = new Ispit(ldjun, "22:00", "23:00", n, p, jun, true);
			Ispit ijun = new Ispit(ldjul, "22:00", "23:00", n, p, jul, true);
			Ispit iavg = new Ispit(ldavg, "22:00", "23:00", n, p, avgust, true);
			Ispit isept = new Ispit(ldsept, "22:00", "23:00", n, p, septembar, true);
			iservice.saveIspit(ijul);
			iservice.saveIspit(ijun);
			iservice.saveIspit(iavg);
			iservice.saveIspit(isept);
			///////////////////////////////////////////////////////////////
			
			
			int brojSacuvanihStudenata = 0;
			while(sc.hasNext()) {
				String line = sc.nextLine();
				String[] delovi = line.split(",", -1);
				String studProgram = delovi[0];
				int broj = Integer.parseInt(delovi[1]);
				int godina = Integer.parseInt(delovi[2]);
				String prezime = delovi[3];
				String ime = delovi[4];
				StudIndex si = studService.getStudentIndeks(studProgram, broj, godina);
				if(si==null) {  // student ne postoji dodajemo ga, u realnom sistemu se ovo ne moze desiti
					si = studService.saveStudentAndIndex(ime, prezime, studProgram, broj, godina);
					brojSacuvanihStudenata++;
				}
				/// predispitne
				String klk = delovi[5].equals("")? "0": delovi[5];
				String tst = delovi[6].equals("")? "0": delovi[6];
				String kvz = delovi[7].equals("")? "0": delovi[7];
				StudentPredispitneObaveze spoklk = new StudentPredispitneObaveze(Double.parseDouble(klk), kol, si, p);
				StudentPredispitneObaveze spotst = new StudentPredispitneObaveze(Double.parseDouble(tst), test, si, p);
				StudentPredispitneObaveze spokvz = new StudentPredispitneObaveze(Double.parseDouble(kvz), kviz, si, p);
				spoService.save(spoklk);
				spoService.save(spotst);
				spoService.save(spokvz);
				
				String jn = delovi[8];
				String jl = delovi[9];
				String av = delovi[10];
				String se = delovi[11];
				
				IzlazakNaIspit junini = null;
				IzlazakNaIspit julini = null;
				IzlazakNaIspit avgini = null;
				IzlazakNaIspit septini = null;
			
				// ponistavanje ispita ne izgleda ovako u realnom sistemu
			
				double poeniPredispitno = Double.parseDouble(klk) + Double.parseDouble(tst) + Double.parseDouble(kvz);
				int ocena = 5;
				if (!jn.equals("")) {
					int poeniUkupno = poeniUkupno(Double.parseDouble(jn), poeniPredispitno);
					boolean polozen = poeniUkupno > minimum;
					ocena = (poeniUkupno%100 - 1)/10 + 1 >= 5? poeniUkupno%100 - 1/10 + 1: 5;
					junini = new IzlazakNaIspit(poeniUkupno, "", false, polozen, ocena, si, ijun);
					iniservice.save(junini);
				}
				if (!jl.equals("")) {
					if (junini != null)
						junini.setPonistava(true);
					int poeniUkupno = poeniUkupno(Double.parseDouble(jl), poeniPredispitno);
					boolean polozen = poeniUkupno > minimum;
					ocena = (poeniUkupno%100 - 1)/10 + 1 >= 5? (poeniUkupno%100 - 1)/10 + 1: 5;
					julini = new IzlazakNaIspit(poeniUkupno, "", false, polozen, ocena, si, ijul);
					iniservice.save(julini);
				}
				if (!av.equals("")) {
					if (junini != null)
						junini.setPonistava(true);
					if (julini != null)
						julini.setPonistava(true);
					int poeniUkupno = poeniUkupno(Double.parseDouble(av), poeniPredispitno);
					boolean polozen = poeniUkupno > minimum;
					ocena = (poeniUkupno%100 - 1)/10 + 1 >= 5? (poeniUkupno%100 - 1)/10 + 1: 5;
					avgini = new IzlazakNaIspit(poeniUkupno, "", false, polozen, ocena, si, iavg);
					iniservice.save(avgini);
				}
				if (!se.equals("")) {
					if (junini != null)
						junini.setPonistava(true);
					if (julini != null)
						julini.setPonistava(true);
					if (avgini != null)
						avgini.setPonistava(true);
					int poeniUkupno = poeniUkupno(Double.parseDouble(se), poeniPredispitno);
					boolean polozen = poeniUkupno > minimum;
					ocena = (poeniUkupno%100 - 1)/10 + 1 >= 5? (poeniUkupno%100 - 1)/10 + 1: 5;
					septini = new IzlazakNaIspit(poeniUkupno, "", false, polozen, ocena, si, isept);
					iniservice.save(septini);
				}
				if (ocena > 5) {
					PolozenPredmet pp = new PolozenPredmet(si, p, ocena, true);
					ppservice.save(pp);
				}
				
			}
			poruka.append("Broj sacuvanih studenata: ");
			poruka.append(brojSacuvanihStudenata);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sc.close();
		
		}
		return poruka.toString();
	}

}
