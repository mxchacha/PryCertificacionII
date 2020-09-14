package com.chachalopez.PryCertificacion.services;

import java.util.List;

import com.chachalopez.PryCertificacion.models.entities.Garante;

public interface IGaranteService {
	public void save(Garante garante);
	public Garante findById(Integer id);
	public void delete(Integer id);
	public List<Garante> findAll();
}
