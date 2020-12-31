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
	
	public void openNewNastavnik(ActionEvent event) {
		mainViewManager.changeRoot("newNastavnik");
	}
	
	public void openSkolskaGodina(ActionEvent event) {
		mainViewManager.changeRoot("skolskaGodina");
	}
	
	public void openZvanja(ActionEvent event) {
		mainViewManager.changeRoot("zvanja");
	}
	
	public void openPregledNastavnika(ActionEvent event) {
		mainViewManager.changeRoot("nastavnikSearch");
	}
	
	public void openFindStudent(ActionEvent event) {
		mainViewManager.changeRoot("findStudent");
	}
	
	public void openNewIspitniRok(ActionEvent event) {
		mainViewManager.changeRoot("ispitIspitRok");
	}
	
	public void openPrikazStudenata(ActionEvent event) {
		mainViewManager.changeRoot("prikazPrijavljenihStudenataZaIspit");
	}

	public void openNewPredmet(ActionEvent event) {
		mainViewManager.changeRoot("newPredmet");
	}
	
	public void openPregledPredmeta(ActionEvent event) {
		mainViewManager.changeRoot("predmetSearch");
	}
	
	public void openSifarnici(ActionEvent event) {
		mainViewManager.changeRoot("sifarnici");
	}
	
	public void openImport(ActionEvent ecent) {		
		mainViewManager.changeRoot("importData");
	}
	
	public void openIzvestajiIspit(ActionEvent ecent) {		
		mainViewManager.changeRoot("generisanjeIspita");
	}
		
}
