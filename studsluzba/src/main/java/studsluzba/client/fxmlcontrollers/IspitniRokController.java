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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import studsluzba.client.MainViewManager;
import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.SrednjaSkola;
import studsluzba.model.Student;
import studsluzba.model.Studprogram;
import studsluzba.services.IspitService;
import studsluzba.services.IspitniRokService;
import studsluzba.services.NastavnikService;
import studsluzba.services.PredmetService;
import studsluzba.services.SkolskaGodinaService;
import studsluzba.tools.FXSetter;

@Component
public class IspitniRokController {

	@Autowired
	IspitniRokService ispitniRokService;
	@Autowired
	IspitService ispitService;
	@Autowired
	NastavnikService nastavnikService;
	@Autowired
	PredmetService predmetService;
	@Autowired
	SkolskaGodinaService skolskaGodinaService;
	@Autowired
	MainViewManager mainViewManager;
	@FXML
	private Button btnDodajIspitniRok;
	@FXML
	private Button btnDodajIspitZaIspitniRok;
	@FXML
	private Button btnPrikaziIspite;
	@FXML
	ListView<IspitniRok> lvIspitnihRokova;
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

	@FXML
	private CheckBox zakCb;

	// IspitniRok
	@FXML
	private DatePicker dpDatumPocetka;
	@FXML
	private DatePicker dpDatumZavrsetka;
	@FXML
	private ComboBox<SkolskaGodina> cbSkolskaGodina;
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
	
	

	}

	public void handleOpenModalIspitniRok(ActionEvent ae) {
		mainViewManager.openModalNoWait("ispitniRok");
		
		List<SkolskaGodina> sveSkolskeGodine = skolskaGodinaService.getSkolskeGodine();
		ObservableList<SkolskaGodina> sveSkolskeGodineObservableList = FXCollections
				.observableArrayList(sveSkolskeGodine);
		cbSkolskaGodina.setItems(sveSkolskeGodineObservableList);
			
	}

	public void handleOpenModalIspitZaIspitniRok(ActionEvent ae) {
		ispitiZaRok.clear();
		
		ispitniRokAktivan = lvIspitnihRokova.getSelectionModel().getSelectedItem();
		
		if(ispitniRokAktivan!=null) {
			mainViewManager.openModalNoWait("ispit");
			
			List<Predmet> sviPredmeti =  predmetService.findAll();
			ObservableList<Predmet> sviPredmetiObservableList = FXCollections
					.observableArrayList(sviPredmeti);
			cbPredmet.setItems(sviPredmetiObservableList);
			
			List<Nastavnik> sviNastavnici =  nastavnikService.findAll();
			ObservableList<Nastavnik> sviNastavniciObservableList = FXCollections
					.observableArrayList(sviNastavnici);
			cbNastavnik.setItems(sviNastavniciObservableList);
		}
	}

	public void handleSaveIspitZaIspitniRok(ActionEvent ae) {

		ispitniRokAktivan = lvIspitnihRokova.getSelectionModel().getSelectedItem();
		
		
		boolean zakljucen = false;
		if (zakCb.isSelected()) {
			zakljucen = true;

		} else {
			zakljucen = false;
		}
		
		Ispit ispit = ispitService.saveIspit(new Ispit(dpDatumOdrzavanja.getValue(), tfVremePocetka.getText(),
				tfVremeZavrsetka.getText(), cbNastavnik.getSelectionModel().getSelectedItem(),
				cbPredmet.getSelectionModel().getSelectedItem(), ispitniRokAktivan, zakljucen));

		ispitiZaRok.add(ispit);
		ispitniRokAktivan.setIspiti(ispitiZaRok);
		

	}

	public void handleSaveIspitniRok(ActionEvent ae) {
		IspitniRok ir = ispitniRokService.saveIspitniRok(new IspitniRok(dpDatumPocetka.getValue(), dpDatumZavrsetka.getValue(), null,
				cbSkolskaGodina.getSelectionModel().getSelectedItem(), dpDatumPocetka.getValue().getMonth().toString()));  // da se napravi enum za srpske nazive meseci

		ispitniRokovi.add(ir);
		ObservableList<IspitniRok> ispitniRokoviO = FXCollections.observableArrayList(ispitniRokovi);
		lvIspitnihRokova.setItems(ispitniRokoviO);
		FXSetter.emptyElements(dpDatumPocetka, dpDatumZavrsetka, cbSkolskaGodina);
	}

	public void handlePrikaziIspite(ActionEvent ae) {
		IspitniRok ir = lvIspitnihRokova.getSelectionModel().getSelectedItem();

		if (ir != null) {
			List<Ispit> i = ir.getIspiti();
			if (i != null && !(i.isEmpty())) {
				ObservableList<Ispit> ispitiO = FXCollections.observableArrayList(i);

				lvIspitaZaIspitniRok.setItems(ispitiO);
			}
			else {
				lvIspitaZaIspitniRok.setItems(null);
			}

		}

	}

	public void handlePrikaziSveIspitneRokove(ActionEvent ae) {

		List<IspitniRok> ir = ispitniRokService.getAll();
		ObservableList<IspitniRok> ispitniRokoviO = FXCollections.observableArrayList(ir);

		lvIspitnihRokova.setItems(ispitniRokoviO);

	}

}
