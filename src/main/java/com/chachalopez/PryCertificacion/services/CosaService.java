package com.chachalopez.PryCertificacion.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chachalopez.PryCertificacion.models.dao.ICosa;
import com.chachalopez.PryCertificacion.models.entities.Cosa;

@Service
public class CosaService implements ICosaService {

	@Autowired //Inyeccion de dependencia, para instanciar
	private ICosa dao;//La dao interactua con la base de datos
	
	@Override
	@Transactional
	public void save(Cosa cosa) {
		dao.save(cosa);
		
	}

	@Override
	@Transactional
	public Cosa findById(Integer id) {
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
	public List<Cosa> findAll() {
		// TODO Auto-generated method stub
		return (List<Cosa>) dao.findAll();
	}
}
