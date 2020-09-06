package com.chachalopez.PryCertificacion.services;

import java.util.List;

import com.chachalopez.PryCertificacion.models.entities.Garantia;



public interface IGarantiaService {
	
	public void save(Garantia a);
	public Garantia findById(Integer id);
	public void delete(Integer id);
	public List<Garantia> findAll();

}
