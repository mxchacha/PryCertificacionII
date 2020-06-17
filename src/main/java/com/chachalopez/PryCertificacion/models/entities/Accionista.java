package com.chachalopez.PryCertificacion.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="accionistas")
public class Accionista extends Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="capital_ingreso")
	private Float capitalIngresado;
	
	/*=====RELACION  UNO A MUCHOS ACCIONISTA-CAPITAL======*/
	@OneToMany(mappedBy = "accionista", fetch = FetchType.LAZY)
	private List<Capital> capital;
	/*=====RELACION  UNO A MUCHOS AXCIONISTA-CAPITAL======*/

	
	
	public Accionista() {
		super();
	}
	
	public List<Capital> getCapital() {
		return capital;
	}

	public void setCapital(List<Capital> capital) {
		this.capital = capital;
	}

	public Accionista(Integer id) {
		super();
		this.setIdpersona(id);
	}

	public Float getCapitalIngresado() {
		return capitalIngresado;
	}

	public void setCapitalIngresado(Float capitalIngresado) {
		this.capitalIngresado = capitalIngresado;
	}
	
//------------------------------ METODOS ----------------------
	@Override
	public String toString() {
		return this.getNombre();
	}	
	
	
	
	

}
