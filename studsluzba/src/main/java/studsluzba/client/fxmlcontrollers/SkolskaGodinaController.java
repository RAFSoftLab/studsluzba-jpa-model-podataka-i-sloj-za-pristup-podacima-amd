package studsluzba.client.fxmlcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import studsluzba.model.SkolskaGodina;
import studsluzba.services.SkolskaGodinaService;
import studsluzba.tools.Stored;

@Component
public class SkolskaGodinaController {
	
	@Autowired
	SkolskaGodinaService sgService;
	
	@FXML private Label aktivnaLabel;
	@FXML private TextField novaTf;
	@FXML private ComboBox<SkolskaGodina> aktivnaCb;
	
	@FXML private Label errorNovaLabel;
	@FXML private Label errorAktivnaLabel;
	
	private SkolskaGodina trAktivna;
	
	@FXML
	public void initialize() {
		List<SkolskaGodina> sgs = sgService.getSkolskeGodine();
		aktivnaCb.setItems(FXCollections.observableArrayList(sgs));
		
		SkolskaGodina sg = Stored.getInstance().getAktivnaSkolskaGodina();
		aktivnaLabel.setText("Aktivna godina: " + sg.getGodina());
		trAktivna = sg;
	}
 	
	public void sacuvajNovu(ActionEvent e) {
		String godina = novaTf.getText();
		int god = -1;
		try {
			god = Integer.parseInt(godina);
		} catch (Exception e2) {
			errorNovaLabel.setText("Pogresno ste uneli godinu!");
		}
		if (god > -1) {
			errorNovaLabel.setText("");
			SkolskaGodina sg = new SkolskaGodina();
			sg.setAktivna(false);
			sg.setGodina(godina);
			sgService.saveSkolskaGodina(sg);
			aktivnaCb.getItems().add(sg);
		}
	}
	
	public void sacuvajAktivnu(ActionEvent e) {
		SkolskaGodina ak = aktivnaCb.getValue();
		if (ak == null) {
			errorAktivnaLabel.setText("Niste izabrali novu aktivnu godinu!");
			return;
		}
		else {
			errorAktivnaLabel.setText("");			
		}
		
		aktivnaLabel.setText("Aktivna godina: " + ak.getGodina());
		ak.setAktivna(true);
		Stored.getInstance().setAktivnaSkolskaGodina(ak);
		if (trAktivna != null) {
			trAktivna.setAktivna(false);
			sgService.saveSkolskaGodina(trAktivna);
		}
		sgService.saveSkolskaGodina(ak);
		trAktivna = ak;
		novaTf.setText("");
	}

}
