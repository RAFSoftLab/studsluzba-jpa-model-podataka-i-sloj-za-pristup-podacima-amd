package studsluzba.client.fxmlcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import studsluzba.client.MainViewManager;
import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.services.IspitService;
import studsluzba.services.IspitniRokService;
import studsluzba.services.SkolskaGodinaService;

@Component
public class PrijavljeniStudentiZaIspitController {
	@Autowired
	IspitniRokService ispitniRokService;
	@Autowired
	IspitService ispitService;
	@Autowired
	MainViewManager mainViewManager;
	@FXML
	private Button btnPrikaziIspite;
	@FXML
	private Button btnStudenti;
	@FXML
	ListView<IspitniRok> lvIspitnihRokova;
	@FXML
	ListView<Ispit> lvIspitaZaIspitniRok;
	@FXML
	ListView<Ispit> lvStudentiZaIspit;


	Ispit ispitAktivan;
	IspitniRok ispitniRokAktivan;
	List<Ispit> ispitiZaRok = new ArrayList<Ispit>();
	List<IspitniRok> ispitniRokovi = new ArrayList<IspitniRok>();

	@FXML
	public void initialize() {
		/*
		 * List<Studprogram> sviStudProgrami = studProgramService.getAllPrograms();
		 * ObservableList<Studprogram> sviStudProgramiObservableList =
		 * FXCollections.observableArrayList(sviStudProgrami);
		 * studProgramCb.setItems(sviStudProgramiObservableList);
		 */
/*
		List<SkolskaGodina> sveSkolskeGodine = skolskaGodinaService.getSkolskeGodine();
		ObservableList<SkolskaGodina> sveSkolskeGodineObservableList = FXCollections
				.observableArrayList(sveSkolskeGodine);
		cbSkolskaGodina.setItems(sveSkolskeGodineObservableList);
		*/
		
		List<IspitniRok> ir = ispitniRokService.getAll();
		ObservableList<IspitniRok> ispitniRokoviO = FXCollections.observableArrayList(ir);

		lvIspitnihRokova.setItems(ispitniRokoviO);

	}

	public void handleOpenModaStudentiZaIspit(ActionEvent ae) {
		ispitAktivan = lvIspitaZaIspitniRok.getSelectionModel().getSelectedItem();
/*
		if (ispitAktivan != null) {
			List<Student> i = ispitAktivan.get;
			if (!(i.isEmpty())) {
				ObservableList<Student> ispitiO = FXCollections.observableArrayList(i);

				lvIspitaZaIspitniRok.setItems(ispitiO);
			}
			
		}
		*/
		mainViewManager.openModal("studentiZaIspit");
		
	}

	public void handleOpenModalIspitZaIspitniRok(ActionEvent ae) {
		
		ispitAktivan = lvIspitaZaIspitniRok.getSelectionModel().getSelectedItem();
		
		if(ispitAktivan!=null) {
			mainViewManager.openModal("studentiZaIspit");
			
		}
	}
	
	
/*
	public void handleSaveIspitZaIspitniRok(ActionEvent ae) {

		ispitniRokAktivan = lvIspitnihRokova.getSelectionModel().getSelectedItem();
		// !!!!!!!!!!!
		Ispit ispit = ispitService.saveIspit(dpDatumOdrzavanja.getValue(), tfVremePocetka.getText(),
				tfVremeZavrsetka.getText(), cbNastavnik.getSelectionModel().getSelectedItem(),
				cbPredmet.getSelectionModel().getSelectedItem(), ispitniRokAktivan, true);

		ispitiZaRok.add(ispit);
		ispitniRokAktivan.setIspiti(ispitiZaRok);
		

	}
*/
	

	public void handlePrikaziIspite(ActionEvent ae) {
		ispitniRokAktivan = lvIspitnihRokova.getSelectionModel().getSelectedItem();

		if (ispitniRokAktivan != null) {
			List<Ispit> i = ispitniRokAktivan.getIspiti();
			if (!(i.isEmpty())) {
				ObservableList<Ispit> ispitiO = FXCollections.observableArrayList(i);

				lvIspitaZaIspitniRok.setItems(ispitiO);
			}

		}

	}
}
