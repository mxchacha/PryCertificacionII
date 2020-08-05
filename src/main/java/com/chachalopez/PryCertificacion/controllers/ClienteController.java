package com.chachalopez.PryCertificacion.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chachalopez.PryCertificacion.models.entities.Cliente;
import com.chachalopez.PryCertificacion.services.IClienteService;

@Controller
@RequestMapping(value="/cliente")
public class ClienteController {
	
	  @Autowired
	  private IClienteService srvCliente;
	  
	  
	
	  
	  @GetMapping(value="/create")
	  public String create(Model model) {
		  Cliente cliente=new Cliente();
		  model.addAttribute("title", "Registro de nuevo cliente");
		  model.addAttribute("cliente", cliente);/*Similar al ViewBag*/
		  return "cliente/form";/*Ubicación de la vista*/
	  }
	  
	  
	  @GetMapping(value="/retrieve/{id}")
	  /*PathVariable es necesatio pata  que funciones el Integer Id*/
	  public String retrieve(@PathVariable(value="id")Integer id,Model model) {
		  Cliente cliente=srvCliente.findById(id);
		  model.addAttribute("cliente", cliente);
		  return "cliente/card";
	  }
	  
	  @GetMapping(value="/update/{id}")
	  public String update(@PathVariable(value="id") Integer id,Model model) {
		  Cliente cliente = srvCliente.findById(id);
		  model.addAttribute("cliente", cliente);
		  model.addAttribute("title", "Actualizando el registro de " + cliente.toString());/*Crear en la Entidad un metodo TpString*/
		  return "cliente/form";
	  }
	  
	  @GetMapping(value="/delete/{id}")
		public String delete(@PathVariable(value="id") Integer id, Model model, 
				RedirectAttributes flash) {
			try {
				this.srvCliente.delete(id);
				flash.addFlashAttribute("success", "El registro fue eliminado con éxito.");
			}	
			catch(Exception ex) {
				flash.addFlashAttribute("error", "El registro no pudo ser eliminado.");
			}
			return "redirect:/cliente/list";		
		} 
	  
	  @GetMapping(value="/list")
		public String list(Model model) {
			List<Cliente> clientes = this.srvCliente.findAll();
			model.addAttribute("clientes", clientes);
			model.addAttribute("title", "Listado de clientes");
			return "cliente/list";		
		}
	  
	  @PostMapping(value="/save")
	  public String save(@Validated Cliente cliente,Model model,  BindingResult result,
				SessionStatus status, RedirectAttributes flash) {
		  
		  
		  try {
				
				String message = "Cliente agregado correctamente";
				String titulo = "Nuevo registro de cliente";
				
				if(cliente.getIdpersona() != null) {
					message = "Cliente actualizado correctamente";
					titulo = "Actualizando el registro de " + cliente;
				}
							
				if(result.hasErrors()) {
					model.addAttribute("title", titulo);							
					return "cliente/form";				
				}											
				srvCliente.save(cliente);	
				status.setComplete();
				flash.addFlashAttribute("success", message);
			}
			catch(Exception ex) {
				flash.addFlashAttribute("error", ex.getMessage());
			}				
			return "redirect:/cliente/list";
		  
		  
	  }

	  
}

