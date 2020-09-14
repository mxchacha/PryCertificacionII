package com.chachalopez.PryCertificacion.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name="prestamos")
public class Prestamo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_prestamo")
	private Integer idprestamo;
	
	@Column(name="num_prestamo")
	private String numPrestamo;
	
	@Column(name="monto")
	private Float monto;
	
	@Column(name="tiempo")
	private String tiempo;
	
	
	/*=====RELACION  UNO A MUCHOS CUENTA-PRESTAMO======*/
	@JoinColumn(name= "fk_cuenta", referencedColumnName = "pk_cuenta")
	@ManyToOne
	private Cuenta cuenta;
	/*=====RELACION  UNO A MUCHOS CUENTA-PRESTAMO======*
	 * 
	 * 
	 */
	
	/*=====RELACION  UNO A MUCHOS PRESTAMO-TIPOPRESTAMO======*/
	@JoinColumn(name= "fk_tipoprestamo", referencedColumnName = "pk_tipoprestamo")
	@ManyToOne
	private TipoPrestamo tipoprestamo;
	/*=====RELACION  UNO A MUCHOS PRESTAMO-TIPOPRESTAMO======
	 * 
	 * 
	 * */
	/*=====RELACION  UNO A MUCHOS CAPITAL-PRESTAMO======*/
	@JoinColumn(name= "fk_capital", referencedColumnName = "pk_capital")
	@ManyToOne
	private Capital capital;
	/*=====RELACION  UNO A MUCHOS CAPITAL-PRESTAMO======*/

	
	
//-----------------------Maestro detalle--------------
	@JsonIgnore
	@OneToMany(mappedBy="prestamo", fetch=FetchType.LAZY)
	private List<Garantia> garantias;
	
	public List<Garantia> getGarantias() {
		if(garantias == null)
			garantias = new ArrayList<Garantia>();
		return garantias;
	}

	public void setGarantias(List<Garantia> garantias) {
		this.garantias = garantias;
	}
	
//-----------------------Maestro detalle- V2 -------------
	@JsonIgnore
	@OneToMany(mappedBy="prestamo", fetch=FetchType.LAZY)
	private List<Garante> garantes;
	
	
	public List<Garante> getGarantes() {
		return garantes;
	}

	public void setGarantes(List<Garante> garantes) {
		this.garantes = garantes;
	}

//-------------------------------------------------------
	public Prestamo() {
		super();
	}
	
	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
    

	/**
	 * @return the tipoprestamo
	 */
	public TipoPrestamo getTipoprestamo() {
		return tipoprestamo;
	}

	/**
	 * @param tipoprestamo the tipoprestamo to set
	 */
	public void setTipoprestamo(TipoPrestamo tipoprestamo) {
		this.tipoprestamo = tipoprestamo;
	}

	public Capital getCapital() {
		return capital;
	}

	public void setCapital(Capital capital) {
		this.capital = capital;
	}

	public Prestamo(Integer id) {
		super();
		this.idprestamo=id;
	}

	public Integer getIdprestamo() {
		return idprestamo;
	}

	public void setIdprestamo(Integer idprestamo) {
		this.idprestamo = idprestamo;
	}

	public String getNumPrestamo() {
		return numPrestamo;
	}

	public void setNumPrestamo(String numPrestamo) {
		this.numPrestamo = numPrestamo;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	
	
	
	
	
	
	
	
//------------------------------ METODOS ----------------------
	
	

	@Override
	public String toString() {
		return this.getNumPrestamo();
	}

		

	
}
