package com.chachalopez.PryCertificacion.services;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chachalopez.PryCertificacion.models.dao.IRetiro;
import com.chachalopez.PryCertificacion.models.entities.Retiro;
import com.chachalopez.PryCertificacion.models.reporting.RptRetiro;

@Service
public class RetiroService implements IRetiroService {

	@Autowired //Inyeccion de dependencia, para instanciar
	private IRetiro dao;//La dao interactua con la base de datos
// ---------------------------------- Reporte de retiro  -----------------------------
// ------------------------ Un vinculo a la base de datos para trabajar -----------------------------
	@PersistenceContext 
	private EntityManager em; //Es la instancia de persistencia con la BDD
	
	@Override
	@Transactional
	public void save(Retiro retiro) {
		dao.save(retiro);
		
	}

	@Override
	@Transactional
	public Retiro findById(Integer id) {
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
	public List<Retiro> findAll() {
		// TODO Auto-generated method stub
		return (List<Retiro>) dao.findAll();
	}
	
//--------------Metodo para recuperar los datos de la base mediante el procedure y se almacena en un objeto de tipo lista---------
		@Override
		public List<RptRetiro> rptRetiro() {		
			StoredProcedureQuery query = em.createStoredProcedureQuery("reporte_retiro");
			query.execute();
			List<Object[]> datos = query.getResultList();		
			return datos.stream()
					.map(dato -> new RptRetiro((Double)dato[0], (Date)dato[1]))
					.collect(Collectors.toList());		//Se esta mapeando cada atributo.
		}
}
