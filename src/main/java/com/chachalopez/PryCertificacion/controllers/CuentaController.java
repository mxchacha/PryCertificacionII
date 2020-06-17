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

import com.chachalopez.PryCertificacion.models.entities.Cuenta;
import com.chachalopez.PryCertificacion.services.ICuentaService;

@Controller
@RequestMapping(value="/cuenta")

public class CuentaController {
	
	  @Autowired
	  private ICuentaService srvCuenta;
	  
	  
	
	  
	  @GetMapping(value="/create")
	  public String create(Model model) {
		  Cuenta cuenta=new Cuenta();
		  model.addAttribute("title", "Registro de nueva cuenta");
		  model.addAttribute("cuenta", cuenta);/*Similar al ViewBag*/
		  return "cuenta/form";/*Ubicación de la vista*/
	  }
	  
	  
	  @GetMapping(value="/retrieve/{id}")
	  /*PathVariable es necesatio pata  que funciones el Integer Id*/
	  public String retrieve(@PathVariable(value="id")Integer id,Model model) {
		  Cuenta cuenta=srvCuenta.findById(id);
		  model.addAttribute("cuenta", cuenta);
		  return "cuenta/card";
	  }
	  
	  @GetMapping(value="/update/{id}")
	  public String update(@PathVariable(value="id") Integer id,Model model) {
		  Cuenta cuenta = srvCuenta.findById(id);
		  model.addAttribute("cuenta", cuenta);
		  model.addAttribute("title", "Actualizando el registro " + cuenta);/*Crear en la Entidad un metodo TpString*/
		  return "cuenta/form";
	  }
	  
	  @GetMapping(value="/delete/{id}")
		public String delete(@PathVariable(value="id") Integer id, Model model, 
				RedirectAttributes flash) {
			try {
				this.srvCuenta.delete(id);
				flash.addFlashAttribute("success", "El registro fue eliminado con éxito.");
			}	
			catch(Exception ex) {
				flash.addFlashAttribute("error", "El registro no pudo ser eliminado.");
			}
			return "redirect:/cuenta/list";		
		} 
	  
	  @GetMapping(value="/list")
		public String list(Model model) {
			List<Cuenta> cuentas = this.srvCuenta.findAll();
			model.addAttribute("cuentas", cuentas);
			model.addAttribute("title", "Listado de cuentas");
			return "cuenta/list";		
		}
	  
	  @PostMapping(value="/save")
	  public String save(Cuenta cuenta,Model model) {
		  this.srvCuenta.save(cuenta);
		  return "redirect:/cuenta/list";  
	  }

	  
}

