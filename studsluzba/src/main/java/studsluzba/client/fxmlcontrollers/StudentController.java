package studsluzba.client.fxmlcontrollers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;
import studsluzba.client.MainViewManager;
import studsluzba.model.SrednjaSkola;
import studsluzba.model.StudIndex;
import studsluzba.model.Student;
import studsluzba.model.Studprogram;
import studsluzba.model.TokStudija;
import studsluzba.model.UpisGodine;
import studsluzba.services.SrednjeSkoleService;
import studsluzba.services.StudProgramService;
import studsluzba.services.StudentIndexService;
import studsluzba.services.StudentService;
import studsluzba.services.TokStudijaService;
import studsluzba.services.UpisGodineService;
import studsluzba.sifarnici.DrzavaGradovi;
import studsluzba.tools.CustomValidator;
import studsluzba.tools.FXSetter;
import studsluzba.tools.Stored;

@Component
public class StudentController {

	@Autowired
	StudentService studentService;

	@Autowired
	StudentIndexService studentIndexService;

	@Autowired
	SrednjeSkoleService sifarniciService;

	@Autowired
	TokStudijaService tsService;
	
	@Autowired
	UpisGodineService ugService;
	
	@Autowired
	MainViewManager mainViewManager;

	// forma ce se koristiti za unos novog i za azuriranje postojeceg studenta
	private Student student;

	@FXML
	private TextField imeTf;
	@FXML
	private TextField prezimeTf;
	@FXML
	private TextField srednjeImeTf;
	@FXML
	private TextField jmbgTf;
	@FXML
	private DatePicker datumRodjenjaDp;
	@FXML
	private Text actionTarget;
	@FXML
	private ToggleGroup polGroup;
	@FXML
	private RadioButton radioButton;
	@FXML
	private RadioButton radioButton2;
	@FXML
	private TextField emailFaxTf;
	@FXML
	private TextField emailPersTf;
	@FXML
	TextField brojTelefonaTf;

	@FXML
	TextField adresaStanovanjaTf;
	// TODO da li i mesta da idu preko sifarnika
	@FXML
	ComboBox<String> mestoStanovanjaCb;
	@FXML
	ComboBox<String> mestoRodjenjaCb;
	@FXML
	ComboBox<String> drzavaRodjenjaCb;
	@FXML
	ComboBox<String> drzavljanstvoCb;
	@FXML
	TextField nacionalnostTf;
	@FXML
	TextField brojLicneKarteTf;
	@FXML
	TextField licnuKartuIzdaoTf;

	// prvi upis

	@FXML
	ComboBox<SrednjaSkola> srednjeSkolaCb;
	@FXML
	TextField strucnaSpremaTf;
	@FXML
	TextField uspehSrednjaSkolaTf;
	@FXML
	TextField uspehPrijemniTf;
	@FXML
	TextField godinaZavrsetkaSrednjeSkoleTf;
	@FXML
	TextField prelazSaVisokoskolskeUstanoveTf;
	@FXML
	TextField prethodnoZavrseneStudijeTf;
	@FXML
	TextField visokoskolskaUstanovaPrethodnihStudijaTf;
	@FXML
	TextField stecenoZvanjeTf;
	@FXML
	TextField prosecnaOcenaTf;
	@FXML
	DatePicker datumUpisaDp;
	@FXML
	TextArea napomenaTa;

	// INDEX

	@Autowired
	StudProgramService studProgramService;
	@FXML
	private ComboBox<Studprogram> studProgramCb;
	@FXML
	private DatePicker datumAktivnostiDp;
	@FXML
	private TextField brojIndexTf;
	@FXML
	private TextField godinaUpisaTf;

	
	@FXML
	public void initialize() {
		List<String> drzavaCodes = new ArrayList<String>();
		List<String> mestaCodes = new ArrayList<String>();
		List<DrzavaGradovi> dg = Stored.getInstance().getDrzavaList();
		for (DrzavaGradovi d : dg) {
			drzavaCodes.add(d.getDrzava());
			mestaCodes.addAll(List.of(d.getGradovi()));
		}
		drzavaRodjenjaCb.setItems(FXCollections.observableArrayList(drzavaCodes));
		drzavljanstvoCb.setItems(FXCollections.observableArrayList(drzavaCodes));
		
		ObservableList<String> mestaCodesObservableList = FXCollections.observableArrayList(mestaCodes);
		mestoRodjenjaCb.setItems(mestaCodesObservableList);
		List<SrednjaSkola> srednjeSkole = sifarniciService.getSrednjeSkole();
		srednjeSkolaCb.setItems(FXCollections.observableArrayList(srednjeSkole));

		List<Studprogram> sviStudProgrami = studProgramService.getAllPrograms();
		ObservableList<Studprogram> sviStudProgramiObservableList = FXCollections.observableArrayList(sviStudProgrami);
		studProgramCb.setItems(sviStudProgramiObservableList);
	}

	public void handleOpenModalSrednjeSkole(ActionEvent ae) {
		// TODO kreirati modal window za dodavanje nove srednje skole, mozda i brisanje
		// i promena postojećih ?? strani ključ
		mainViewManager.openModal("addSrednjaSkola");
	}

	public void updateSrednjeSkole() {
		List<SrednjaSkola> srednjeSkole = sifarniciService.getSrednjeSkole();
		srednjeSkolaCb.setItems(FXCollections.observableArrayList(srednjeSkole));
	}

	public void handleSaveStudent(ActionEvent event) {

		String pol = null;
		if (polGroup.getSelectedToggle() == radioButton) {
			pol = "Muski";

		} else if (polGroup.getSelectedToggle() == radioButton2) {
			pol = "Zenski";
		}
		
		if (CustomValidator.emptyOrNull(imeTf.getText(),prezimeTf.getText(),srednjeImeTf.getText(),jmbgTf.getText(),
				datumRodjenjaDp.getValue(),mestoRodjenjaCb.getSelectionModel().getSelectedItem(),drzavaRodjenjaCb.getSelectionModel().getSelectedItem(),
				pol,drzavljanstvoCb.getSelectionModel().getSelectedItem(),nacionalnostTf.getText(),brojLicneKarteTf.getText(),
				brojTelefonaTf.getText(),licnuKartuIzdaoTf.getText(),adresaStanovanjaTf.getText(),emailFaxTf.getText(),emailPersTf.getText(),
				srednjeSkolaCb.getSelectionModel().getSelectedItem())) {
			Alert a = new Alert(AlertType.ERROR, "Sva polja moraju biti popunjena!", ButtonType.CLOSE);
			a.show();
			return;
		}
			
		
		if (studentIndexService.findIndexByParams(Integer.parseInt(brojIndexTf.getText()), Integer.parseInt(godinaUpisaTf.getText()), studProgramCb.getSelectionModel().getSelectedItem()).size() > 0) {
			Alert a = new Alert(AlertType.ERROR, "Student sa ovim indexom vec postoji!", ButtonType.CLOSE);
			a.show();			
			return;
		}

		Student s = new Student();
		s.setIme(imeTf.getText());
		s.setPrezime(prezimeTf.getText());
		s.setSrednjeIme(srednjeImeTf.getText());
		s.setJmbg(jmbgTf.getText());
		s.setDatumRodj(datumRodjenjaDp.getValue());
		s.setMestoRodj(mestoRodjenjaCb.getSelectionModel().getSelectedItem());
		s.setDrzavaRodj(drzavaRodjenjaCb.getSelectionModel().getSelectedItem());
		s.setPol(pol);
		s.setDrzavljanstvo(drzavljanstvoCb.getSelectionModel().getSelectedItem());
		s.setNacionalnost(nacionalnostTf.getText());
		s.setBrLK(brojLicneKarteTf.getText());
		s.setBrTel(brojTelefonaTf.getText());
		s.setIzdavacLk(licnuKartuIzdaoTf.getText());
		s.setAdresa(adresaStanovanjaTf.getText());
		s.setEmFax(emailFaxTf.getText());
		s.setEmPers(emailPersTf.getText());
		s.setSrednjaSkola(srednjeSkolaCb.getSelectionModel().getSelectedItem());
		
		s = studentService.saveStudent(s);
		if (s == null) {
			// student save error
			return;
		}

		StudIndex si = studentIndexService.saveStudentIndex(datumAktivnostiDp.getValue(),
				Integer.parseInt(brojIndexTf.getText()), true, Integer.parseInt(godinaUpisaTf.getText()), s,
				studProgramCb.getSelectionModel().getSelectedItem());
		if (si == null) {
			//si save error ne moze da se napravi index
			studentService.delete(s);
			return;
		}
		
		TokStudija ts = new TokStudija("Sad upisao godinu", LocalDate.now(), si);
		ts = tsService.save(ts);
		if (ts == null) {
			studentService.delete(s);
			studentIndexService.deleteIndexForStudent(si);
			return;
		}
		
		UpisGodine ug = new UpisGodine(1, "Prvi upis", LocalDate.now(), ts);
		ug = ugService.save(ug);
		
		if (ug == null) {
			studentService.delete(s);
			studentIndexService.deleteIndexForStudent(si);
			tsService.delete(ts);
			return;
		}
		
		FXSetter.emptyElements(brojIndexTf, godinaUpisaTf, studProgramCb, srednjeSkolaCb, imeTf, prezimeTf, srednjeImeTf, jmbgTf, datumRodjenjaDp, datumAktivnostiDp, mestoRodjenjaCb, drzavaRodjenjaCb, drzavljanstvoCb, nacionalnostTf, brojLicneKarteTf, brojTelefonaTf, licnuKartuIzdaoTf, adresaStanovanjaTf, emailFaxTf, emailPersTf);
		
	}
}
