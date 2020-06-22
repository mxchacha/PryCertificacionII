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

@Entity
@Table(name="clientes")
public class Cliente extends Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="fecha_ingreso")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Calendar fechaIngreo;
	
	@Column(name="monto_ingreso")
	private Float montoIngreso;
	
	/*=====RELACION  UNO A MUCHOS CLIENTE-CUENTA======*/
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Cuenta> cuentas;
	
	/*=====FIN DE RELACION  UNO A MUCHOS CLIENTE-CUENTA======*/
	
	

	
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

	public Calendar getFechaIngreo() {
		return fechaIngreo;
	}

	public void setFechaIngreo(Calendar fechaIngreo) {
		this.fechaIngreo = fechaIngreo;
	}

	public Float getMontoIngreso() {
		return montoIngreso;
	}

	public void setMontoIngreso(Float montoIngreso) {
		this.montoIngreso = montoIngreso;
	}
	
//------------------------------ METODOS ----------------------
	@Override
	public String toString() {
		return this.getNombre()+" "+this.getApellido();
	}
	
	//este metodo ayuda a que se retorne un la fecha con un formato y no toda la fecha que retorna con un monton de letras....
	public String fechaIngr() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
		return sdf.format(fechaIngreo.getTime());
	}

	
	
	

}
