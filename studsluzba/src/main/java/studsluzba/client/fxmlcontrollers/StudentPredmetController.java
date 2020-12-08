package studsluzba.client.fxmlcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import studsluzba.client.MainViewManager;
import studsluzba.model.DrziPredmet;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.StudIndex;
import studsluzba.model.StudentDrziPredmet;
import studsluzba.services.DrziPredmetService;
import studsluzba.services.SkolskaGodinaService;
import studsluzba.services.StudentDrziPredmetService;
import studsluzba.services.StudentService;
import studsluzba.sifarnici.SmerSemestar;
import studsluzba.tools.Stored;

@Component
public class StudentPredmetController {
	
	private StudIndex student;
	private List<Predmet> svi = new ArrayList<Predmet>();

	@Autowired
	MainViewManager mainViewManager;
	
	@Autowired
	StudentDrziPredmetService sdpService;
	@Autowired
	StudentService studentService;
	@Autowired
	DrziPredmetService dpService;
	@Autowired
	SkolskaGodinaService sgService;
	
	@FXML private Label errorL;
	@FXML private Label studentL;
	@FXML private Label predmetiL;
	@FXML private ComboBox<SmerSemestar> semestarCb;
	@FXML private TableView<DrziPredmet> dpTv;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@FXML
	public void initialize() {
		Object x = new Object();
		if (MainViewManager.getParameters().get(0) != null) {
			x = MainViewManager.getParameters().get(0);
			if (x instanceof StudIndex) {
				student = (StudIndex) x;
			}
		}
		else return;
		
		if (student != null)
			studentL.setText("Student: " + student.toString());
		
		List<DrziPredmet> dps = dpService.findAllByStudProgram(student.getStudProgram());
		
		TableColumn<DrziPredmet, Nastavnik> nc = new TableColumn<DrziPredmet,Nastavnik>("Nastavnik");
		nc.setCellValueFactory(new PropertyValueFactory("nastavnik"));
		TableColumn<DrziPredmet, Predmet> dic = new TableColumn<DrziPredmet, Predmet>("Predmet");
		dic.setCellValueFactory(new PropertyValueFactory("predmet"));
		TableColumn<DrziPredmet, SkolskaGodina> unoc = new TableColumn<DrziPredmet,SkolskaGodina>("Skolska godina");
		unoc.setCellValueFactory(new PropertyValueFactory("sg"));
		 
		dpTv.getColumns().setAll(nc, dic, unoc);

		List<DrziPredmet> set = new ArrayList<DrziPredmet>();
		SkolskaGodina aktivna = Stored.getInstance().getAktivnaSkolskaGodina();
		for (DrziPredmet dp : dps) {
			if(dp.getSg().equals(aktivna))
				set.add(dp);
		}
		dpTv.setItems(FXCollections.observableArrayList(set));
		
		List<SmerSemestar> ss = Stored.getInstance().getSmerSemestarList();
		semestarCb.setItems(FXCollections.observableArrayList(ss));
		
		List<Predmet> trPredmeti = sdpService.findPredmetiByStudent(student);
		String s = "";
		for (Predmet p : trPredmeti) {
			svi.add(p);
			s += p.getNaziv();
			s += ",";
		}
		s = s.substring(0, s.length() - 2);
		predmetiL.setText("Dodati predmeti: " + s);
	}
	
	
	public void dodajPojedinacno() {
		DrziPredmet dp = dpTv.getSelectionModel().getSelectedItem();
		if (dp != null) {
			StudentDrziPredmet sdp = new StudentDrziPredmet(dp, student);
			if (svi.contains(dp.getPredmet())) {
				//ima vec
				errorL.setText("Postoji predmet koji je vec dodeljen!");
			}
			else if (sdpService.save(sdp) == null) {
				errorL.setText("Neuspesno cuvanje predmeta za studenta!");
			}
			else {
				svi.add(dp.getPredmet());
				predmetiL.setText(predmetiL.getText() + ", " + sdp.getDrziPredmet().getPredmet().getNaziv());
			}
		}
		else {
			//nije izabrano
			errorL.setText("Nije izabran nijedan predmet!");
		}
 	}
	
	public void dodajSve() {
		SmerSemestar s = semestarCb.getValue();
		String predmeti = "";
		boolean flag = false;
		if (s != null) {
			for (String i : s.getPredmeti()) {
				DrziPredmet dps = dpService.findBySifraPredmeta(i);
				StudentDrziPredmet sdp = new StudentDrziPredmet(dps, student);
				if (dps == null && !flag) {
					//find error
					errorL.setText("Neuspesno cuvanje predmeta za studenta!");
				}
				else if (svi.contains(dps.getPredmet())) {
					//ima vec
					errorL.setText("Postoji predmet koji je vec dodeljen!");
				}
				else if (sdpService.save(sdp) == null) {
					//save error
					errorL.setText("Neuspesno cuvanje predmeta za studenta!");
				}
				else {
					flag = true;
					svi.add(dps.getPredmet());
					predmeti += dps.getPredmet().getNaziv() + ",";
				}
			}
			if (!predmeti.isEmpty()) {
				predmeti = predmeti.substring(0, predmeti.length()-2);
				predmetiL.setText(predmetiL.getText() + predmeti);
			}
		}
		else {
			//error nije selektovano
			errorL.setText("Nije izabrana grupa predmeta!");
		}
	}
	
	public void vrati() {
		mainViewManager.changeRoot("findStudent");
	}
	
}
