package com.chachalopez.PryCertificacion.services;

import java.util.List;

import com.chachalopez.PryCertificacion.models.entities.TipoCuenta;

public interface ITipoCuentaService {

	public void save(TipoCuenta tipoCuenta);
	public TipoCuenta findById(Integer id);
	public void delete(Integer id);
	public List<TipoCuenta> findAll();
}
