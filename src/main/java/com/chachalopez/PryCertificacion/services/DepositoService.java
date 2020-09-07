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

import com.chachalopez.PryCertificacion.models.dao.IDeposito;
import com.chachalopez.PryCertificacion.models.entities.Cuenta;
import com.chachalopez.PryCertificacion.models.entities.Deposito;
import com.chachalopez.PryCertificacion.models.reporting.RptDeposito;


@Service
public class DepositoService implements IDepositoService {
	@Autowired //Inyeccion de dependencia, para instanciar
	private IDeposito dao;//La dao interactua con la base de datos

// ---------------------------------- Reporte de deposito  -----------------------------
// ------------------------ Un vinculo a la base de datos para trabajar -----------------------------
	@PersistenceContext 
	private EntityManager em; //Es la instancia de persistencia con la BDD
	
	@Override
	@Transactional
	public void save(Deposito deposito) {
		
		
		float ingreso;
		ingreso=deposito.getMonto();
		System.out.println(ingreso);
		deposito.getCuenta().ingresar(ingreso);
		
		dao.save(deposito);
		
	}

	@Override
	@Transactional
	public Deposito findById(Integer id) {
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
	public List<Deposito> findAll() {
		// TODO Auto-generated method stub
		return (List<Deposito>) dao.findAll();
	}
	
	
//--------------Metodo para recuperar los datos de la base mediante el procedure y se almacena en un objeto de tipo lista---------
		@Override
		public List<RptDeposito> rptDeposito() {		
			StoredProcedureQuery query = em.createStoredProcedureQuery("reporte_deposito");
			query.execute();
			List<Object[]> datos = query.getResultList();		
			return datos.stream()
					.map(dato -> new RptDeposito((Double)dato[0], (Date)dato[1]))
					.collect(Collectors.toList());		//Se esta mapeando cada atributo.
		}
}
