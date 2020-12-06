package studsluzba.client.fxmlcontrollers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import studsluzba.client.MainViewManager;
import studsluzba.model.DrziPredmet;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.Zvanje;
import studsluzba.services.NastavnikService;

@Component
public class NastavnikInfoController {
	
	@Autowired
	MainViewManager mainViewManager;
	
	@Autowired
	NastavnikService nastavnikService;
	
	@FXML private Label nL;
	@FXML private TableView<Zvanje> zvanjaTv;
	@FXML private TableView<DrziPredmet> psgTv;
	
	private List<Object> passed;
	private Nastavnik nastavnik;
	
	@FXML
	public void initialize() {
		passed = MainViewManager.getParameters();
		if (passed == null || passed.isEmpty()) {
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
	}
	
	private void populateZvanja(){
		List<Zvanje> zvanja = nastavnikService.findZvanjaByNastavnik(nastavnik);
		zvanjaTv.setItems(FXCollections.observableArrayList(zvanja));
	}
	
	private void populateDrziPredmet() {
		List<DrziPredmet> dp = nastavnikService.findInfoByNastavnik(nastavnik);
		for (DrziPredmet d : dp) {
			System.out.println(d.getPredmet().getNaziv());
			System.out.println(d.getSg().getGodina());
		}
		psgTv.setItems(FXCollections.observableArrayList(dp));
	}
	
	public void backToNastavnik(ActionEvent e) {
		MainViewManager.setParameters(null);
		mainViewManager.changeRoot("nastavnikSearch");
	}

}
