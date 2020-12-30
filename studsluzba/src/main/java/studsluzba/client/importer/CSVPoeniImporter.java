package studsluzba.client.importer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studsluzba.model.Ispit;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.StudIndex;
import studsluzba.services.PredmetService;
import studsluzba.services.SkolskaGodinaService;
import studsluzba.services.StudentService;

@Component
public class CSVPoeniImporter {
	
	@Autowired
	StudentService studService;
	
	@Autowired
	PredmetService predmetService;
	
	@Autowired
	SkolskaGodinaService sgservice;
	
	// vraca poruku
	public String importCSV(File f) {
		Scanner sc = null;
		StringBuilder poruka = new StringBuilder();
		
		try {
			sc = new Scanner(f,"UTF-8");
			String lineP = sc.nextLine();
			List<Predmet> temp = predmetService.findByNazivOrSifra(lineP);
			Predmet p;
			if (temp.size() > 0) {
				p = temp.get(0);
			}
			else {
				return null;
			}
			
			String sgod = sc.nextLine();
			SkolskaGodina sg = sgservice.getByValue(sgod);
			if (sg == null) {
				return null;
			}
			
			sc.nextLine();
			int brojSacuvanihStudenata = 0;
			while(sc.hasNext()) {
				String line = sc.nextLine();
				String[] delovi = line.split(",");
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
