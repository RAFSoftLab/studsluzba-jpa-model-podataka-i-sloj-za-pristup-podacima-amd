package studsluzba.client.fxmlcontrollers;

import java.awt.desktop.PrintFilesEvent;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import studsluzba.client.MainViewManager;
import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.IzlazakNaIspit;
import studsluzba.model.Nastavnik;
import studsluzba.model.PredispitnaObaveza;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.Student;
import studsluzba.model.StudentPredispitneObaveze;
import studsluzba.repositories.IspitRepository;
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
	IspitRepository ispitRepo;
	@Autowired
	MainViewManager mainViewManager;
	@FXML
	private Button btnPrikaziIspite;
	@FXML
	private Button btnRezultati;
	@FXML
	private Button btnStudenti;
	@FXML
	ListView<IspitniRok> lvIspitnihRokova;
	@FXML
	ListView<Ispit> lvIspitaZaIspitniRok;
	@FXML
	ListView<Student> lvStudentiZaIspit;

//REZULTATI
	@FXML
	private Label lblRezultati;
	@FXML
	private TableView<Object> tvRezultati = new TableView();
	@FXML
	private TableColumn tcIme = new TableColumn();
	@FXML
	private TableColumn tcPrezime = new TableColumn();
	@FXML
	private TableColumn tcPredispitne = new TableColumn();
	@FXML
	private TableColumn tcIspit = new TableColumn();
	@FXML
	private TableColumn tcPoeni = new TableColumn();
	@FXML
	private TableColumn tcOcena = new TableColumn();
	@FXML
	private TableColumn tcNapomena = new TableColumn();

	private Ispit ispitAktivan;
	private IspitniRok ispitniRokAktivan;
	private List<Ispit> ispitiZaRok = new ArrayList<Ispit>();
	private List<IspitniRok> ispitniRokovi = new ArrayList<IspitniRok>();
	private ObservableList<Object> data = FXCollections.observableArrayList();

	@FXML
	public void initialize() {

		List<IspitniRok> ir = ispitniRokService.getAll();
		ObservableList<IspitniRok> ispitniRokoviO = FXCollections.observableArrayList(ir);

		lvIspitnihRokova.setItems(ispitniRokoviO);

	}

	public void handleOpenModaStudentiZaIspit(ActionEvent ae) {
		ispitAktivan = lvIspitaZaIspitniRok.getSelectionModel().getSelectedItem();

		if (ispitAktivan != null) {
			List<Student> s = ispitRepo.findPrijavljeni(ispitAktivan.getIdIspit());
			if (!(s.isEmpty())) {
				ObservableList<Student> studentiO = FXCollections.observableArrayList(s);

				lvStudentiZaIspit.setItems(studentiO);
			}

		}

		mainViewManager.openModal("studentiZaIspit");

	}

	public void handleOpenModalIspitZaIspitniRok(ActionEvent ae) {

		ispitAktivan = lvIspitaZaIspitniRok.getSelectionModel().getSelectedItem();

		if (ispitAktivan != null) {
			mainViewManager.openModal("studentiZaIspit");

		}
	}

	public void handleOpenModalRezultati(ActionEvent ae) {

		ispitAktivan = lvIspitaZaIspitniRok.getSelectionModel().getSelectedItem();

		if (ispitAktivan != null) {
			List<Object> s = ispitRepo.findRezultatiIspita(ispitAktivan.getIdIspit());

			for (Object st : s) {
				System.out.println(st);
			}

			tcIme.setCellValueFactory(new PropertyValueFactory<Student, String>("ime"));
			tcPrezime.setCellValueFactory(new PropertyValueFactory<Student, String>("prezime"));
			tcPredispitne.setCellValueFactory(new PropertyValueFactory<StudentPredispitneObaveze, Double>("poeni"));
			tcIspit.setCellValueFactory(new PropertyValueFactory<Ispit, String>("datumOdrzavanja" + "vremePocetka"+ "vremeZavrsetka"));
			tcPoeni.setCellValueFactory(new PropertyValueFactory<IzlazakNaIspit, Double>("brPoena"));
			tcOcena.setCellValueFactory(new PropertyValueFactory<IzlazakNaIspit, Integer>("ocena"));
			tcNapomena.setCellValueFactory(new PropertyValueFactory<IzlazakNaIspit, String>("napomena"));

			data.clear();
			data.addAll(s);

			tvRezultati.setItems(data);

			mainViewManager.openModal("rezultati");

		}
	}

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
