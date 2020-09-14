package com.chachalopez.PryCertificacion.models.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


import com.chachalopez.PryCertificacion.models.entities.Cliente;

public interface ICliente extends CrudRepository<Cliente, Integer>{

	public List<Cliente> findByCedulaStartingWith(String cedula);
}
