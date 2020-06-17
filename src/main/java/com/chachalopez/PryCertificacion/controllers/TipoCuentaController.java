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

import com.chachalopez.PryCertificacion.models.entities.TipoCuenta;
import com.chachalopez.PryCertificacion.services.ITipoCuentaService;

@Controller
@RequestMapping(value="/tipoCuenta")

public class TipoCuentaController {
	
	  @Autowired
	  private ITipoCuentaService srvTipoCuenta;
	  
	  
	
	  
	  @GetMapping(value="/create")
	  public String create(Model model) {
		  TipoCuenta tipoCuenta=new TipoCuenta();
		  model.addAttribute("title", "Registro de nuevo tipo de cuenta");
		  model.addAttribute("tipoCuenta", tipoCuenta);/*Similar al ViewBag*/
		  return "tipoCuenta/form";/*Ubicación de la vista*/
	  }
	  
	  
	  @GetMapping(value="/retrieve/{id}")
	  /*PathVariable es necesatio pata  que funciones el Integer Id*/
	  public String retrieve(@PathVariable(value="id")Integer id,Model model) {
		  TipoCuenta tipoCuenta=srvTipoCuenta.findById(id);
		  model.addAttribute("tipoCuenta", tipoCuenta);
		  return "tipoCuenta/card";
	  }
	  
	  @GetMapping(value="/update/{id}")
	  public String update(@PathVariable(value="id") Integer id,Model model) {
		  TipoCuenta tipoCuenta = srvTipoCuenta.findById(id);
		  model.addAttribute("tipoCuenta", tipoCuenta);
		  model.addAttribute("title", "Actualizando el registro de " + tipoCuenta.toString());/*Crear en la Entidad un metodo TpString*/
		  return "tipoCuenta/form";
	  }
	  
	  @GetMapping(value="/delete/{id}")
		public String delete(@PathVariable(value="id") Integer id, Model model, 
				RedirectAttributes flash) {
			try {
				this.srvTipoCuenta.delete(id);
				flash.addFlashAttribute("success", "El registro fue eliminado con éxito.");
			}	
			catch(Exception ex) {
				flash.addFlashAttribute("error", "El registro no pudo ser eliminado.");
			}
			return "redirect:/tipoCuenta/list";		
		} 
	  
	  @GetMapping(value="/list")
		public String list(Model model) {
			List<TipoCuenta> tipoCuentas = this.srvTipoCuenta.findAll();
			model.addAttribute("tipoCuentas", tipoCuentas);
			model.addAttribute("title", "Listado de tipo de Cuentas");
			return "tipoCuenta/list";		
		}
	  
	  @PostMapping(value="/save")
	  public String save(TipoCuenta tipoCuenta,Model model) {
		  this.srvTipoCuenta.save(tipoCuenta);
		  return "redirect:/tipoCuenta/list";  
	  }

	  
}

