package com.chachalopez.PryCertificacion.models.reporting;


import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.format.annotation.DateTimeFormat;

public class RptDeposito {
	private static final long serialVersionUID = 1L;
	
	//@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date fechaDeposito;
	
	private Double monto;
	
	public RptDeposito(Double monto, Date fechaDeposito ) {
		super();
		//this.id = id;
		this.monto = monto;
		this.fechaDeposito = fechaDeposito;
		
	}
	
	public RptDeposito() {
		super();
	}

	public Date getFechaDeposito() {
		return fechaDeposito;
	}

	public void setFechaDeposito(Date fechaDeposito) {
		this.fechaDeposito = fechaDeposito;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	//este metodo ayuda a que se retorne un la fecha con un formato y no toda la fecha que retorna con un monton de letras....
		public String fechaDep() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
			return sdf.format(fechaDeposito.getTime());
		}
}
