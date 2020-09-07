package com.chachalopez.PryCertificacion.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chachalopez.PryCertificacion.models.entities.Cosa;

public interface ICosa extends CrudRepository<Cosa, Integer> {

	//public List<Cosa> findByIdStartingWith(Integer id);
}
