package com.chachalopez.PryCertificacion.services;

import java.util.List;

import com.chachalopez.PryCertificacion.models.entities.Cuenta;

public interface ICuentaService {
	public void save(Cuenta cuenta);
	public Cuenta findById(Integer id);
	public void delete(Integer id);
	public List<Cuenta> findAll();

}
