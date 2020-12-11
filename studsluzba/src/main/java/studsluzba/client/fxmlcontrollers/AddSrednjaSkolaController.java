package studsluzba.client.fxmlcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import studsluzba.model.SrednjaSkola;
import studsluzba.services.SrednjeSkoleService;
import studsluzba.sifarnici.DrzavaGradovi;
import studsluzba.tools.Stored;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;

@Component
public class AddSrednjaSkolaController {
	
	@Autowired
	SrednjeSkoleService srednjeSkoleService;
	
	@Autowired
	StudentController  studentController;

	@FXML TextField nazivNoveSrednjeSkoleTf;
	@FXML ComboBox<String> mestoNoveSrednjeSkoleCb;
	@FXML ComboBox<String> tipNoveSrednjeSkoleCb;
	
	
	
	@FXML public void addSrednjaSkola(ActionEvent event) {
		SrednjaSkola ss = new SrednjaSkola();
		if(mestoNoveSrednjeSkoleCb.getValue()!=null) ss.setMesto(mestoNoveSrednjeSkoleCb.getValue());
		ss.setImeSkole(nazivNoveSrednjeSkoleTf.getText());
		if(tipNoveSrednjeSkoleCb.getValue()!=null) ss.setVrsta(tipNoveSrednjeSkoleCb.getValue());
		srednjeSkoleService.saveSrednjaSkola(ss);		
		studentController.updateSrednjeSkole();
		closeStage(event);		
	}
	
	@FXML
    	public void initialize() {		
		List<String> tipSrednjeSkoleCodes = Stored.getInstance().getSrednjeSkoleList();
		tipNoveSrednjeSkoleCb.setItems(FXCollections.observableArrayList(tipSrednjeSkoleCodes));
		List<String> mestaCodes = Stored.getInstance().getAllGradovi();
		mestoNoveSrednjeSkoleCb.setItems(FXCollections.observableArrayList(mestaCodes));
	}
	
	private void closeStage(ActionEvent event) {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
