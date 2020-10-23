package studsluzba.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="StudentPredispitneObaveze.findAll", query="SELECT s FROM StudentPredispitneObaveze s")
public class StudentPredispitneObaveze implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSPO;
	
	private double poeni;
	
	@ManyToOne
	@JoinColumn(name = "idPredispitnaObaveza")
	private PredispitnaObaveza obaveza;

	@ManyToOne
	@JoinColumn(name = "idDrziPremet")
	private DrziPredmet drziPredmet;

	
	public StudentPredispitneObaveze(double poeni, PredispitnaObaveza obaveza, DrziPredmet drziPredmet) {
		this.poeni = poeni;
		this.obaveza = obaveza;
		this.drziPredmet = drziPredmet;
	}
	
	public double getPoeni() {
		return poeni;
	}

	public void setPoeni(double poeni) {
		this.poeni = poeni;
	}
	
	
}