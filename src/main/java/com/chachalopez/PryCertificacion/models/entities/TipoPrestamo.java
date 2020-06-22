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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipoprestamos")
public class TipoPrestamo implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_tipoprestamo")
	private Integer idtipoprestamo;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="interes")
	private float interes;
	
	@Column(name="plazo")
	private String plazo;
	
	/*=====RELACION  UNO A MUCHOS PRESTAMO-TIPOPRESTAMO======*/
	@OneToMany(mappedBy = "tipoprestamo", fetch = FetchType.LAZY)
	private List<Prestamo> prestamos;
	/*=====RELACION  UNO A MUCHOS PRESTAMO-TIPOPRESTAMO======*/
	
	
	
	public TipoPrestamo() {
		super();
	}
	

	public TipoPrestamo(Integer id) {
		super();
		this.idtipoprestamo=id;
	}

	public Integer getIdtipoprestamo() {
		return idtipoprestamo;
	}

	public void setIdtipoprestamo(Integer idtipoprestamo) {
		this.idtipoprestamo = idtipoprestamo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getInteres() {
		return interes;
	}

	public void setInteres(float interes) {
		this.interes = interes;
	}

	public String getPlazo() {
		return plazo;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}
	
	/**
	 * @return the prestamos
	 */
	public List<Prestamo> getPrestamos() {
		return prestamos;
	}


	/**
	 * @param prestamos the prestamos to set
	 */
	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}


	@Override
	public String toString() {
		return this.getNombre();
	}
	
}
