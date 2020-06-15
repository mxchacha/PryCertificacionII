package com.chachalopez.PryCertificacion.services;

import java.util.List;

import com.chachalopez.PryCertificacion.models.entities.Accionista;

public interface IAccionistaService {
	
	public void save(Accionista accionista);
	public Accionista findById(Integer id);
	public void delete(Integer id);
	public List<Accionista> findAll();

}
