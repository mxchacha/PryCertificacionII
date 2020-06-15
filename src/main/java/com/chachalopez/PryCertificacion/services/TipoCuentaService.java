package com.chachalopez.PryCertificacion.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chachalopez.PryCertificacion.models.dao.ITipoCuenta;
import com.chachalopez.PryCertificacion.models.entities.TipoCuenta;

@Service
public class TipoCuentaService implements ITipoCuentaService {
	@Autowired //Inyeccion de dependencia, para instanciar
	private ITipoCuenta dao;//La dao interactua con la base de datos
	
	@Override
	@Transactional
	public void save(TipoCuenta tipoCuenta) {
		dao.save(tipoCuenta);
		
	}

	@Override
	@Transactional
	public TipoCuenta findById(Integer id) {
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
	public List<TipoCuenta> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoCuenta>) dao.findAll();
	}
}
