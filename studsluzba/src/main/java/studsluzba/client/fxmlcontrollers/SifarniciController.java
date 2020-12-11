package studsluzba.client.fxmlcontrollers;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import studsluzba.sifarnici.SifarniciManager;
import studsluzba.sifarnici.Sifarnik;
import studsluzba.tools.Stored;

@Component
public class SifarniciController {

	@FXML
	private ComboBox<Sifarnik> sifarniciCb;

	@FXML
	public void initialize() {
		List<Sifarnik> s = Arrays.asList(Sifarnik.values());
		sifarniciCb.setItems(FXCollections.observableArrayList(s));
	}

	public void openNotepad() {
		String path = null;
		if (sifarniciCb.getValue() != null) {
			Sifarnik s = sifarniciCb.getValue();
			path = SifarniciManager.getPath(s);
		}
		
		try {
			ProcessBuilder pb = new ProcessBuilder("Notepad.exe", new File(path).getAbsolutePath());
			pb.start();
			Stored.getInstance().refreshAll();
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR, "Niste izabrali sifarnik!", ButtonType.CANCEL);
			a.show();
		}
	}
}
