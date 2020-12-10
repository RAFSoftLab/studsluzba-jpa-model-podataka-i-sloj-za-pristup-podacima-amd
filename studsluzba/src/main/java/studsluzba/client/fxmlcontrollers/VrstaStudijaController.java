package studsluzba.client.fxmlcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import studsluzba.client.MainViewManager;
import studsluzba.model.VrstaStudija;
import studsluzba.services.VrstaStudijaService;
import studsluzba.tools.FXSetter;

@Component
public class VrstaStudijaController {

	@Autowired
	MainViewManager mainViewManager;
	@Autowired
	VrstaStudijaService vss;
	
	@FXML private TextField punTf;
	@FXML private TextField skrTf;
	@FXML private Label errorL; 
	
	public void sacuvaj() {
		if (punTf.getText().isEmpty() || skrTf.getText().isEmpty()) {
			errorL.setText("Sva polja moraju biti popunjena!");
			return;
		}
		VrstaStudija vs = vss.save(new VrstaStudija(punTf.getText(), skrTf.getText()));
		if (vs == null) {
			errorL.setText("Greska u cuvanju!");
			return;
		}
		FXSetter.emptyElements(punTf, skrTf, errorL);
	}
	
	public void nazad() {
		mainViewManager.changeRoot("studProgrami");
	}
}
