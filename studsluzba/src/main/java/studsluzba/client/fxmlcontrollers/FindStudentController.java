package studsluzba.client.fxmlcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import studsluzba.client.MainViewManager;
import studsluzba.model.Ispit;
import studsluzba.model.ObnovaGodine;
import studsluzba.model.Predmet;
import studsluzba.model.StudIndex;
import studsluzba.model.Student;
import studsluzba.model.Studprogram;
import studsluzba.model.UpisGodine;
import studsluzba.services.StudProgramService;
import studsluzba.services.StudentIndexService;
import studsluzba.services.StudentService;

@Component
public class FindStudentController {

	@Autowired
	StudentService studentService;
	@Autowired
	StudentIndexService studentIndexService;
	@Autowired
	MainViewManager mainViewManager;
	@FXML
	private TextField studProgTf;
	@FXML
	private TextField brojTf;
	@FXML
	private TextField godinaTf;
	@FXML
	private TextField imeTf;
	@FXML
	private TextField prezimeTf;
	@FXML
	private TableView<Student> table = new TableView();
	@FXML
	private TableColumn imeTc = new TableColumn();
	@FXML
	private TableColumn prezimeTc = new TableColumn();
	@FXML
	private TableColumn srednjeImeTc = new TableColumn();
	@FXML
	private TableColumn godinaUpisaTc = new TableColumn();
	@FXML
	private TableColumn telefonTc = new TableColumn();

	// PROMENI INDEX
	@Autowired
	StudProgramService studProgramService;
	@FXML
	private Label lblStudent;
	@FXML
	private ComboBox<Studprogram> studProgramCb2 = new ComboBox<Studprogram>();
	@FXML
	private DatePicker datumAktivnostiDp2;
	@FXML
	private TextField brojIndexTf2;
	@FXML
	private TextField godinaUpisaTf2;

	private Student selektovaniStudent = null;

	private ObservableList<Student> data = FXCollections.observableArrayList();

	// DOSIJE

	// OSN POD
	@FXML
	private Label lblIme;
	@FXML
	private Label lblPrezime;
	@FXML
	private Label lblSrednjeIme;
	@FXML
	private Label lblIndex;
	@FXML
	private Label lblGodina;
	@FXML
	private Label lblDatumRodjenja;
	@FXML
	private Label lblAdresa;
	@FXML
	private Label lblDrzavaRodjenja;
	@FXML
	private Label lblDrzavljanstvo;
	@FXML
	private Label lblJmbg;
	@FXML
	private Label lblBrojLK;
	@FXML
	private Label lblIzdavalacLK;
	@FXML
	private Label lblSrednjaSkola;
	@FXML
	private Label lblTelefon;
	@FXML
	private Label lblFaxEmail;
	@FXML
	private Label lblPersEmail;

	// PREDMETI

	@FXML
	ListView<Predmet> lvPolozeniPredmeti;
	@FXML
	ListView<Predmet> lvSlusaPredmete;

	// TOK STUD

	@FXML
	Button btnDodajNoviUpis;
	@FXML
	Button btnDodajNovuObnovu;
	@FXML
	ListView<UpisGodine> lvSviUpisi;
	@FXML
	ListView<ObnovaGodine> lvSveObnove;

	@FXML
	public void initialize() {

		List<Studprogram> sviStudProgrami = studProgramService.getAllPrograms();
		ObservableList<Studprogram> sviStudProgramiObservableList = FXCollections.observableArrayList(sviStudProgrami);
		studProgramCb2.setItems(sviStudProgramiObservableList);

		List<Student> svi = studentService.findAll();
		imeTc.setCellValueFactory(new PropertyValueFactory<Student, String>("ime"));
		prezimeTc.setCellValueFactory(new PropertyValueFactory<Student, String>("prezime"));
		srednjeImeTc.setCellValueFactory(new PropertyValueFactory<Student, String>("srednjeIme"));
		godinaUpisaTc.setCellValueFactory(new PropertyValueFactory<Student, Integer>("godinaUpisa"));
		telefonTc.setCellValueFactory(new PropertyValueFactory<Student, String>("brTel"));
		table.setItems(FXCollections.observableArrayList(svi));
	}

	public void handleFindStudentByIndex(ActionEvent event) {
		Integer broj = null;
		Integer godina = null;
		String studprogram = null;

		if ((!brojTf.getText().isEmpty())) {
			broj = Integer.parseInt(brojTf.getText());
		}
		if ((!godinaTf.getText().isEmpty())) {
			godina = Integer.parseInt(godinaTf.getText());
		}
		if (!studProgTf.getText().isEmpty()) {
			studprogram = studProgTf.getText();
		}
		List<Student> s = studentService.findStudentByIndex(broj, studprogram, godina);

		imeTc.setCellValueFactory(new PropertyValueFactory<Student, String>("ime"));
		prezimeTc.setCellValueFactory(new PropertyValueFactory<Student, String>("prezime"));
		srednjeImeTc.setCellValueFactory(new PropertyValueFactory<Student, String>("srednjeIme"));
		godinaUpisaTc.setCellValueFactory(new PropertyValueFactory<Student, Integer>("godinaUpisa"));
		telefonTc.setCellValueFactory(new PropertyValueFactory<Student, String>("brTel"));

		data.clear();
		data.addAll(s);

		table.setItems(data);

	}

	public void handleFindStudentByName(ActionEvent event) {

		String ime = null;
		String prezime = null;

		if ((!imeTf.getText().isEmpty())) {
			ime = imeTf.getText();
		}
		if ((!prezimeTf.getText().isEmpty())) {
			prezime = prezimeTf.getText();
		}

		List<Student> studenti = studentService.findStudentByName(ime, prezime);
		data.clear();
		if (studenti != null)
			data.addAll(studenti);

		imeTc.setCellValueFactory(new PropertyValueFactory<Student, String>("ime"));
		prezimeTc.setCellValueFactory(new PropertyValueFactory<Student, String>("prezime"));
		srednjeImeTc.setCellValueFactory(new PropertyValueFactory<Student, String>("srednjeIme"));
		godinaUpisaTc.setCellValueFactory(new PropertyValueFactory<Student, Integer>("godinaUpisa"));
		telefonTc.setCellValueFactory(new PropertyValueFactory<Student, String>("brTel"));

		table.setItems(data);

	}

	public void handleOpenModalPromeniIndex(ActionEvent ae) {
		selektovaniStudent = table.getSelectionModel().getSelectedItem();

		if (selektovaniStudent != null) {
			mainViewManager.openModalNoWait("promeniIndex");
			lblStudent.setText("Promena index-a za studenta: " + selektovaniStudent.toString());
		} else {
			Alert a = new Alert(AlertType.ERROR, "Niste izabrali studenta!", ButtonType.CLOSE);
			a.show();
			return;
		}

	}

	public void handleOpenModalUpis(ActionEvent ae) {
		List<Object> l = new ArrayList<Object>();
		l.add(selektovaniStudent);
		mainViewManager.setParameters(l);
		mainViewManager.openModalNoWait("noviUpis");

	}

	public void handleOpenModalObnova(ActionEvent ae) {
		List<Object> l = new ArrayList<Object>();
		l.add(selektovaniStudent);
		mainViewManager.setParameters(l);
		mainViewManager.openModalNoWait("novaObnova");

	}

	public void handlePromeniIndex(ActionEvent event) {

		StudIndex siStari = studentIndexService.getActiveIndexForStudent(selektovaniStudent);

		StudIndex siNStari = studentIndexService.saveStudentIndex(siStari.getDatumaktivnosti(), siStari.getBroj(),
				false, siStari.getGodinaUpisa(), selektovaniStudent, siStari.getStudProgram());

		StudIndex siN = studentIndexService.saveStudentIndex(datumAktivnostiDp2.getValue(),
				Integer.parseInt(brojIndexTf2.getText()), true, Integer.parseInt(godinaUpisaTf2.getText()),
				selektovaniStudent, studProgramCb2.getSelectionModel().getSelectedItem());

		studentIndexService.deleteIndexForStudent(siStari);

	}

	public void handleOpenModalOtvoriDosije(ActionEvent ae) {
		selektovaniStudent = table.getSelectionModel().getSelectedItem();

		if (selektovaniStudent != null) {
			mainViewManager.openModalNoWait("prikaziDosije");

			// OP
			lblIme.setText(selektovaniStudent.getIme());
			lblPrezime.setText(selektovaniStudent.getPrezime());
			lblSrednjeIme.setText(selektovaniStudent.getSrednjeIme());
			String aktivanIndex = studentIndexService.getActiveIndexForStudent(selektovaniStudent).toString();
			lblIndex.setText(aktivanIndex);
			lblDatumRodjenja.setText(selektovaniStudent.getDatumRodj().toString() + "");
			lblAdresa.setText(selektovaniStudent.getAdresa());
			lblDrzavaRodjenja.setText(selektovaniStudent.getDrzavaRodj());
			lblDrzavljanstvo.setText(selektovaniStudent.getDrzavljanstvo());
			lblJmbg.setText(selektovaniStudent.getJmbg());
			lblBrojLK.setText(selektovaniStudent.getBrLK());
			lblIzdavalacLK.setText(selektovaniStudent.getIzdavacLk());
			lblSrednjaSkola.setText(selektovaniStudent.getSrednjaSkola().toString());
			lblTelefon.setText(selektovaniStudent.getBrTel());
			lblFaxEmail.setText(selektovaniStudent.getEmFax());
			lblPersEmail.setText(selektovaniStudent.getEmPers());

			// Predmeti

			// Lsit<Predmet> polozeniPredmeti = ;

			// lvPolozeniPredmeti.setItems(FXCollections.observableArrayList(polozeniPredmeti));;
			// lvSlusaPredmete;

			// Tok Studija
			// lvSviUpisi;
			// lvSveObnove;

		} else {
			Alert a = new Alert(AlertType.ERROR, "Niste izabrali studenta!", ButtonType.CLOSE);
			a.show();
			return;
		}

	}

	public void upisiNaPredmete() {
		Student s = table.getSelectionModel().getSelectedItem();
		if (s == null) {
			// error
			Alert a = new Alert(AlertType.ERROR, "Niste izabrali studenta!", ButtonType.CLOSE);
			a.show();
			return;
		}
		StudIndex si = studentIndexService.getActiveIndexForStudent(s);
		List<Object> o = new ArrayList<Object>();
		o.add(si);
		MainViewManager.setParameters(o);
		mainViewManager.changeRoot("studentPredmet");
	}
}
