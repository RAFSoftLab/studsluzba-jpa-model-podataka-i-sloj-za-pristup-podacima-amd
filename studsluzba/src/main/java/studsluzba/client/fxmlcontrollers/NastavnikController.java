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
import studsluzba.services.NastavnikZvanjaService;
import studsluzba.services.ZvanjaService;
import studsluzba.tools.CustomValidator;
import studsluzba.tools.FXSetter;

@Component
public class NastavnikController {
	
	@Autowired
	NastavnikService nastavnikService;
	@Autowired
	ZvanjaService zvanjaService;
	@Autowired
	NastavnikZvanjaService nzService;
	
	private List<Zvanje> svaZvanja = new ArrayList<Zvanje>();
	private List<Zvanje> izabranaZvanja = new ArrayList<Zvanje>();
	
	private List<Nastavnik> svi;
		
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
		svi = nastavnikService.findAll();
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
		String ime = imeTf.getText();
		String prezime = prezimeTf.getText();
		String srednjeIme = srednjeImeTf.getText();
		String email = emailTf.getText();
		String obrazovanje = obrazovanjeTf.getText();
		Nastavnik n = new Nastavnik(ime, prezime, srednjeIme, email, obrazovanje);
		
		if (svi.contains(n)) {
			errorL.setText("Nastavnik vec postoji!");
			return;
		}
		
		if (CustomValidator.emptyString(ime, prezime, email, obrazovanje)) {
			errorL.setText("Sva polja osim \"Srednje ime\" moraju biti popunjena!");
			return;
		}
		
		if (nastavnikService.findByEmail(n.getEmail()).size() > 0) {
			errorL.setText("Nastavnik sa ovim mejlom vec postoji!");
			return;
		}
		
		n = nastavnikService.saveNastavnik(n);
		if (n != null) {
			boolean flag = false;
			List<NastavnikZvanja> temp = new ArrayList<NastavnikZvanja>();
			for (Zvanje z : izabranaZvanja) {
				NastavnikZvanja nz = new NastavnikZvanja(n, z);
				temp.add(nz);
				if (nzService.saveNastavnikZvanja(nz) == null) {
					flag = true;
				}
			}
			if (flag) {
				for (NastavnikZvanja nz : temp) {
					nzService.deleteNastavnikZvanja(nz);
				}
				nastavnikService.delete(n);
				errorL.setText("Greska kod cuvanja zvanja za datog nastavnika. Nastavnik nece biti sacuvan!");
				return;
			}
			
			FXSetter.emptyElements(imeTf, prezimeTf, srednjeImeTf, emailTf, obrazovanjeTf);
			
			for (Object c : zvanjaContainer.getChildren()) {
				((CheckBox)c).setSelected(false);
			}
		}
		else {
			errorL.setText("Neuspesno dodavanje, pokusajte ponovo.");
		}
	}
	
}
