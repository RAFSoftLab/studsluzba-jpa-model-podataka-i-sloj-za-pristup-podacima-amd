package studsluzba.client.fxmlcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import studsluzba.model.Studprogram;
import studsluzba.services.StudProgramService;

@Component
public class StudProgramController {

	@Autowired
	StudProgramService studProgramService;

	@FXML
	private TextField nazivTf;
	@FXML
	private TextField skraceniNazivTf;

	private static List<Studprogram> sviProgrami = new ArrayList();

	public void handleSaveStudProgram(ActionEvent event) {
		Studprogram sp = studProgramService.saveStudProgram(nazivTf.getText(), skraceniNazivTf.getText());
		sviProgrami.add(sp);
	}

	public static List<Studprogram> getSviProgrami() {
		return sviProgrami;
	}


	
}
