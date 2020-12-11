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
import studsluzba.model.Predmet;
import studsluzba.services.PredmetService;

@Component
public class ObnovaGodineController {

	
	@Autowired
	PredmetService predmetService;
	@FXML
	TextField tfGodina;
	@FXML
	TextField tfNapomena;
	@FXML
	DatePicker dpDatum;
	@FXML
	ListView<Predmet> lvPredmeti;

	List<Predmet> selektovaniPredmeti;

	@FXML
	public void initialize() {
		lvPredmeti.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		List<Predmet> sviPredmeti = predmetService.findAll();
		lvPredmeti.setItems(FXCollections.observableArrayList(sviPredmeti));

	}

	public void handleSaveObnovljenePredmete(ActionEvent ae) {

		selektovaniPredmeti = new ArrayList<Predmet>();
		selektovaniPredmeti.addAll(lvPredmeti.getSelectionModel().getSelectedItems());

	}

	public void handleSaveObnova(ActionEvent ae) {

		for (Predmet s : selektovaniPredmeti) {
			System.out.println(s);
		}
	}

}
