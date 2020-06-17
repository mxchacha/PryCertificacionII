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

import com.chachalopez.PryCertificacion.models.entities.Retiro;
import com.chachalopez.PryCertificacion.services.IRetiroService;

@Controller
@RequestMapping(value="/retiro")

public class RetiroController {
	
	  @Autowired
	  private IRetiroService srvRetiro;
	  
	  
	
	  
	  @GetMapping(value="/create")
	  public String create(Model model) {
		  Retiro retiro=new Retiro();
		  model.addAttribute("title", "Registro de nuevo retiro");
		  model.addAttribute("retiro", retiro);/*Similar al ViewBag*/
		  return "retiro/form";/*Ubicación de la vista*/
	  }
	  
	  
	  @GetMapping(value="/retrieve/{id}")
	  /*PathVariable es necesatio pata  que funciones el Integer Id*/
	  public String retrieve(@PathVariable(value="id")Integer id,Model model) {
		  Retiro retiro=srvRetiro.findById(id);
		  model.addAttribute("retiro", retiro);
		  return "retiro/card";
	  }
	  
	  @GetMapping(value="/update/{id}")
	  public String update(@PathVariable(value="id") Integer id,Model model) {
		  Retiro retiro = srvRetiro.findById(id);
		  model.addAttribute("retiro", retiro);
		  model.addAttribute("title", "Actualizando el registro con ID" + retiro);/*Crear en la Entidad un metodo TpString*/
		  return "retiro/form";
	  }
	  
	  @GetMapping(value="/delete/{id}")
		public String delete(@PathVariable(value="id") Integer id, Model model, 
				RedirectAttributes flash) {
			try {
				this.srvRetiro.delete(id);
				flash.addFlashAttribute("success", "El registro fue eliminado con éxito.");
			}	
			catch(Exception ex) {
				flash.addFlashAttribute("error", "El registro no pudo ser eliminado.");
			}
			return "redirect:/retiro/list";		
		} 
	  
	  @GetMapping(value="/list")
		public String list(Model model) {
			List<Retiro> retiros = this.srvRetiro.findAll();
			model.addAttribute("retiros", retiros);
			model.addAttribute("title", "Listado de retiros");
			return "retiro/list";		
		}
	  
	  @PostMapping(value="/save")
	  public String save(Retiro retiro,Model model) {
		  this.srvRetiro.save(retiro);
		  return "redirect:/retiro/list";  
	  }

	  
}

