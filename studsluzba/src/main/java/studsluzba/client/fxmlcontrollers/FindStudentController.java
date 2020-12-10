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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import studsluzba.client.MainViewManager;
import studsluzba.model.StudIndex;
import studsluzba.model.Student;
import studsluzba.model.Studprogram;
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

	private Student selektovaniStudent = null;
	
	@FXML private Label labelStudent = new Label();
	@FXML
	private ComboBox<Studprogram> studProgramCb2 = new ComboBox<Studprogram>();
	@FXML
	private DatePicker datumAktivnostiDp2;
	@FXML
	private TextField brojIndexTf2;
	@FXML
	private TextField godinaUpisaTf2;

	private ObservableList<Student> data = FXCollections.observableArrayList();

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

		for (Student s : studenti) {
			System.out.println(s);
			data.add(s);
		}

		imeTc.setCellValueFactory(new PropertyValueFactory<Student, String>("ime"));
		prezimeTc.setCellValueFactory(new PropertyValueFactory<Student, String>("prezime"));
		srednjeImeTc.setCellValueFactory(new PropertyValueFactory<Student, String>("srednjeIme"));
		godinaUpisaTc.setCellValueFactory(new PropertyValueFactory<Student, Integer>("godinaUpisa"));
		telefonTc.setCellValueFactory(new PropertyValueFactory<Student, String>("brTel"));

		table.setItems(data);

	}

	public void handleOpenModalPromeniIndex(ActionEvent ae) {
		selektovaniStudent = table.getSelectionModel().getSelectedItem();
		
		if(selektovaniStudent != null) {
			labelStudent.setText("Promena index-a za studenta: " + selektovaniStudent.getIme() + " " + selektovaniStudent.getPrezime());
			mainViewManager.openModal("promeniIndex");
		}
		
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
	
	public void upisiNaPredmete() {
		Student s = table.getSelectionModel().getSelectedItem();
		if (s == null) {
			//error
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
