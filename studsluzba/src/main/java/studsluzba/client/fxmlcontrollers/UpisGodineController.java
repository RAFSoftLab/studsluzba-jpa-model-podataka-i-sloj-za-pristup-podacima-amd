package studsluzba.client.fxmlcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import studsluzba.client.MainViewManager;
import studsluzba.model.DrziPredmet;
import studsluzba.model.Predmet;
import studsluzba.model.StudIndex;
import studsluzba.model.Student;
import studsluzba.model.TokStudija;
import studsluzba.model.TokStudijaDrziPredmet;
import studsluzba.model.UpisGodine;
import studsluzba.services.DrziPredmetService;
import studsluzba.services.PredmetService;
import studsluzba.services.TokStudijaDrziPredmetService;
import studsluzba.services.TokStudijaService;
import studsluzba.services.UpisGodineService;
import studsluzba.sifarnici.SmerSemestar;
import studsluzba.tools.Stored;

@Component
public class UpisGodineController {

	@Autowired
	TokStudijaService tsService;
	@Autowired
	UpisGodineService ugService;
	@Autowired
	DrziPredmetService dpService;
	@Autowired
	TokStudijaDrziPredmetService tsdpService;
	@FXML
	TextField tfGodina;
	@FXML
	TextField tfNapomena;
	@FXML
	DatePicker dpDatum;
	
	private StudIndex student = null;
	
	@FXML
	public void initialize() {
		student = (StudIndex) MainViewManager.getParameters().get(0);
	}

	

	public void handleSaveUpis(ActionEvent ae) {
		TokStudija ts = tsService.findByStudIndex(student);
		int godina = Integer.parseInt(tfGodina.getText());
		UpisGodine ug = new UpisGodine(godina, tfNapomena.getText(), dpDatum.getValue(), ts);
		
		String smer = student.getStudProgram().getSkraceniNaziv().toLowerCase();
		SmerSemestar ss = Stored.getInstance().getSmerSemestarBySmerSemestar(smer, godina);
		List<TokStudijaDrziPredmet> tsList = new ArrayList<TokStudijaDrziPredmet>();
		try {
			ug = ugService.save(ug);
			if (ss != null) {
				for (String p : ss.getPredmeti()) {
					DrziPredmet pr = dpService.findBySifraPredmeta(p);
					if (pr != null) {
						TokStudijaDrziPredmet tsdp = new TokStudijaDrziPredmet(ts, pr);
						tsdpService.save(tsdp);
						tsList.add(tsdp);
					}
				}
			}
		
		} catch (Exception e) {
			for (TokStudijaDrziPredmet u : tsList) {
				tsdpService.delete(u);
			}
			ugService.delete(ug);
			return;
		}
	}

}
