package studsluzba.client.fxmlcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import studsluzba.client.MainViewManager;
import studsluzba.model.DrziPredmet;
import studsluzba.model.ObnovaGodine;
import studsluzba.model.Predmet;
import studsluzba.model.StudIndex;
import studsluzba.model.TokStudija;
import studsluzba.model.TokStudijaDrziPredmet;
import studsluzba.model.UpisGodine;
import studsluzba.services.DrziPredmetService;
import studsluzba.services.ObnovaGodineService;
import studsluzba.services.PredmetService;
import studsluzba.services.TokStudijaDrziPredmetService;
import studsluzba.services.TokStudijaService;
import studsluzba.services.UpisGodineService;
import studsluzba.sifarnici.SmerSemestar;
import studsluzba.tools.Stored;

@Component
public class ObnovaGodineController {

	@Autowired
	TokStudijaService tsService;
	@Autowired
	ObnovaGodineService ogService;
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

	public void handleSaveObnovljenePredmete(ActionEvent ae) {

	}

	public void handleSaveObnova(ActionEvent ae) {
		TokStudija ts = tsService.findByStudIndex(student);
		int godina = Integer.parseInt(tfGodina.getText());
		ObnovaGodine og = new ObnovaGodine(godina, tfNapomena.getText(), dpDatum.getValue(), ts);
		
		List<TokStudijaDrziPredmet> tsList = new ArrayList<TokStudijaDrziPredmet>();
		try {
			og = ogService.save(og);
		
		} catch (Exception e) {
			ogService.delete(og);
			return;
		}	
	}

}
