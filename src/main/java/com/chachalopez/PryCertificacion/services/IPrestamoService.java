package com.chachalopez.PryCertificacion.services;

import java.util.List;

import com.chachalopez.PryCertificacion.models.entities.Prestamo;

public interface IPrestamoService {

	public void save(Prestamo prestamo);
	public Prestamo findById(Integer id);
	public void delete(Integer id);
	public List<Prestamo> findAll();
}
