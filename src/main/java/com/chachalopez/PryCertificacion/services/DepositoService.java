package com.chachalopez.PryCertificacion.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chachalopez.PryCertificacion.models.dao.IDeposito;
import com.chachalopez.PryCertificacion.models.entities.Deposito;

@Service
public class DepositoService implements IDepositoService {
	@Autowired //Inyeccion de dependencia, para instanciar
	private IDeposito dao;//La dao interactua con la base de datos
	
	@Override
	@Transactional
	public void save(Deposito deposito) {
		dao.save(deposito);
		
	}

	@Override
	@Transactional
	public Deposito findById(Integer id) {
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
	public List<Deposito> findAll() {
		// TODO Auto-generated method stub
		return (List<Deposito>) dao.findAll();
	}
}
