package com.chachalopez.PryCertificacion.models.dao;

import org.springframework.data.repository.CrudRepository;


import com.chachalopez.PryCertificacion.models.entities.Cliente;

public interface ICliente extends CrudRepository<Cliente, Integer>{

}
