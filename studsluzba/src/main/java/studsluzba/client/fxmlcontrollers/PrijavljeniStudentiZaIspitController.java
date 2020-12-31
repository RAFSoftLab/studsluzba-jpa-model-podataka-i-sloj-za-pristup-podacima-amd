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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import studsluzba.client.MainViewManager;
import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.StudIndex;
import studsluzba.model.Student;
import studsluzba.services.IspitService;
import studsluzba.services.IspitniRokService;
import studsluzba.services.SkolskaGodinaService;
import studsluzba.services.StudentService;
import studsluzba.tools.RezultatiClass;

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
	ListView<Student> lvStudentiZaIspit;
	@FXML
	Label lblIspit;
	@FXML
	Label lblRezultati;
	@FXML private TableView<RezultatiClass> tvRezultati;
	@FXML private TableColumn<RezultatiClass, StudIndex> tcindex;
	@FXML private TableColumn<RezultatiClass, String> tcime;
	@FXML private TableColumn<RezultatiClass, String> tcprezime;
	@FXML private TableColumn<RezultatiClass, Double> tcpoeni;
	@FXML private TableColumn<RezultatiClass, Integer> tcocena;

	Ispit ispitAktivan;
	IspitniRok ispitniRokAktivan;
	List<Ispit> ispitiZaRok = new ArrayList<Ispit>();
	List<IspitniRok> ispitniRokovi = new ArrayList<IspitniRok>();

	@FXML
	public void initialize() {
		
		List<IspitniRok> ir = ispitniRokService.getAll();
		ObservableList<IspitniRok> ispitniRokoviO = FXCollections.observableArrayList(ir);
		lvIspitnihRokova.setItems(ispitniRokoviO);

	}

	public void handleOpenModalStudentiZaIspit(ActionEvent ae) {
		ispitAktivan = lvIspitaZaIspitniRok.getSelectionModel().getSelectedItem();

		mainViewManager.openModalNoWait("studentiZaIspit");
		
		lblIspit.setText("Prijavljeni studenti za ispit: " + ispitAktivan.toString());
		List<Student> prijavljeniZaIspit = ispitService.findStudentiByIspit(ispitAktivan);
		lvStudentiZaIspit.setItems(FXCollections.observableArrayList(prijavljeniZaIspit));
		
	}
	
	public void handleOpenModalRezultatiZaIspit(ActionEvent ae) {
		ispitAktivan = lvIspitaZaIspitniRok.getSelectionModel().getSelectedItem();
		if (ispitAktivan == null)
			return;
		
		mainViewManager.openModalNoWait("rezultati");
		lblRezultati.setText("Rezultati ispita: " + ispitAktivan.toString());
		
		List<Object[]> rez = ispitService.findfindRezultatiIspitaPoIspitu(ispitAktivan);
		
		List<RezultatiClass> svi = new ArrayList<RezultatiClass>();
		for (Object[] os : rez) {
			RezultatiClass rc = new RezultatiClass((StudIndex)os[0], (String)os[1], (String)os[2], (double)os[3], (int)os[4]);
			svi.add(rc);
		}
		
		tcindex.setCellValueFactory(new PropertyValueFactory<RezultatiClass, StudIndex>("si"));
		tcime.setCellValueFactory(new PropertyValueFactory<RezultatiClass, String>("ime"));
		tcprezime.setCellValueFactory(new PropertyValueFactory<RezultatiClass, String>("prezime"));
		tcpoeni.setCellValueFactory(new PropertyValueFactory<RezultatiClass, Double>("poeni"));
		tcocena.setCellValueFactory(new PropertyValueFactory<RezultatiClass, Integer>("ocena"));

		tvRezultati.getColumns().setAll(tcindex, tcime, tcprezime, tcpoeni, tcocena);

		tvRezultati.setItems(FXCollections.observableArrayList(svi));
		
		
	}

	public void handleOpenModalIspitZaIspitniRok(ActionEvent ae) {
		
		ispitAktivan = lvIspitaZaIspitniRok.getSelectionModel().getSelectedItem();
		
		if(ispitAktivan!=null) {
			mainViewManager.openModal("studentiZaIspit");
			
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
