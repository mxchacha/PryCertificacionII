package com.chachalopez.PryCertificacion.services;

import java.util.List;

import com.chachalopez.PryCertificacion.models.entities.Capital;

public interface ICapitalService {
	
	public void save(Capital capital);
	public Capital findById(Integer id);
	public void delete(Integer id);
	public List<Capital> findAll();

}
