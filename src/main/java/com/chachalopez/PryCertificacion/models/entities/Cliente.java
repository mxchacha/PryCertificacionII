package com.chachalopez.PryCertificacion.models.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="clientes")
public class Cliente extends Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "pk_cliente")
	private Integer idcliente;
	*/
	
	@Column(name="fecha_ingreso")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Calendar fechaIngreso;
	
	@Column(name="monto_ingreso")
	private Float montoIngreso;
	
	/*=====RELACION  UNO A MUCHOS CLIENTE-CUENTA======*/
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Cuenta> cuentas;
	
	/*=====FIN DE RELACION  UNO A MUCHOS CLIENTE-CUENTA======*/
	
//------------------------Maestro detalle-V2------------------	
	
	@JsonIgnore
	@OneToMany(mappedBy="asegurador", fetch=FetchType.LAZY) 
	private List<Garante> garantes;
	
	public List<Garante> getGarantes() {
		return garantes;
	}

	public void setGarantes(List<Garante> garantes) {
		this.garantes = garantes;
	}
	

//------------------------------------------------------------	


	public Cliente() {
		super();
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Cliente(Integer id) {
		super();
		this.setIdpersona(id);
	}

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Float getMontoIngreso() {
		return montoIngreso;
	}

	public void setMontoIngreso(Float montoIngreso) {
		this.montoIngreso = montoIngreso;
	}
	
/*	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}*/

	//------------------------------ METODOS ----------------------
	@Override
	public String toString() {
		return this.getNombre()+" "+this.getApellido();
	}
	
	//este metodo ayuda a que se retorne un la fecha con un formato y no toda la fecha que retorna con un monton de letras....
	public String fechaIngr() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
		return sdf.format(fechaIngreso.getTime());
	}

	public Calendar Ingreso() {
		Calendar fecha=Calendar.getInstance();
		return fecha;
	}
	
	
	

}
