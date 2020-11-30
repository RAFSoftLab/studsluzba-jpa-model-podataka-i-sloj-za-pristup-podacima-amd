package studsluzba.client.fxmlcontrollers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import studsluzba.client.MainViewManager;

@Component
public class MenuBarController { 
	
	 
	@Autowired
	MainViewManager mainViewManager;
	
		
	@FXML
	private MenuBar menuBar;
	
	
	public void openStudProgrami(ActionEvent event) {
		mainViewManager.changeRoot("studProgrami");
	}
	
	public void openNewStudent(ActionEvent event) {
		mainViewManager.changeRoot("newStudent");
	}
	
	
	
	


	

	
		
}
