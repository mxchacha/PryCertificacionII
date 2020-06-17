package com.chachalopez.PryCertificacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chachalopez.PryCertificacion.models.entities.Prestamo;
import com.chachalopez.PryCertificacion.services.IPrestamoService;

@Controller
@RequestMapping(value="/prestamo")

public class PrestamoController {
	
	  @Autowired
	  private IPrestamoService srvPrestamo;
	  
	  
	
	  
	  @GetMapping(value="/create")
	  public String create(Model model) {
		  Prestamo prestamo=new Prestamo();
		  model.addAttribute("title", "Registro de nuevo prestamo");
		  model.addAttribute("prestamo", prestamo);/*Similar al ViewBag*/
		  return "prestamo/form";/*Ubicación de la vista*/
	  }
	  
	  
	  @GetMapping(value="/retrieve/{id}")
	  /*PathVariable es necesatio pata  que funciones el Integer Id*/
	  public String retrieve(@PathVariable(value="id")Integer id,Model model) {
		  Prestamo prestamo=srvPrestamo.findById(id);
		  model.addAttribute("prestamo", prestamo);
		  return "prestamo/card";
	  }
	  
	  @GetMapping(value="/update/{id}")
	  public String update(@PathVariable(value="id") Integer id,Model model) {
		  Prestamo prestamo = srvPrestamo.findById(id);
		  model.addAttribute("prestamo", prestamo);
		  model.addAttribute("title", "Actualizando el registro de " + prestamo.toString());/*Crear en la Entidad un metodo TpString*/
		  return "prestamo/form";
	  }
	  
	  @GetMapping(value="/delete/{id}")
		public String delete(@PathVariable(value="id") Integer id, Model model, 
				RedirectAttributes flash) {
			try {
				this.srvPrestamo.delete(id);
				flash.addFlashAttribute("success", "El registro fue eliminado con éxito.");
			}	
			catch(Exception ex) {
				flash.addFlashAttribute("error", "El registro no pudo ser eliminado.");
			}
			return "redirect:/prestamo/list";		
		} 
	  
	  @GetMapping(value="/list")
		public String list(Model model) {
			List<Prestamo> prestamos = this.srvPrestamo.findAll();
			model.addAttribute("prestamos", prestamos);
			model.addAttribute("title", "Listado de prestamos");
			return "prestamo/list";		
		}
	  
	  @PostMapping(value="/save")
	  public String save(Prestamo prestamo,Model model) {
		  this.srvPrestamo.save(prestamo);
		  return "redirect:/prestamo/list";  
	  }

	  
}

