package com.chachalopez.PryCertificacion.services;

import java.util.List;

import com.chachalopez.PryCertificacion.models.entities.TipoPrestamo;

public interface ITipoPrestamoService {
	public void save(TipoPrestamo tipoPrestamo);
	public TipoPrestamo findById(Integer id);
	public void delete(Integer id);
	public List<TipoPrestamo> findAll();
}
