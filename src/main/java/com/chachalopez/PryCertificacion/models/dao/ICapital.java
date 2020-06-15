package com.chachalopez.PryCertificacion.models.dao;

import org.springframework.data.repository.CrudRepository;


import com.chachalopez.PryCertificacion.models.entities.Capital;

public interface ICapital extends CrudRepository<Capital, Integer> {

}
