package studsluzba.client.fxmlcontrollers;

import java.awt.Button;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import studsluzba.client.MainViewManager;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.PredmetStudprogram;
import studsluzba.model.Studprogram;
import studsluzba.services.PredmetService;
import studsluzba.services.PredmetStudprogramService;
import studsluzba.services.StudProgramService;
import studsluzba.tools.CustomValidator;

@Component
public class PredmetSearchController {
	
	@Autowired
	PredmetService predmetService;
	@Autowired
	StudProgramService spService;
	@Autowired
	PredmetStudprogramService pspService;
	
	@FXML private TableView<Predmet> pTv;
	@FXML private ListView<Studprogram> spList;
	@FXML private Label errorL;
	@FXML private TextField nazivPredmetTf;
	@FXML private Label predmetL;
	@FXML private Label spLabel;
	
	@FXML
	public void initialize() {
		List<Studprogram> splist = spService.getAllPrograms();
		spList.setItems(FXCollections.observableArrayList(splist));
		
		TableColumn<Predmet,String> sc = new TableColumn<Predmet,String>("Sifra");
		sc.setCellValueFactory(new PropertyValueFactory("sifra"));
		TableColumn<Predmet,String> nc = new TableColumn<Predmet,String>("Naziv");
		nc.setCellValueFactory(new PropertyValueFactory("naziv"));
		TableColumn<Predmet,String> ec = new TableColumn<Predmet,String>("ESPB");
		ec.setCellValueFactory(new PropertyValueFactory("espb"));
		TableColumn<Predmet,String> semc = new TableColumn<Predmet,String>("Semestar");
		semc.setCellValueFactory(new PropertyValueFactory("semestar"));
		TableColumn<Predmet,String> fpc = new TableColumn<Predmet,String>("Fond predavanja");
		fpc.setCellValueFactory(new PropertyValueFactory("fondCasovaPredavanja"));
		TableColumn<Predmet,String> fvc = new TableColumn<Predmet,String>("Fond vezbe");
		fvc.setCellValueFactory(new PropertyValueFactory("fondCasovaVezbi"));
		TableColumn<Predmet,String> oc = new TableColumn<Predmet,String>("Opis");
		oc.setCellValueFactory(new PropertyValueFactory("opis"));
		
		pTv.getColumns().setAll(sc, nc, ec, semc, fpc, fvc, oc);
		
		pTv.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				Predmet p = pTv.getSelectionModel().getSelectedItem();
				if (p != null) {
					List<Studprogram> sps = pspService.findByPredmet(p);
					String s = "";
					for (Studprogram x : sps) {
						s += x.getNaziv() + ", ";
					}
					s = s.substring(0, s.length() - 2);
					spLabel.setText(s);					
				}
			};
		});
		
		if(MainViewManager.getParameters() == null || MainViewManager.getParameters().isEmpty()) {
			return;
		}
		else {
			if (MainViewManager.getParameters().get(0) instanceof Predmet) {
				List<Predmet> p = new ArrayList<Predmet>();
				Predmet predmet = (Predmet) MainViewManager.getParameters().get(0);
				p.add(predmet);
				pTv.setItems(FXCollections.observableArrayList(p));
				List<Studprogram> sps = pspService.findByPredmet(predmet);
				String s = "";
				for (Studprogram x : sps) {
					s += x.getNaziv() + ", ";
				}
				s = s.substring(0, s.length() - 2);
				spLabel.setText(s);
			}
		}
	}
	
	public void prikaziIzabrano() {
		Studprogram sp = spList.getSelectionModel().getSelectedItem();
		if (sp != null) {
			List<Predmet> p = pspService.findBySP(sp);
			pTv.setItems(FXCollections.observableArrayList(p));
			predmetL.setText("Predmeti: " + sp.getNaziv());			
			errorL.setText("");
		}
		else {
			//sp null
			errorL.setText("Niste izabrali nijedan studijski program!");
		}
		
	}
	
	public void prikaziSve() {
		List<Predmet> list = predmetService.findAll();
		pTv.setItems(FXCollections.observableArrayList(list));
		predmetL.setText("Predmeti: svi");
	}

	public void pretraziPredmet() {
		if (!nazivPredmetTf.getText().isEmpty()) {
			List<Predmet> p = predmetService.findByNazivOrSifra(nazivPredmetTf.getText());			
			pTv.setItems(FXCollections.observableArrayList(p));
			errorL.setText("");
		}
		else {
			errorL.setText("Tekst polje je prazno!");
		}
	}
	
}
