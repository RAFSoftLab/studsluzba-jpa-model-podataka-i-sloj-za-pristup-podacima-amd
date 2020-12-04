package studsluzba.client.fxmlcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import studsluzba.model.Zvanje;
import studsluzba.services.ZvanjaService;

@Component
public class ZvanjaController {
	
	private List<Zvanje> svaZvanja;
	
	@Autowired
	ZvanjaService zvanjaService;
	
	@FXML private ComboBox<Zvanje> zvanjaCb;
	@FXML private TextField nazivTf;
	@FXML private DatePicker datumIzboraDp;
	@FXML private TextField uzaNaucnaOblastTf; 
	@FXML private Button sacuvajB;
	@FXML private Label errorL;
	
	@FXML
	public void initialize() {
		svaZvanja = zvanjaService.getZvanja();
		zvanjaCb.getItems().addAll(svaZvanja);
	}
	
	public void saveZvanje(ActionEvent e) {
		if (!nazivTf.getText().isEmpty() && datumIzboraDp.getValue() != null && !uzaNaucnaOblastTf.getText().isEmpty()) {
			
			Zvanje z = new Zvanje();
			z.setNaziv(nazivTf.getText());
			z.setDatumIzbora(datumIzboraDp.getValue());
			z.setUzaNaucnaOblast(uzaNaucnaOblastTf.getText());
			
			Zvanje ret = zvanjaService.saveZvanje(z);
			if (ret != null) {
				nazivTf.setText("");
				datumIzboraDp.setValue(null);
				uzaNaucnaOblastTf.setText("");
				errorL.setText("");
				zvanjaCb.getItems().add(z);
			}
			else errorL.setText("Neuspesno cuvanje!");
		}
		else {
			errorL.setText("Sva polja moraju biti popunjena!");
		}
	}
}
