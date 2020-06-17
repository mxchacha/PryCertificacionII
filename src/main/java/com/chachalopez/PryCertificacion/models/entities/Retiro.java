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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="retiros")
public class Retiro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_retiro")
	private Integer idretiro;
	
	@Column(name="fecha_retiro")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Calendar fechaRetiro;
	
	@Column(name="monto")
	private Float monto;

	/*=====RELACION  UNO A MUCHOS CUENTA-DEPOSITO======*/
		@JoinColumn(name= "fk_cuenta", referencedColumnName = "pk_cuenta")
		@ManyToOne
		private Cuenta cuenta;
	/*=====RELACION  UNO A MUCHOS CUENTA-DEPOSITO======*/
	
	
		
	public Retiro() {
		super();
	}
	
	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Retiro(Integer id) {
		super();
		this.idretiro=id;
	}

	public Integer getIdretiro() {
		return idretiro;
	}

	public void setIdretiro(Integer idretiro) {
		this.idretiro = idretiro;
	}

	public Calendar getFechaRetiro() {
		return fechaRetiro;
	}

	public void setFechaRetiro(Calendar fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}
	
	public String fechaRet() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
		return sdf.format(fechaRetiro.getTime());
	}	
	
	@Override
	public String toString() {
		return this.fechaRet();
	}

}
