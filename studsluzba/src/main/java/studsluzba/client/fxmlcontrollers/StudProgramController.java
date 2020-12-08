package studsluzba.client.fxmlcontrollers;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import studsluzba.client.MainViewManager;
import studsluzba.model.Nastavnik;
import studsluzba.model.Studprogram;
import studsluzba.model.VrstaStudija;
import studsluzba.services.StudProgramService;
import studsluzba.services.VrstaStudijaService;

@Component
public class StudProgramController {

	@Autowired
	StudProgramService studProgramService;
	@Autowired
	VrstaStudijaService vss;
	@Autowired
	MainViewManager mainViewManager;

	@FXML private TableView<Studprogram> spTv;
	@FXML private TextField nazivTf;
	@FXML private TextField skraceniNazivTf;
	@FXML private TextField nazivZvanjaTf;
	@FXML private TextField godAkrTf;
	@FXML private TextField trajanjeTf;
	@FXML private ComboBox<VrstaStudija> vrstaStudijaCb;
	@FXML private Label errorL;	
	
	@FXML
	public void initialize() {
		List<VrstaStudija> vs = vss.getVrsteStudija();
		vrstaStudijaCb.setItems(FXCollections.observableArrayList(vs));
		
		List<Studprogram> res = studProgramService.getAllPrograms();
		
		TableColumn<Studprogram,String> nc = new TableColumn<Studprogram,String>("Naziv");
		nc.setCellValueFactory(new PropertyValueFactory("naziv"));
		TableColumn<Studprogram,String> snc = new TableColumn<Studprogram,String>("Skraceni naziv");
		snc.setCellValueFactory(new PropertyValueFactory("skraceniNaziv"));
		TableColumn<Studprogram,String> nzc = new TableColumn<Studprogram,String>("Naziv zvanja");
		nzc.setCellValueFactory(new PropertyValueFactory("nazivZvanja"));
		TableColumn<Studprogram,String> gac = new TableColumn<Studprogram,String>("Godina akr.");
		gac.setCellValueFactory(new PropertyValueFactory("godinaAkreditovanja"));
		TableColumn<Studprogram,String> tsc = new TableColumn<Studprogram,String>("Trajanje sem.");
		tsc.setCellValueFactory(new PropertyValueFactory("semestriTrajanje"));
		TableColumn<Studprogram, VrstaStudija> vsc = new TableColumn<Studprogram, VrstaStudija>("Vrsta studija");
		vsc.setCellValueFactory(new PropertyValueFactory("vrstaStudija"));

		 
		spTv.getColumns().setAll(nc, snc, nzc, gac, tsc, vsc);
		spTv.setItems(FXCollections.observableArrayList(res));
	}
	
//	private static List<Studprogram> sviProgrami = new ArrayList();

	public void handleSaveStudProgram(ActionEvent event) {
		VrstaStudija vs = vrstaStudijaCb.getValue();
		if (vs != null) {
			Year y = Year.parse(godAkrTf.getText());
			Studprogram sp = studProgramService.saveStudProgram(nazivTf.getText(), skraceniNazivTf.getText(), nazivZvanjaTf.getText(), y, Integer.parseInt(trajanjeTf.getText()), vs);			
			if (sp == null) {
				errorL.setText("Neuspesno cuvanje!");
				return;
			}
			errorL.setText("");
			nazivTf.setText("");
			skraceniNazivTf.setText("");
			nazivZvanjaTf.setText("");
			godAkrTf.setText("");
			trajanjeTf.setText("");
			vrstaStudijaCb.setValue(null);
			spTv.getItems().add(sp);
		}
		else {
			errorL.setText("Niste izabrali vrstu studija!");
		}
	}
	
	public void openAddVrstaStudija() {
		mainViewManager.changeRoot("vrstaStudija");
	}


	
}
