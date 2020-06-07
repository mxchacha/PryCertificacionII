package com.chachalopez.PryCertificacion.models.entities;

import java.io.Serializable;
import java.util.Calendar;

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
@Table(name="depositos")
public class Deposito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_deposito")
	private Integer iddeposito;
	
	@Column(name="fecha_deposito")
	private Calendar fechaDeposito;
	
	@Column(name="monto")
	private Float monto;
	
	/*=====RELACION  UNO A MUCHOS CUENTA-DEPOSITO======*/
	@JoinColumn(name= "fk_cuenta", referencedColumnName = "pk_cuenta")
	@ManyToOne
	private Cuenta cuenta;
	/*=====RELACION  UNO A MUCHOS CUENTA-DEPOSITO======*/

	
	
	public Deposito() {
		super();
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public Deposito(Integer id) {
		super();
		this.iddeposito=id;
	}
	public Integer getIddeposito() {
		return iddeposito;
	}
	public void setIddeposito(Integer iddeposito) {
		this.iddeposito = iddeposito;
	}
	public Calendar getFechaDeposito() {
		return fechaDeposito;
	}
	public void setFechaDeposito(Calendar fechaDeposito) {
		this.fechaDeposito = fechaDeposito;
	}
	public Float getMonto() {
		return monto;
	}
	public void setMonto(Float monto) {
		this.monto = monto;
	}
	
	
	
	
	

}
