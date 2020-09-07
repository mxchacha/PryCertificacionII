package com.chachalopez.PryCertificacion.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cosas")
public class Cosa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_cosa")
	private Integer idcosa;
	
	@Column(name="nombre")
	private String nombre;
	
	public Cosa() {
		super();
	}
	
	public Cosa(Integer id) {
		super();
		this.idcosa=id;
	}
//------------------------Maestro detalle-------------------	
	@JsonIgnore
	@OneToMany(mappedBy="objeto", fetch=FetchType.LAZY) 
	private List<Garantia> garantias;
	
	
	public List<Garantia> getGarantias() {
		return garantias;
	}


	public void setGarantias(List<Garantia> garantias) {
		this.garantias = garantias;
	}

//------------------------------------------------------------

	
	public Integer getIdCosa() {
		return idcosa;
	}
	public void setIdCosa(Integer idcosa) {
		this.idcosa = idcosa;
	}
	
	public Integer getIdcosa() {
		return idcosa;
	}
	public void setIdcosa(Integer idcosa) {
		this.idcosa = idcosa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/*public Float getFondo() {
		return fondo;
	}
	public void setFondo(Float fondo) {
		this.fondo = fondo;
	}*/
//------------------------------ METODOS ----------------------
	@Override
	public String toString() {
		return this.getIdCosa().toString();
	}
	

}
