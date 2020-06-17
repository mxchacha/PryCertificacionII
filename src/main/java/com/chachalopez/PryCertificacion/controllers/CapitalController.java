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

import com.chachalopez.PryCertificacion.models.entities.Capital;
import com.chachalopez.PryCertificacion.services.ICapitalService;

@Controller
@RequestMapping(value="/capital")
public class CapitalController {
	
	  @Autowired
	  private ICapitalService srvCapital;
	  
	  
	
	  
	  @GetMapping(value="/create")
	  public String create(Model model) {
		  Capital capital=new Capital();
		  model.addAttribute("title", "Registro de nuevo capital");
		  model.addAttribute("capital", capital);/*Similar al ViewBag*/
		  return "capital/form";/*Ubicación de la vista*/
	  }
	  
	  
	  @GetMapping(value="/retrieve/{id}")
	  /*PathVariable es necesatio pata  que funciones el Integer Id*/
	  public String retrieve(@PathVariable(value="id")Integer id,Model model) {
		  Capital capital=srvCapital.findById(id);
		  model.addAttribute("capital", capital);
		  return "capital/card";
	  }
	  
	  @GetMapping(value="/update/{id}")
	  public String update(@PathVariable(value="id") Integer id,Model model) {
		  Capital capital = srvCapital.findById(id);
		  model.addAttribute("capital", capital);
		  model.addAttribute("title", "Actualizando el registro con ID " + capital);/*Crear en la Entidad un metodo TpString*/
		  return "capital/form";
	  }
	  
	  @GetMapping(value="/delete/{id}")
		public String delete(@PathVariable(value="id") Integer id, Model model, 
				RedirectAttributes flash) {
			try {
				this.srvCapital.delete(id);
				flash.addFlashAttribute("success", "El registro fue eliminado con éxito.");
			}	
			catch(Exception ex) {
				flash.addFlashAttribute("error", "El registro no pudo ser eliminado.");
			}
			return "redirect:/capital/list";		
		} 
	  
	  @GetMapping(value="/list")
		public String list(Model model) {
			List<Capital> capitales = this.srvCapital.findAll();
			model.addAttribute("capitales", capitales);
			model.addAttribute("title", "Listado de capitales");
			return "capital/list";		
		}
	  
	  @PostMapping(value="/save")
	  public String save(Capital capital,Model model) {
		  this.srvCapital.save(capital);
		  return "redirect:/capital/list";  
	  }

	  
}

