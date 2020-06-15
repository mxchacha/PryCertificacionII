package com.chachalopez.PryCertificacion.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chachalopez.PryCertificacion.models.dao.ITipoPrestamo;
import com.chachalopez.PryCertificacion.models.entities.TipoPrestamo;

@Service
public class TipoPrestamoService implements ITipoPrestamoService {

	@Autowired //Inyeccion de dependencia, para instanciar
	private ITipoPrestamo dao;//La dao interactua con la base de datos
	
	@Override
	@Transactional
	public void save(TipoPrestamo tipoPrestamo) {
		dao.save(tipoPrestamo);
		
	}

	@Override
	@Transactional
	public TipoPrestamo findById(Integer id) {
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
	public List<TipoPrestamo> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoPrestamo>) dao.findAll();
	}
}
