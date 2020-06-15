package com.chachalopez.PryCertificacion.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chachalopez.PryCertificacion.models.dao.ICapital;
import com.chachalopez.PryCertificacion.models.entities.Capital;

@Service
public class CapitalService implements ICapitalService {

	@Autowired //Inyeccion de dependencia, para instanciar
	private ICapital dao;//La dao interactua con la base de datos
	
	@Override
	@Transactional
	public void save(Capital capital) {
		dao.save(capital);
		
	}

	@Override
	@Transactional
	public Capital findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional
	public List<Capital> findAll() {
		// TODO Auto-generated method stub
		return (List<Capital>) dao.findAll();
	}
}
