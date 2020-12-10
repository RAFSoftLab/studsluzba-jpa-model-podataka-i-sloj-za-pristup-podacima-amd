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
import studsluzba.tools.FXSetter;
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
		if (sg != null)
			aktivnaLabel.setText("Aktivna godina: " + sg.getGodina());
		trAktivna = sg;
	}
 	
	public void sacuvajNovu(ActionEvent e) {
		String godina = novaTf.getText();
		int g1 = -1, g2 = -1;
		try {
			String[] split = godina.split("/");
			g1 = Integer.parseInt(split[0]);
			g2 = Integer.parseInt(split[1]);
		} catch (Exception e2) {
			errorNovaLabel.setText("Pogresno ste uneli godinu!");
		}
		if (g1 > -1 && g2 > -1) {
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
		
		aktivnaLabel.setText("Aktivna godina: " + ak.getGodina());
		ak.setAktivna(true);
		Stored.getInstance().setAktivnaSkolskaGodina(ak);
		if (trAktivna != null) {
			trAktivna.setAktivna(false);
			sgService.saveSkolskaGodina(trAktivna);
		}
		sgService.saveSkolskaGodina(ak);
		trAktivna = ak;
		FXSetter.emptyElements(novaTf, errorAktivnaLabel);
	}

}
