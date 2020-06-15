package com.chachalopez.PryCertificacion.models.dao;

import org.springframework.data.repository.CrudRepository;


import com.chachalopez.PryCertificacion.models.entities.TipoPrestamo;

public interface ITipoPrestamo extends CrudRepository<TipoPrestamo, Integer> {

}
