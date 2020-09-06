package com.chachalopez.PryCertificacion.services;

import java.util.List;

import com.chachalopez.PryCertificacion.models.entities.Deposito;
import com.chachalopez.PryCertificacion.models.reporting.RptDeposito;

public interface IDepositoService {

	public void save(Deposito deposito);
	public Deposito findById(Integer id);
	public void delete(Integer id);
	public List<Deposito> findAll();
//--------------------------Reporte deposito--------------------------
	public List<RptDeposito> rptDeposito();
}
