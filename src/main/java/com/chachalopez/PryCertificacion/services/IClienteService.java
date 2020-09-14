package com.chachalopez.PryCertificacion.services;

import java.util.List;

import com.chachalopez.PryCertificacion.models.entities.Cliente;

public interface IClienteService {
	public void save(Cliente cliente);
	public Cliente findById(Integer id);
	public void delete(Integer id);
	public List<Cliente> findAll();
	public List<Cliente> findByCedula(String cedula);
}
