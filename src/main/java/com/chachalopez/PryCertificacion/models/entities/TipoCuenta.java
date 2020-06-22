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
	
	@Column(name="descripcion")
	private String descripcion;

	
	/*=====RELACION  UNO A MUCHOS CEUNTA-TIPOCUENTA======*/
	@OneToMany(mappedBy = "tipocuenta", fetch = FetchType.LAZY)
	private List<Cuenta> cuentas;
	
	/*=====RELACION  UNO A MUCHOS CEUNTA-TIPOCUENTA======
	 * 
	 * 
	 * */
	
	
	
	
	public TipoCuenta() {
		super();
	}
	
	/**
	 * @return the cuentas
	 */
	public List<Cuenta> getCuentas() {
		return cuentas;
	}



	/**
	 * @param cuentas the cuentas to set
	 */
	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
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
	
	@Override
	public String toString() {
		return this.getNombre();
	}
	

}
