package com.chachalopez.PryCertificacion.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chachalopez.PryCertificacion.models.dao.ICliente;
import com.chachalopez.PryCertificacion.models.entities.Cliente;

@Service
public class ClienteService implements IClienteService{

	@Autowired //Inyeccion de dependencia, para instanciar
	private ICliente dao;//La dao interactua con la base de datos
	
	@Override
	@Transactional
	public void save(Cliente cliente) {
		dao.save(cliente);
		
	}

	@Override
	@Transactional
	public Cliente findById(Integer id) {
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
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) dao.findAll();
	}
}
