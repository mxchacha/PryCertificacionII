package com.chachalopez.PryCertificacion.models.dao;

import org.springframework.data.repository.CrudRepository;


import com.chachalopez.PryCertificacion.models.entities.Prestamo;

public interface IPrestamo extends CrudRepository<Prestamo, Integer>{

}
