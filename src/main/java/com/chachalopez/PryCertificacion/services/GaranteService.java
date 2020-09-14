package com.chachalopez.PryCertificacion.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chachalopez.PryCertificacion.models.dao.IGarante;
import com.chachalopez.PryCertificacion.models.entities.Garante;

@Service
public class GaranteService implements IGaranteService{

	@Autowired //Inyeccion de dependencia, para instanciar
	private IGarante dao;//La dao interactua con la base de datos
	
	@Override
	@Transactional
	public void save(Garante garante) {
		dao.save(garante);
		
	}

	@Override
	@Transactional
	public Garante findById(Integer id) {
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
	public List<Garante> findAll() {
		// TODO Auto-generated method stub
		return (List<Garante>) dao.findAll();
	}
}
