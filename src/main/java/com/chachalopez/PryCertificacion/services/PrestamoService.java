package com.chachalopez.PryCertificacion.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chachalopez.PryCertificacion.models.dao.IGarantia;
import com.chachalopez.PryCertificacion.models.dao.IPrestamo;
import com.chachalopez.PryCertificacion.models.entities.Garantia;
import com.chachalopez.PryCertificacion.models.entities.Prestamo;

@Service
public class PrestamoService implements IPrestamoService {

	@Autowired //Inyeccion de dependencia, para instanciar
	private IPrestamo dao;//La dao interactua con la base de datos
	
	//Dao de Garantia
	@Autowired
	private IGarantia daoGarantia;
	
	//@Override
	@Transactional
	public void save(Prestamo p) {
		try {
			dao.save(p);
			for(Garantia g: p.getGarantias()) {
				g.setPrestamo(p);
				this.daoGarantia.save(g);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	
	@Transactional
	public Prestamo findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}


	@Transactional
	public List<Prestamo> findAll() {
		// TODO Auto-generated method stub
		return (List<Prestamo>) dao.findAll();
	}
}
