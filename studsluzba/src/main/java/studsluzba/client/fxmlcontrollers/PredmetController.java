package studsluzba.client.fxmlcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import studsluzba.model.Predmet;
import studsluzba.model.PredmetStudprogram;
import studsluzba.model.Studprogram;
import studsluzba.services.PredmetService;
import studsluzba.services.PredmetStudprogramService;
import studsluzba.services.StudProgramService;
import studsluzba.tools.CustomValidator;
import studsluzba.tools.FXSetter;

@Component
public class PredmetController {

	@Autowired
	PredmetService predmetService;
	@Autowired
	StudProgramService spService;
	@Autowired
	PredmetStudprogramService pspService;
	
	private List<Predmet> svi;
	
	@FXML private TextField nazivTf;
	@FXML private TextField espbTf;
	@FXML private TextField fcpTf;
	@FXML private TextField fcvTf;
	@FXML private TextField semestarTf;
	@FXML private TextField sifraTf;
	@FXML private TextField opisTf;
	@FXML private VBox spContainer;
	@FXML private Label errorL;
	
	private List<Studprogram> izabraniSP = new ArrayList<Studprogram>();
	
	@FXML
	public void initialize() {
		List<Studprogram> sp = spService.getAllPrograms();
		
		svi = predmetService.findAll();
		
		for (Studprogram s : sp) {
			CheckBox cx = new CheckBox(s.getNaziv());
			cx.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					if (cx.isSelected())
						izabraniSP.add(s);
					else
						izabraniSP.remove(s);
				}
			});
			spContainer.getChildren().add(cx);
		}
	}
	
	public void savePredmet() {
		 String naziv = nazivTf.getText();
		 int espb = Integer.parseInt(espbTf.getText());
		 int fcp = Integer.parseInt(fcpTf.getText());
		 int fcv = Integer.parseInt(fcvTf.getText());
		 int sem = Integer.parseInt(semestarTf.getText());
		 String sifra = sifraTf.getText();
		 String opis = opisTf.getText();
		 Predmet p = new Predmet(sifra, naziv, opis, espb, sem, fcp, fcv);
		 
		 if (svi.contains(p)) {
			 errorL.setText("Ovaj predmet vec postoji!");
			 return;
		 }
		 
		 if (CustomValidator.emptyOrNull(naziv, espb, fcp, fcv, sem, sifra, opis)) {
			 errorL.setText("Sva polja moraju biti popunjena!");
			 return;
		 }
		 
		 p = predmetService.savePredmet(p);
		 if (p != null) {
			 boolean flag = false;
			 List<PredmetStudprogram> temp = new ArrayList<PredmetStudprogram>();
			 for (Studprogram sp : izabraniSP) {
				 PredmetStudprogram psp = new PredmetStudprogram(p, sp);
				 temp.add(psp);
				 if (pspService.save(psp) == null) {
					 // psp error
					 flag = true;
				 }				
			 }
			 if (flag) {
				// psp error
				 for (PredmetStudprogram psp : temp) {
					 pspService.delete(psp);
				 }
				 predmetService.deletePredmet(p);
				 errorL.setText("Greska kod cuvanja studijskog programa za dati predmet. Predmet nece biti sacuvan!");
				 return;
			 }
			 FXSetter.emptyElements(errorL, nazivTf, espbTf, fcpTf, fcvTf, opisTf, semestarTf, sifraTf, spContainer.getChildren().toArray());
		 }
		 else {
			 //save error
			 errorL.setText("Neuspesno dodavanje, pokusajte ponovo!");
		 }
		 		 
	}
	
}
