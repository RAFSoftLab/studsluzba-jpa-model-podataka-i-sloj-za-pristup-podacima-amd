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
	@JoinColumn(name = "idIndex")
	private StudIndex studIndex;
	
	@ManyToOne
	@JoinColumn(name = "idPredmeta")
	private Predmet predmet;
	
	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	
	public StudentPredispitneObaveze(double poeni, PredispitnaObaveza obaveza, StudIndex si, Predmet p) {
		this.poeni = poeni;
		this.obaveza = obaveza;
		this.studIndex = si;
		this.predmet = p;
	}
	
	public double getPoeni() {
		return poeni;
	}

	public void setPoeni(double poeni) {
		this.poeni = poeni;
	}
	
	
}
