package studsluzba.client.fxmlcontrollers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import studsluzba.client.reports.ReportsManager;
import studsluzba.client.reports.entities.IspitProfesorStudenti;
import studsluzba.client.reports.entities.StudentPoeniOcena;
import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.StudIndex;
import studsluzba.model.Student;
import studsluzba.services.IspitService;
import studsluzba.services.IspitniRokService;
import studsluzba.services.IzlazakNaIspitService;
import studsluzba.services.StudentIndexService;
import studsluzba.services.StudentService;

@Component
public class IspitIzvestajiController {

	@Autowired
	ReportsManager reportsManager;
	@Autowired
	IspitService is;
	@Autowired
	StudentIndexService sis;
	@Autowired
	StudentService ss;
	@Autowired
	IspitniRokService irs;
	@Autowired
	IzlazakNaIspitService inis;
	
	@FXML private ComboBox<Ispit> ispitiCb;
	
	@FXML
	public void initialize() {
		List<Ispit> ispiti = is.findAll();
		ispitiCb.setItems(FXCollections.observableArrayList(ispiti));
	}
	
	public void generisi() {
		Ispit i = ispitiCb.getValue();
		IspitniRok ir = i.getIspitniRok();
		List<StudIndex> studenti = sis.findByIspit(i);
		SkolskaGodina sg = irs.findSkolskaGodina(ir);
		Nastavnik n = i.getNastavnik();
		Predmet p = i.getPredmet();
		String sifraPredmeta = p.getSifra();
		List<IspitProfesorStudenti> fields = new ArrayList<IspitProfesorStudenti>();
		for (StudIndex si : studenti) {
			Student s = sis.findStudentByIndex(si);
			String brojPolaganja = inis.countIzlazciNaIspit(si, i) + "";
			StudentPoeniOcena info = inis.findRezultati(si, i);
			IspitProfesorStudenti ips = 
					new IspitProfesorStudenti(sg.getGodina(), p.getNaziv(), n.getIme() + " " + n.getPrezime(), s.getPrezime() + " " + s.getIme(), info.getNapomena(), info.getPoeni()+"", ir.toString(), si.toString(), brojPolaganja + "", info.getOcena()+"", sifraPredmeta);
			fields.add(ips);
			System.out.println(ips.toString());
		}
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		reportsManager.openReport(fields, params, "ispiti");
	}
	
}
