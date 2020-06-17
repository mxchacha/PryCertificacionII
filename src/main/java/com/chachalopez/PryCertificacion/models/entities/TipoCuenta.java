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

@Entity
@Table(name="tipocuentas")
public class TipoCuenta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_tipocuenta")
	private Integer idtipocuenta;
	
	@Column(name="nombre")
	private String  nombre;
	
	@Column(name="descripción")
	private String descripcion;

	
	/*=====RELACION  UNO A MUCHOS CEUNTA-TIPOCUENTA======*/
	@JoinColumn(name= "fk_cuenta", referencedColumnName = "pk_cuenta")
	@ManyToOne
	private Cuenta cuenta;
	
	/*=====RELACION  UNO A MUCHOS CEUNTA-TIPOCUENTA======*/
	
	
	
	
	public TipoCuenta() {
		super();
	}
	
	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public TipoCuenta(Integer id) {
		super();
		this.idtipocuenta=id;
	}

	public Integer getIdtipocuenta() {
		return idtipocuenta;
	}

	public void setIdtipocuenta(Integer idtipocuenta) {
		this.idtipocuenta = idtipocuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
//------------------------------ METODOS ----------------------
	@Override
	public String toString() {
		return this.getNombre();
	}

}
