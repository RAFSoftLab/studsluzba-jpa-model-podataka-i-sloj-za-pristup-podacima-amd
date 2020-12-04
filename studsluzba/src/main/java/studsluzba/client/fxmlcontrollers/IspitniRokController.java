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
import studsluzba.model.SrednjaSkola;
import studsluzba.model.Student;
import studsluzba.model.Studprogram;
import studsluzba.services.IspitService;
import studsluzba.services.IspitniRokService;
import studsluzba.services.SkolskaGodinaService;

@Component
public class IspitniRokController {

	@Autowired
	IspitniRokService ispitniRokService;
	@Autowired
	IspitService ispitService;
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

		List<SkolskaGodina> sveSkolskeGodine = skolskaGodinaService.getSkolskeGodine();
		ObservableList<SkolskaGodina> sveSkolskeGodineObservableList = FXCollections
				.observableArrayList(sveSkolskeGodine);
		cbSkolskaGodina.setItems(sveSkolskeGodineObservableList);

	}

	public void handleOpenModalIspitniRok(ActionEvent ae) {
		mainViewManager.openModal("ispitniRok");
	}

	public void handleOpenModalIspitZaIspitniRok(ActionEvent ae) {
		ispitiZaRok.clear();
		mainViewManager.openModal("ispit");
	}

	public void handleSaveIspitZaIspitniRok(ActionEvent ae) {

		ispitniRokAktivan = lvIspitnihRokova.getSelectionModel().getSelectedItem();
		// !!!!!!!!!!!
		Ispit ispit = ispitService.saveIspit(dpDatumOdrzavanja.getValue(), tfVremePocetka.getText(),
				tfVremeZavrsetka.getText(), cbNastavnik.getSelectionModel().getSelectedItem(),
				cbPredmet.getSelectionModel().getSelectedItem(), ispitniRokAktivan, true);

		ispitiZaRok.add(ispit);
		ispitniRokAktivan.setIspiti(ispitiZaRok);

	}

	public void handleSaveIspitniRok(ActionEvent ae) {
		IspitniRok ir = ispitniRokService.saveIspitniRok(dpDatumPocetka.getValue(), dpDatumZavrsetka.getValue(), null,
				cbSkolskaGodina.getSelectionModel().getSelectedItem());

		ispitniRokovi.add(ir);
		ObservableList<IspitniRok> ispitniRokoviO = FXCollections.observableArrayList(ispitniRokovi);
		lvIspitnihRokova.setItems(ispitniRokoviO);
	}

	public void handlePrikaziIspite(ActionEvent ae) {
		IspitniRok ir = lvIspitnihRokova.getSelectionModel().getSelectedItem();

		if (ir != null) {
			List<Ispit> i = ir.getIspiti();
			if (i != null) {
				ObservableList<Ispit> ispitiO = FXCollections.observableArrayList(i);

				lvIspitaZaIspitniRok.setItems(ispitiO);
			}

		}

	}

	public void handlePrikaziSveIspitneRokove(ActionEvent ae) {

		List<IspitniRok> ir = ispitniRokService.getAll();
		ObservableList<IspitniRok> ispitniRokoviO = FXCollections.observableArrayList(ir);

		lvIspitnihRokova.setItems(ispitniRokoviO);

	}

}
