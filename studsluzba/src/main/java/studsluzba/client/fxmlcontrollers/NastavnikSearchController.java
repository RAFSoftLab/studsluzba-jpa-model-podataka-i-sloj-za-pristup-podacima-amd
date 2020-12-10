package studsluzba.client.fxmlcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import studsluzba.client.MainViewManager;
import studsluzba.model.Nastavnik;
import studsluzba.services.NastavnikService;
import studsluzba.tools.FXSetter;

@Component
public class NastavnikSearchController {

	@Autowired
	NastavnikService nastavnikService;
	@Autowired
	MainViewManager mainViewManager;
	
	private List<Nastavnik> res;
	private List<Nastavnik> empty = new ArrayList<Nastavnik>(); //sluzi mi za praznjenje tabele
	
	@FXML private TextField imeTf;
	@FXML private TextField prezimeTf;
	@FXML private TextField srednjeImeTf;
	@FXML private TextField obrazovanjeTf;
	@FXML private TextField emailTf;

	@FXML private TableView<Nastavnik> nastavnikTv;
	
	@FXML
	public void initialize() {
		res = nastavnikService.findAll();
		TableColumn<Nastavnik,String> imeCol = new TableColumn<Nastavnik,String>("Ime");
		imeCol.setCellValueFactory(new PropertyValueFactory("ime"));
		TableColumn<Nastavnik,String> prezimeCol = new TableColumn<Nastavnik,String>("Prezime");
		prezimeCol.setCellValueFactory(new PropertyValueFactory("prezime"));
		TableColumn<Nastavnik,String> siCol = new TableColumn<Nastavnik,String>("Srednje ime");
		siCol.setCellValueFactory(new PropertyValueFactory("srednjeIme"));
		TableColumn<Nastavnik,String> obrCol = new TableColumn<Nastavnik,String>("Obrazovanje");
		obrCol.setCellValueFactory(new PropertyValueFactory("obrazovanje"));
		TableColumn<Nastavnik,String> mailCol = new TableColumn<Nastavnik,String>("E-mail");
		mailCol.setCellValueFactory(new PropertyValueFactory("email"));
		 
		nastavnikTv.getColumns().setAll(imeCol, prezimeCol, siCol, obrCol, mailCol);
		nastavnikTv.setItems(FXCollections.observableArrayList(res));
	}
	
	
	public void prikaziSve(ActionEvent e) {
		res = nastavnikService.findAll();
		nastavnikTv.setItems(FXCollections.observableArrayList(res));
	}
	
	public void traziNastavnike(ActionEvent e) {
		String ime, prezime, srednje, obrazovanje, email;
		ime = imeTf.getText();
		prezime = prezimeTf.getText();
		srednje = srednjeImeTf.getText();
		obrazovanje = obrazovanjeTf.getText();
		email = emailTf.getText();
		
		if (ime.isEmpty() && prezime.isEmpty() && srednje.isEmpty() && obrazovanje.isEmpty() && email.isEmpty()) {
			FXSetter.emptyElements(nastavnikTv);
			return;
		}
		
		List<Nastavnik> result = nastavnikService.findNastavnici(ime, prezime, srednje, obrazovanje, email);
		if (result != null && !result.isEmpty()) {
			System.out.println(result.size());
			nastavnikTv.setItems(FXCollections.observableArrayList(result));
		}
		else {
			FXSetter.emptyElements(nastavnikTv);
		}
		FXSetter.emptyElements(imeTf, prezimeTf, srednjeImeTf, obrazovanjeTf, emailTf);
	}
	
	public void openNastavnikInfo(ActionEvent e) {
		List<Object> params = new ArrayList<Object>();
		Nastavnik n = nastavnikTv.getSelectionModel().getSelectedItem();
		if (n != null)
			params.add(n);
		MainViewManager.setParameters(params);
		mainViewManager.changeRoot("nastavnikInfo");
	}
	
}
