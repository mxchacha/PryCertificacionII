package com.chachalopez.PryCertificacion.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chachalopez.PryCertificacion.models.dao.ICuenta;
import com.chachalopez.PryCertificacion.models.entities.Cuenta;

@Service
public class CuentaService implements ICuentaService {

	@Autowired //Inyeccion de dependencia, para instanciar
	private ICuenta dao;//La dao interactua con la base de datos
	
	@Override
	@Transactional
	public void save(Cuenta cuenta) {
		dao.save(cuenta);
		
	}

	@Override
	@Transactional
	public Cuenta findById(Integer id) {
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
	public List<Cuenta> findAll() {
		// TODO Auto-generated method stub
		return (List<Cuenta>) dao.findAll();
	}
}
