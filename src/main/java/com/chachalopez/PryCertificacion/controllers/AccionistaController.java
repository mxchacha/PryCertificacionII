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

import com.chachalopez.PryCertificacion.models.entities.Accionista;
import com.chachalopez.PryCertificacion.services.IAccionistaService;

@Controller
@RequestMapping(value="/accionista")
public class AccionistaController {
	
	  @Autowired
	  private IAccionistaService srvAccionista;
	  
	  
	
	  
	  @GetMapping(value="/create")
	  public String create(Model model) {
		  Accionista accionista=new Accionista();
		  model.addAttribute("title", "Registro de nuevo accionista");
		  model.addAttribute("accionista", accionista);/*Similar al ViewBag*/
		  return "accionista/form";/*Ubicación de la vista*/
	  }
	  
	  
	  @GetMapping(value="/retrieve/{id}")
	  /*PathVariable es necesatio pata  que funciones el Integer Id*/
	  public String retrieve(@PathVariable(value="id")Integer id,Model model) {
		  Accionista accionista=srvAccionista.findById(id);
		  model.addAttribute("accionista", accionista);
		  return "accionista/card";
	  }
	  
	  @GetMapping(value="/update/{id}")
	  public String update(@PathVariable(value="id") Integer id,Model model) {
		  Accionista accionista = srvAccionista.findById(id);
		  model.addAttribute("accionista", accionista);
		  model.addAttribute("title", "Actualizando el registro de " + accionista.toString());/*Crear en la Entidad un metodo TpString*/
		  return "accionista/form";
	  }
	  
	  @GetMapping(value="/delete/{id}")
		public String delete(@PathVariable(value="id") Integer id, Model model, 
				RedirectAttributes flash) {
			try {
				this.srvAccionista.delete(id);
				flash.addFlashAttribute("success", "El registro fue eliminado con éxito.");
			}	
			catch(Exception ex) {
				flash.addFlashAttribute("error", "El registro no pudo ser eliminado.");
			}
			return "redirect:/accionista/list";		
		} 
	  
	  @GetMapping(value="/list")
		public String list(Model model) {
			List<Accionista> accionistas = this.srvAccionista.findAll();
			model.addAttribute("accionistas", accionistas);
			model.addAttribute("title", "Listado de Accionistas");
			return "accionista/list";		
		}
	  
	  @PostMapping(value="/save")
	  public String save(Accionista accionista,Model model) {
		  this.srvAccionista.save(accionista);
		  return "redirect:/accionista/list";  
	  }

	  
}

