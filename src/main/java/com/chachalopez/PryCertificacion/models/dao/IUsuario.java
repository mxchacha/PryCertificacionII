package com.chachalopez.PryCertificacion.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.chachalopez.PryCertificacion.models.entities.Usuario;

public interface IUsuario extends CrudRepository<Usuario,Integer> {

	public Usuario findByNombre(String nombre);
	
}
