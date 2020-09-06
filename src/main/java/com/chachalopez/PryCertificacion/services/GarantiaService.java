package com.chachalopez.PryCertificacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chachalopez.PryCertificacion.models.dao.IGarantia;
import com.chachalopez.PryCertificacion.models.entities.Garantia;


@Service
public class GarantiaService implements IGarantiaService{

	@Autowired //Inyección de dependencia
	private IGarantia dao;
		
	@Override
	@Transactional
	public void save(Garantia a) {
		dao.save(a);		
	}

	@Override
	@Transactional
	public Garantia findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);				
	}

	@Override
	@Transactional
	public List<Garantia> findAll() {		
		return (List<Garantia>) dao.findAll();
	}
}
