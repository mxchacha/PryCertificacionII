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
	
	@Column(name="tipo_garantia", length=1)
	private String tipo_garantia;
	
	@Column(name="valor")
	private Float valor;
	
	@JoinColumn(name="fk_objeto", referencedColumnName="pk_cosa")
	@ManyToOne
	private Cosa objeto;
	
	@JoinColumn(name="fk_prestamo", referencedColumnName="pk_prestamo")
	@ManyToOne
	private Prestamo prestamo;
	
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

	public String getTipo_garantia() {
		return tipo_garantia;
	}

	public void setTipo_garantia(String tipo_garantia) {
		this.tipo_garantia = tipo_garantia;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

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

	public void setPrestamoid(int id) {
		this.prestamoid = id;
	}
	
	
	
}


