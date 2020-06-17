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

import com.chachalopez.PryCertificacion.models.entities.TipoPrestamo;
import com.chachalopez.PryCertificacion.services.ITipoPrestamoService;

@Controller
@RequestMapping(value="/tipoprestamo")

public class TipoPrestamoController {
	
	  @Autowired
	  private ITipoPrestamoService srvTipoPrestamo;
	  
	  
	
	  
	  @GetMapping(value="/create")
	  public String create(Model model) {
		  TipoPrestamo tipoPrestamo=new TipoPrestamo();
		  model.addAttribute("title", "Registro de nuevo tipo de prestamo");
		  model.addAttribute("tipoPrestamo", tipoPrestamo);/*Similar al ViewBag*/
		  return "tipoPrestamo/form";/*Ubicación de la vista*/
	  }
	  
	  
	  @GetMapping(value="/retrieve/{id}")
	  /*PathVariable es necesatio pata  que funciones el Integer Id*/
	  public String retrieve(@PathVariable(value="id")Integer id,Model model) {
		  TipoPrestamo tipoPrestamo=srvTipoPrestamo.findById(id);
		  model.addAttribute("tipoPrestamo", tipoPrestamo);
		  return "tipoPrestamo/card";
	  }
	  
	  @GetMapping(value="/update/{id}")
	  public String update(@PathVariable(value="id") Integer id,Model model) {
		  TipoPrestamo tipoPrestamo = srvTipoPrestamo.findById(id);
		  model.addAttribute("tipoprestamo", tipoPrestamo);
		  model.addAttribute("title", "Actualizando el registro de " + tipoPrestamo.toString());/*Crear en la Entidad un metodo TpString*/
		  return "tipoPrestamo/form";
	  }
	  
	  @GetMapping(value="/delete/{id}")
		public String delete(@PathVariable(value="id") Integer id, Model model, 
				RedirectAttributes flash) {
			try {
				this.srvTipoPrestamo.delete(id);
				flash.addFlashAttribute("success", "El registro fue eliminado con éxito.");
			}	
			catch(Exception ex) {
				flash.addFlashAttribute("error", "El registro no pudo ser eliminado.");
			}
			return "redirect:/tipoPrestamo/list";		
		} 
	  
	  @GetMapping(value="/list")
		public String list(Model model) {
			List<TipoPrestamo> tipoPrestamos = this.srvTipoPrestamo.findAll();
			model.addAttribute("tipoPrestamos", tipoPrestamos);
			model.addAttribute("title", "Listado de tipo de prestamos");
			return "tipoPrestamo/list";		
		}
	  
	  @PostMapping(value="/save")
	  public String save(TipoPrestamo tipoPrestamo,Model model) {
		  this.srvTipoPrestamo.save(tipoPrestamo);
		  return "redirect:/tipoPrestamo/list";  
	  }

	  
}

