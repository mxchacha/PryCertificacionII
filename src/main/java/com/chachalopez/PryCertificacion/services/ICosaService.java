package com.chachalopez.PryCertificacion.services;

import java.util.List;

import com.chachalopez.PryCertificacion.models.entities.Cosa;

public interface ICosaService {
	
	public void save(Cosa cosa);
	public Cosa findById(Integer id);
	public void delete(Integer id);
	public List<Cosa> findAll();

}
