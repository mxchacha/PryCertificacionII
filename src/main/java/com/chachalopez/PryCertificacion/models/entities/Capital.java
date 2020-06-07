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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="capitales")
public class Capital implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_capital")
	private Integer idcapital;
	
	@Column(name="fondo")
	private Float fondo;
	
	/*=====RELACION  UNO A MUCHOS CAPITAL-PRESTAMO======*/
	@OneToMany(mappedBy = "capital", fetch = FetchType.LAZY)
	private List<Prestamo> prestamos;
	/*=====RELACION  UNO A MUCHOS CAPITAL-PRESTAMO======
	 * 
	 * 
	 * */

	/*=====RELACION  UNO A MUCHOS ACCIONISTA-CAPITAL======*/
	@JoinColumn(name= "fk_accionista", referencedColumnName = "pk_persona")
	@ManyToOne
	private Accionista accionista;
	/*=====RELACION  UNO A MUCHOS ACCIONISTA-CAPITAL=====*/
	
	
	
	public Capital() {
		super();
	}
	public List<Prestamo> getPrestamos() {
		return prestamos;
	}
	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}
	public Accionista getAccionista() {
		return accionista;
	}
	public void setAccionista(Accionista accionista) {
		this.accionista = accionista;
	}
	public Capital(Integer id) {
		super();
		this.idcapital=id;
	}
	public Integer getIdcapital() {
		return idcapital;
	}
	public void setIdcapital(Integer idcapital) {
		this.idcapital = idcapital;
	}
	public Float getFondo() {
		return fondo;
	}
	public void setFondo(Float fondo) {
		this.fondo = fondo;
	}
	
	

}
