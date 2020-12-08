package studsluzba.client.fxmlcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import studsluzba.services.SkolskaGodinaService;
import studsluzba.tools.Stored;

@Component
public class MainWindowController {
	
	@Autowired
	SkolskaGodinaService sgService;
	
	@FXML
	public void initialize() {
		Stored.getInstance().setAktivnaSkolskaGodina(sgService.getAktivna());
	}

}
