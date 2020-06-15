package com.chachalopez.PryCertificacion.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.chachalopez.PryCertificacion.models.entities.Cuenta;

public interface ICuenta extends CrudRepository<Cuenta, Integer> {

}
