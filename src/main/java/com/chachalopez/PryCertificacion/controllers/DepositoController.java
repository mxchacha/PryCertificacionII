package com.chachalopez.PryCertificacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chachalopez.PryCertificacion.models.entities.Cuenta;
import com.chachalopez.PryCertificacion.models.entities.Deposito;
import com.chachalopez.PryCertificacion.models.reporting.RptDeposito;
import com.chachalopez.PryCertificacion.services.ICuentaService;
import com.chachalopez.PryCertificacion.services.IDepositoService;

@Controller
@RequestMapping(value="/deposito")

public class DepositoController {
	
	  @Autowired
	  private IDepositoService srvDeposito;
	  
	//refecencia a un servicio de accionista
	  @Autowired
	  private ICuentaService srvCuenta;
	
	  
	  @GetMapping(value="/create")
	  public String create(Model model) {
		  Deposito deposito=new Deposito();
		  model.addAttribute("title", "Registro de nuevo deposito");
		  model.addAttribute("deposito", deposito);/*Similar al ViewBag*/
		  //se va enviar una lista de accionistas
		  List<Cuenta> cuentas = srvCuenta.findAll();
		  model.addAttribute("cuentas", cuentas);
		  return "deposito/form";/*Ubicación de la vista*/
	  }
	  
	  
	  @GetMapping(value="/retrieve/{id}")
	  /*PathVariable es necesatio pata  que funciones el Integer Id*/
	  public String retrieve(@PathVariable(value="id")Integer id,Model model) {
		  Deposito deposito=srvDeposito.findById(id);
		  model.addAttribute("deposito", deposito);
		  return "deposito/card";
	  }
	  
	  @GetMapping(value="/update/{id}")
	  public String update(@PathVariable(value="id") Integer id,Model model) {
		  Deposito deposito = srvDeposito.findById(id);
		  model.addAttribute("deposito", deposito);
		  model.addAttribute("title", "Actualizando el registro con ID " + deposito);/*Crear en la Entidad un metodo TpString*/
		  //se va enviar una lista de accionistas
		  List<Cuenta> cuentas = srvCuenta.findAll();
		  model.addAttribute("cuentas", cuentas);
		  return "deposito/form";
	  }
	  
	  @GetMapping(value="/delete/{id}")
		public String delete(@PathVariable(value="id") Integer id, Model model, 
				RedirectAttributes flash) {
			try {
				this.srvDeposito.delete(id);
				flash.addFlashAttribute("success", "El registro fue eliminado con éxito.");
			}	
			catch(Exception ex) {
				flash.addFlashAttribute("error", "El registro no pudo ser eliminado.");
			}
			return "redirect:/deposito/list";		
		} 
	  
	  @GetMapping(value="/list")
		public String list(Model model) {
			List<Deposito> depositos = this.srvDeposito.findAll();
			model.addAttribute("depositos", depositos);
			model.addAttribute("title", "Listado de depositos");
			return "deposito/list";		
		}
	  
	  @PostMapping(value="/save")
	  public String save(Deposito deposito,Model model) {
		  this.srvDeposito.save(deposito);
		  return "redirect:/deposito/list";  
	  }
	  
//-------------------------Reporte de deposito-------------------------------------------
		//Hasta aqui bien
		@GetMapping(value = "/rptDeposito")
		public String rptDeposito(Model model) {
			return "deposito/rptDeposito";				
		}
		
		 
		@GetMapping(value = "/dataRptDeposito", produces="application/json")
		public @ResponseBody List<RptDeposito> dataRptDeposito(Model model) {				
			try {			
				return this.srvDeposito.rptDeposito();
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				return null;
			}		
		}
	  
}

