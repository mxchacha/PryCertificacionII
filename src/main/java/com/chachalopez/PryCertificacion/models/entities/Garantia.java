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
@Table(name="garantias")
public class Garantia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_garantia")	
	private Integer idgarantia;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="valor")
	private Float valor;

//--------------------------Maestro detalle ----------------------------------
	@JoinColumn(name="fk_objeto", referencedColumnName="pk_cosa")
	@ManyToOne
	private Cosa objeto;
	
	@JoinColumn(name="fk_prestamo", referencedColumnName="pk_prestamo")
	@ManyToOne
	private Prestamo prestamo;
	
	public Cosa getObjeto() {
		return objeto;
	}

	public void setObjeto(Cosa objeto) {
		this.objeto = objeto;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	
		
//-------------------------------------------------------------------------	
	public Garantia() {
		super();
	}
	
	public Garantia(Integer id) {
		super();
		this.idgarantia = id;
	}
	
	public Integer getIdgarantia() {
		return idgarantia;
	}

	public void setIdgarantia(Integer idgarantia) {
		this.idgarantia = idgarantia;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	

	
	
/**** TRANSIENT ***/
	
	@Transient
	private int cosaid;
	
	@Transient
	private int prestamoid;
	
	public int getCosaid() {
		return cosaid;
	}

	public void setCosaid(int cosaid) {
		this.cosaid = cosaid;
	}

	public int getPrestamoid() {
		return prestamoid;
	}

	public void setPrestamoid(int prestamoid) {
		this.prestamoid = prestamoid;
	}
	
	
	
}


