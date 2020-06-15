package com.chachalopez.PryCertificacion.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chachalopez.PryCertificacion.models.dao.IAccionista;
import com.chachalopez.PryCertificacion.models.entities.Accionista;
@Service
public class AccionistaService implements IAccionistaService{

	@Autowired //Inyeccion de dependencia, para instanciar
	private IAccionista dao;//La dao interactua con la base de datos
	
	@Override
	@Transactional
	public void save(Accionista accionista) {
		dao.save(accionista);
		
	}

	@Override
	@Transactional
	public Accionista findById(Integer id) {
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
	public List<Accionista> findAll() {
		// TODO Auto-generated method stub
		return (List<Accionista>) dao.findAll();
	}

}
