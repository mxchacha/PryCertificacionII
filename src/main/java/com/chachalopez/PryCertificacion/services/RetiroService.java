package com.chachalopez.PryCertificacion.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chachalopez.PryCertificacion.models.dao.IRetiro;
import com.chachalopez.PryCertificacion.models.entities.Retiro;

@Service
public class RetiroService implements IRetiroService {

	@Autowired //Inyeccion de dependencia, para instanciar
	private IRetiro dao;//La dao interactua con la base de datos
	
	@Override
	@Transactional
	public void save(Retiro retiro) {
		dao.save(retiro);
		
	}

	@Override
	@Transactional
	public Retiro findById(Integer id) {
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
	public List<Retiro> findAll() {
		// TODO Auto-generated method stub
		return (List<Retiro>) dao.findAll();
	}
}
