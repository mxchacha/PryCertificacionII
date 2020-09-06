package com.chachalopez.PryCertificacion.services;

import java.util.List;

import com.chachalopez.PryCertificacion.models.entities.Retiro;
import com.chachalopez.PryCertificacion.models.reporting.RptRetiro;

public interface IRetiroService {

	public void save(Retiro retiro);
	public Retiro findById(Integer id);
	public void delete(Integer id);
	public List<Retiro> findAll();
//--------------------------Reporte retiro--------------------------
	public List<RptRetiro> rptRetiro();
}
