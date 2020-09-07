package com.chachalopez.PryCertificacion.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chachalopez.PryCertificacion.models.entities.Cosa;
import com.chachalopez.PryCertificacion.models.entities.Cuenta;
import com.chachalopez.PryCertificacion.models.entities.Garantia;
import com.chachalopez.PryCertificacion.models.entities.TipoPrestamo;
import com.chachalopez.PryCertificacion.models.entities.Prestamo;
import com.chachalopez.PryCertificacion.services.ICosaService;
import com.chachalopez.PryCertificacion.services.ICuentaService;
import com.chachalopez.PryCertificacion.services.IGarantiaService;
import com.chachalopez.PryCertificacion.services.IPrestamoService;
import com.chachalopez.PryCertificacion.services.ITipoPrestamoService;



@Controller
@SessionAttributes("prestamo")//significa que cuando se cree algun "prestamo"-"elemento" se guarde por sesion. 
@RequestMapping(value="/prestamo")
public class PrestamoController {
	
	  @Autowired
	  private IPrestamoService srvPrestamo;
	  
	  //refecencia a un servicio de cuenta
	  @Autowired
	  private ICuentaService srvCuenta;
	  
	  //refecencia a un servicio de tipo de cuenta
	  @Autowired
	  private ITipoPrestamoService srvTipoPrestamo;
	  
	  @Autowired
	  private ICosaService srvCosa;
	  
	  /*@Autowired
	  private IGarantiaService srvGarantia;*/

	  @GetMapping(value="/create")
	  public String create(Model model) {
		  
		  Prestamo prestamo = new Prestamo();
		  //---------------------Para el maestro detalle--------------------
		  prestamo.setGarantias(new ArrayList<Garantia>());
		  //-----------------------------------------------------------------
		  model.addAttribute("title", "Registro de nuevo prestamo");
		  model.addAttribute("prestamo", prestamo);/*Similar al ViewBag*/
		  
		  //se va enviar una lista de cuentas
		  List<Cuenta> cuentas = srvCuenta.findAll();
		  model.addAttribute("cuentas", cuentas);
		  //se va enviar una lista de los tipos de cuentas
		  List<TipoPrestamo> tipoprestamos = srvTipoPrestamo.findAll();
		  model.addAttribute("tipoprestamos", tipoprestamos);

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
		  model.addAttribute("title", "Actualizando el registro de " + prestamo.getNumPrestamo());/*Crear en la Entidad un metodo TpString*/
		//se va enviar una lista de cuentas
		  List<Cuenta> cuentas = srvCuenta.findAll();
		  model.addAttribute("cuentas", cuentas);
		  //se va enviar una lista de los tipos de cuentas
		  List<TipoPrestamo> tipoprestamos = srvTipoPrestamo.findAll();
		  model.addAttribute("tipoprestamos", tipoprestamos);
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
	  
	  
	  
	 /* @PostMapping(value="/save")
	  public String save(@Validated Prestamo prestamo,BindingResult result, Model model,SessionStatus status, RedirectAttributes flash, HttpSession session ) {
		
		  Prestamo prestamoSession = (Prestamo) session.getAttribute("Prestamo");
			/*
		  for(Garantia p : prestamoSession.getGarantias()) {
				prestamo.getGarantias().add(p);
			}
			
			srvPrestamo.save(prestamo);
			status.setComplete();
			
		  return "redirect:/prestamo/list";  
	  }*/
	  
	  @PostMapping(value = "/save") // https://localhost:8080/prestamo/save
		public String save(@Validated Prestamo prestamo, BindingResult result, Model model,SessionStatus status, RedirectAttributes flash, HttpSession session) {
			try {
				
				String message = "Prestamo agregado con exito";
				String titulo = "Registro de un nuevo Prestamo";
				
				if(prestamo.getIdprestamo() != null) {
					message = "Prestamo actualizado con exito";
					titulo = "Actualizando Prestamo N°" + prestamo.getIdprestamo();
				}
				
				if(result.hasErrors()) {
					model.addAttribute("title",titulo);
					model.addAttribute("error", "Error agregar prestamo");
					List<TipoPrestamo> tipoprestamo = srvTipoPrestamo.findAll();
					model.addAttribute("tipoPrestamo",tipoprestamo);
					return "gira/form";
				}
				
				/*if (!image.isEmpty()) {				
					Path dir = Paths.get("src//main//resources//static//photos//gira");
					String rootPath = dir.toFile().getAbsolutePath();
					try {
						byte[] bytes = image.getBytes();
						Path rutaCompleta = Paths.get(rootPath + "//" + image.getOriginalFilename());
						Files.write(rutaCompleta, bytes);
						gira.setImagen(image.getOriginalFilename());

					} catch (IOException e) {
						e.printStackTrace();
					}
				}*/
				Prestamo prestamoSession = (Prestamo) session.getAttribute("prestamo");
				for(Garantia p : prestamoSession.getGarantias()) {
					prestamo.getGarantias().add(p);
				}
				
				srvPrestamo.save(prestamo);
				status.setComplete();
				flash.addFlashAttribute("success", message);
			}
			catch(Exception ex) {
				flash.addFlashAttribute("success", ex.getMessage());
			}
			return "redirect:/prestamo/list";		
		}
	  

	  @PostMapping(value = "/add", produces="application/json")
		public @ResponseBody Object add(@RequestBody @Validated Garantia garantia, 
				BindingResult result, Model model, HttpSession session) {				
			try {
				Cosa cosa = this.srvCosa.findById(garantia.getCosaid());	
				//Prestamo prestamo = this.srvPrestamo.findById(garantia.getCosaid());	
				garantia.setObjeto(cosa);
				Prestamo prestamo = (Prestamo) session.getAttribute("prestamo");
				prestamo.getGarantias().add(garantia);
				return garantia;
			} catch (Exception ex) {			
				return ex;
			}		
		}
	   
	  @GetMapping(value = "/things")
		public String things(Model model, HttpSession session) {
			Prestamo prestamo = (Prestamo) session.getAttribute("prestamo");
			model.addAttribute("garantias", prestamo.getGarantias());		
			//model.addAttribute("title", "Listado de garantias");
			return "garantia/list";
		}
}


