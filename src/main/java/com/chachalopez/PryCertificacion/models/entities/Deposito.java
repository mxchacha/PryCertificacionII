package com.chachalopez.PryCertificacion.models.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



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
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Calendar fechaDeposito;
	
	@NotNull
	@Size(min=1)
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
	
	
	
	
//------------------------------ METODOS ----------------------
	@Override
	public String toString() {
		return this.getIddeposito().toString();
	}
	//este metodo ayuda a que se retorne un la fecha con un formato y no toda la fecha que retorna con un monton de letras....
	public String fechaDep() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
		return sdf.format(fechaDeposito.getTime());
	}
	

	
	
	

}
