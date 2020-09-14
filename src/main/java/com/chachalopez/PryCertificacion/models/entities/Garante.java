package com.chachalopez.PryCertificacion.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="garantes")
public class Garante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_garante")	
	private Integer idgarante;
	
	@Column(name="parentesco", length=1)
	private String parentesco;
	
	@Column(name="ocupacion")
	private String ocupacion;
	
	
	public Garante(Integer idgarante) {
		super();
		this.idgarante = idgarante;
	}

	public Garante() {
			super();
		}


//--------------------------Maestro detalle-V2---------------------------------
	@JoinColumn(name="fk_asegurador", referencedColumnName="pk_persona")
	@ManyToOne
	private Cliente asegurador;

	@JoinColumn(name="fk_prestamo", referencedColumnName="pk_prestamo")
	@ManyToOne
	private Prestamo prestamo;
			
	
	public Cliente getAsegurador() {
		return asegurador;
	}

	public void setAsegurador(Cliente asegurador) {
		this.asegurador = asegurador;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	
	
	
	
	
//-------------------- getters and Setters--------------------------
	public Integer getIdgarante() {
		return idgarante;
	}

	public void setIdgarante(Integer idgarante) {
		this.idgarante = idgarante;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	
/**** TRANSIENT ***/
	
	@Transient
	private int clienteid;
	
	@Transient
	private int prestamoid;


	public int getClienteid() {
		return clienteid;
	}

	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}

	public int getPrestamoid() {
		return prestamoid;
	}

	public void setPrestamoid(int prestamoid) {
		this.prestamoid = prestamoid;
	}	
	
	

}
