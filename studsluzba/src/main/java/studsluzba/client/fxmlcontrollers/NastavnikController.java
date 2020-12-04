package studsluzba.client.fxmlcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import studsluzba.model.Nastavnik;
import studsluzba.model.NastavnikZvanja;
import studsluzba.model.Zvanje;
import studsluzba.services.NastavnikService;
import studsluzba.services.ZvanjaService;

@Component
public class NastavnikController {
	
	@Autowired
	NastavnikService nastavnikService;
	@Autowired
	ZvanjaService zvanjaService;
	
	private List<Zvanje> svaZvanja = new ArrayList<Zvanje>();
	private List<Zvanje> izabranaZvanja = new ArrayList<Zvanje>();
	
//	VALIDACIJE ZA TF DA DODAM??
	
	@FXML private TextField imeTf;
	@FXML private TextField prezimeTf;
	@FXML private TextField srednjeImeTf;
	@FXML private TextField obrazovanjeTf;
	@FXML private TextField emailTf;
	@FXML private TextField zvanjaTf;
	@FXML private Label errorL;

	@FXML private VBox zvanjaContainer;

	//dugme da se poniste zvanja
	
	@FXML
	public void initialize() {
		svaZvanja = zvanjaService.getZvanja();
		
		for (Zvanje z : svaZvanja) {
			CheckBox cx = new CheckBox(z.getNaziv());
			cx.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					if (cx.isSelected())
						izabranaZvanja.add(z);
					else
						izabranaZvanja.remove(z);
				}
			});
			zvanjaContainer.getChildren().add(cx);
		}
		
	}

	
	public void saveNastavnik(ActionEvent event) {
		Nastavnik n = new Nastavnik();
		n.setIme(imeTf.getText());
		n.setPrezime(prezimeTf.getText());
		n.setSrednjeIme(srednjeImeTf.getText());
		n.setEmail(emailTf.getText());
		n.setObrazovanje(obrazovanjeTf.getText());
		if (imeTf.getText().isEmpty() || prezimeTf.getText().isEmpty() || emailTf.getText().isEmpty() || obrazovanjeTf.getText().isEmpty() || izabranaZvanja.isEmpty()) {
			errorL.setText("Sva polja osim \"Srednje ime\" moraju biti popunjena!");
			return;
		}
		Nastavnik ret = nastavnikService.saveNastavnik(n);
		if (ret != null) {
			boolean flag = false;
			List<NastavnikZvanja> temp = new ArrayList<NastavnikZvanja>();
			for (Zvanje z : izabranaZvanja) {
				NastavnikZvanja nz = new NastavnikZvanja(n, z);
				temp.add(nz);
				if (nastavnikService.saveNastavnikZvanja(nz) == null) {
					flag = true;
				}
			}
			if (flag) {
				for (NastavnikZvanja nz : temp) {
					nastavnikService.deleteNastavnikZvanja(nz);
				}
				errorL.setText("Neuspesno dodavanje, pokusajte ponovo.");
				return;
			}
			imeTf.setText("");
			prezimeTf.setText("");
			srednjeImeTf.setText("");
			emailTf.setText("");
			obrazovanjeTf.setText("");
			for (Object c : zvanjaContainer.getChildren()) {
				((CheckBox)c).setSelected(false);
			}
		}
		else {
			errorL.setText("Neuspesno dodavanje, pokusajte ponovo.");
		}
	}
	
}