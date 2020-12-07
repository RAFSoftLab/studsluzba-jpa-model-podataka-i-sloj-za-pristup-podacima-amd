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
public class RezultatiController {

	@Autowired
	IspitService ispitService;
	@Autowired
	MainViewManager mainViewManager;
	@FXML
	private Button btnPregled;
	@FXML
	ListView<Ispit> lvIspitaZaIspitniRok;

	// Ispit
	@FXML
	private TextField tfVremePocetka;
	@FXML
	private TextField tfVremeZavrsetka;
	@FXML
	private DatePicker dpDatumOdrzavanja;
	@FXML
	private ComboBox<Predmet> cbPredmet;
	@FXML
	private ComboBox<Nastavnik> cbNastavnik;
	@FXML
	private Button btnSacuvajIspit;

	// IspitniRok
	@FXML
	private DatePicker dpDatumPocetka;
	@FXML
	private DatePicker dpDatumZavrsetka;
	@FXML
	private ComboBox<SkolskaGodina> cbSkolskaGodina = new ComboBox<SkolskaGodina>();
	@FXML
	private Button btnSacuvajIspitniRok;
	@FXML
	private Button btnPrikaziIspitniRok;

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

		

	}


	
}
