package studsluzba.client.fxmlcontrollers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import studsluzba.client.MainViewManager;
import studsluzba.model.DrziPredmet;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.Zvanje;
import studsluzba.services.DrziPredmetService;
import studsluzba.services.NastavnikService;
import studsluzba.services.NastavnikZvanjaService;
import studsluzba.services.PredmetService;
import studsluzba.services.SkolskaGodinaService;
import studsluzba.tools.CustomValidator;

@Component
public class NastavnikInfoController {
	
	@Autowired
	MainViewManager mainViewManager;
	
	@Autowired
	NastavnikService nastavnikService;
	@Autowired
	PredmetService predmetService;
	@Autowired
	DrziPredmetService dpService;
	@Autowired
	SkolskaGodinaService sgService;
	@Autowired
	NastavnikZvanjaService nzService;
	
	@FXML private Label nL;
	@FXML private TableView<Zvanje> zvanjaTv;
	@FXML private TableView<DrziPredmet> psgTv;
	@FXML private ComboBox<Predmet> predmetList;
	@FXML private ComboBox<SkolskaGodina> sgCb;
	@FXML private TextField predmetTf;
	
	private List<Object> passed;
	private Nastavnik nastavnik;
	private List<DrziPredmet> nastavnikPredmeti;
	
	@FXML
	public void initialize() {
		passed = MainViewManager.getParameters();
		if (passed != null) {
			Alert a = new Alert(AlertType.ERROR, "Neuspesno ocitavanje informacija o nastavniku ili niste izabrali nastavnika!", ButtonType.CLOSE);
			a.show();
			a.setOnCloseRequest(new EventHandler<DialogEvent>() {
				@Override
				public void handle(DialogEvent event) {					
					mainViewManager.changeRoot("nastavnikSearch");
				}
			});
			return;
		}
		nastavnik = (Nastavnik) passed.get(0);
		nL.setText("Informacije o nastavniku: " + nastavnik.getIme() + " " + nastavnik.getPrezime());
		
		TableColumn<Zvanje,String> nc = new TableColumn<Zvanje,String>("Naziv");
		nc.setCellValueFactory(new PropertyValueFactory("naziv"));
		TableColumn<Zvanje,LocalDate> dic = new TableColumn<Zvanje, LocalDate>("Datum izbora");
		dic.setCellValueFactory(new PropertyValueFactory("datumIzbora"));
		TableColumn<Zvanje,String> unoc = new TableColumn<Zvanje,String>("Uza naucna oblast");
		unoc.setCellValueFactory(new PropertyValueFactory("uzaNaucnaOblast"));
		 
		zvanjaTv.getColumns().setAll(nc, dic, unoc);
		populateZvanja();
		
		TableColumn<DrziPredmet, Predmet> pc = new TableColumn<DrziPredmet,Predmet>("Predmet");
		pc.setCellValueFactory(new PropertyValueFactory("predmet"));
		TableColumn<DrziPredmet, SkolskaGodina> sgc = new TableColumn<DrziPredmet, SkolskaGodina>("Skolska godina");
		sgc.setCellValueFactory(new PropertyValueFactory("sg"));
		 
		psgTv.getColumns().setAll(pc, sgc);
		populateDrziPredmet();
		
		List<Predmet> predmeti = predmetService.findAll();
		predmetList.setItems(FXCollections.observableArrayList(predmeti));
		
		List<SkolskaGodina> sg = sgService.getSkolskeGodine();
		sgCb.setItems(FXCollections.observableArrayList(sg)); 
		
		predmetTf.textProperty().addListener((obs, oldVal, newVal) -> {
			if (newVal.isEmpty())
				predmetList.setItems(FXCollections.observableArrayList(predmetService.findAll()));
			else 
				predmetList.setItems(FXCollections.observableArrayList(predmetService.findByNazivOrSifra(newVal)));
		});
		
		nastavnikPredmeti = dpService.findInfoByNastavnik(nastavnik);
	}
	
	private void populateZvanja(){
		List<Zvanje> zvanja = nzService.findZvanjaByNastavnik(nastavnik);
		zvanjaTv.setItems(FXCollections.observableArrayList(zvanja));
	}
	
	private void populateDrziPredmet() {
		List<DrziPredmet> dp = dpService.findInfoByNastavnik(nastavnik);
		psgTv.setItems(FXCollections.observableArrayList(dp));
	}
	
	public void backToNastavnik(ActionEvent e) {
		MainViewManager.setParameters(null);
		mainViewManager.changeRoot("nastavnikSearch");
	}

	
	public void dodajPredmetNastavniku() {
		Predmet p = predmetList.getValue();
		SkolskaGodina sg = sgCb.getValue();
		if (!CustomValidator.emptyOrNull(p,sg)) {
			DrziPredmet dp = new DrziPredmet(sg, p, nastavnik);
			if (nastavnikPredmeti.contains(dp)) {
				Alert a = new Alert(AlertType.ERROR, "Nastavnik vec drzi ovaj predmet u ovoj skolskoj godini!", ButtonType.CLOSE);
				a.show();
				return;
			}
			if (dpService.save(dp) == null) {
				//save error
				nastavnikPredmeti.add(dp);
				Alert a = new Alert(AlertType.ERROR, "Neuspesno dodavanje predmeta nastavniku!", ButtonType.CLOSE);
				a.show();
			} else {
				sgCb.setValue(null);
				psgTv.getItems().add(dp);
			}
		}
		else {
			//empty error
			Alert a = new Alert(AlertType.ERROR, "Niste izabrali skolsku godinu ili predmet!", ButtonType.CLOSE);
			a.show();
		}
	}

}
