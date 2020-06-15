package com.chachalopez.PryCertificacion.models.dao;

import org.springframework.data.repository.CrudRepository;


import com.chachalopez.PryCertificacion.models.entities.TipoCuenta;

public interface ITipoCuenta extends CrudRepository<TipoCuenta, Integer>{

}
