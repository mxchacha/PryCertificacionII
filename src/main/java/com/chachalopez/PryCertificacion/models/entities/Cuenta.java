package com.chachalopez.PryCertificacion.models.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cuentas")
public class Cuenta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_cuenta")
	private Integer idcuenta;
	
	@Column(name="num_cuenta")
	private String numCuenta;
	
	@Column(name="fecha_apertura")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Calendar fechaApertura;
	
	
	/*=====RELACION  UNO A MUCHOS CLIENTE-CUENTA======*/
	
	@JoinColumn(name= "fk_cliente", referencedColumnName = "pk_persona")
	@ManyToOne
	private Cliente cliente;
	
	/*=====RELACION  UNO A MUCHOS CLIENTE-CUENTA======
	 * 
	 * 
	 * */
	
	/*=====RELACION  UNO A MUCHOS CEUNTA-TIPOCUENTA======*/
	@OneToMany(mappedBy = "cuenta", fetch = FetchType.LAZY)
	private List<TipoCuenta> tipocuentas;
	
	/*=====RELACION  UNO A MUCHOS CEUNTA-TIPOCUENTA======
	 * 
	 * 
	 * */
	
	/*=====RELACION  UNO A MUCHOS CUENTA-PRESTAMO======*/
	@OneToMany(mappedBy = "cuenta", fetch = FetchType.LAZY)
	private List<Prestamo> prestamos;
	
	/*=====RELACION  UNO A MUCHOS CUENTA-PRESTAMO======*
	 * 
	 * 
	 */
	/*=====RELACION  UNO A MUCHOS CUENTA-DEPOSITO======*/
	@OneToMany(mappedBy = "cuenta", fetch = FetchType.LAZY)
	private List<Deposito> depositos;
	
	/*=====RELACION  UNO A MUCHOS CUENTA-DEPOSITO======*
	 * 
	 * 
	 * */
	/*=====RELACION  UNO A MUCHOS CUENTA-PRESTAMO======*/
	@OneToMany(mappedBy = "cuenta", fetch = FetchType.LAZY)
	private List<Retiro> retiro;
	
	/*=====RELACION  UNO A MUCHOS CUENTA-PRESTAMO======*/


	
	
	public Cuenta() {
		super();
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<TipoCuenta> getTipocuentas() {
		return tipocuentas;
	}

	public void setTipocuentas(List<TipoCuenta> tipocuentas) {
		this.tipocuentas = tipocuentas;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public List<Deposito> getDepositos() {
		return depositos;
	}

	public void setDepositos(List<Deposito> depositos) {
		this.depositos = depositos;
	}

	public List<Retiro> getRetiro() {
		return retiro;
	}

	public void setRetiro(List<Retiro> retiro) {
		this.retiro = retiro;
	}

	public Cuenta(Integer id) {
		super();
		this.idcuenta=id;
	}

	public Integer getIdcuenta() {
		return idcuenta;
	}

	public void setIdcuenta(Integer idcuenta) {
		this.idcuenta = idcuenta;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public Calendar getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Calendar fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	
//------------------------------ METODOS ----------------------
	@Override
	public String toString() {
		return this.getNumCuenta();
	}	
	//este metodo ayuda a que se retorne un la fecha con un formato y no toda la fecha que retorna con un monton de letras....
	public String fechaAper() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
		return sdf.format(fechaApertura.getTime());
	}
	
	
	
	
	
	

}
