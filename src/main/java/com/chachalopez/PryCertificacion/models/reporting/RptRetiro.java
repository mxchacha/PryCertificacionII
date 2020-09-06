package com.chachalopez.PryCertificacion.models.reporting;


import java.sql.Date;
import java.text.SimpleDateFormat;


import org.springframework.format.annotation.DateTimeFormat;

public class RptRetiro {
	private static final long serialVersionUID = 1L;
	
	//@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date fechaRetiro;
	
	private Double monto;
	
	public RptRetiro(Double monto, Date fechaRetiro ) {
		super();
		//this.id = id;
		this.monto = monto;
		this.fechaRetiro = fechaRetiro;
		
	}
	
	public RptRetiro() {
		super();
	}

	public Date getfechaRetiro() {
		return fechaRetiro;
	}

	public void setfechaRetiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	//este metodo ayuda a que se retorne un la fecha con un formato y no toda la fecha que retorna con un monton de letras....
		public String fechaRet() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
			return sdf.format(fechaRetiro.getTime());
		}
}
