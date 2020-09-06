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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chachalopez.PryCertificacion.models.entities.Cosa;
import com.chachalopez.PryCertificacion.services.ICosaService;



@Controller
@SessionAttributes("cosa")
@RequestMapping(value="/cosa")  
public class CosaController {

	@Autowired 
	private ICosaService srvCosa;
	
	//Cada método en el controlador gestiona una petición al backend
	//a traves de una URL (puede ser -> 1. Escrita en el navegador
	//2. Puede sr Hyperlink, 3. Puede ser un action de un Form)
	
	@GetMapping(value="/create") //https://localhost:8080/cosa/create
	public String create(Model model) {
		Cosa cosa = new Cosa();
		model.addAttribute("title", "Nuevo registro de Objeto@");
		model.addAttribute("cosa", cosa); //similar al ViewBag // Se agrega a Session
		return "cosa/form"; //la ubicación de la vista
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Cosa cosa = srvCosa.findById(id);
		model.addAttribute("title", cosa.toString());
		model.addAttribute("cosa", cosa);		
		return "cosa/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Cosa cosa = srvCosa.findById(id);
		model.addAttribute("cosa", cosa);
		model.addAttribute("title", "Actualizando el registro de " + cosa);
		return "cosa/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvCosa.delete(id);
		return "redirect:/cosa/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Cosa> cosas = srvCosa.findAll();
		model.addAttribute("cosas", cosas);
		model.addAttribute("title", "Listado de cosas");
		return "cosa/list";
	}
	
	
	@PostMapping(value="/save") 
	public String save(@Validated Cosa cosa, BindingResult result, Model model,
			SessionStatus status, RedirectAttributes flash) {
		try {
			
			String message = "Alumn@ agregado correctamente";
			String titulo = "Nuevo registro de alumn@";
			
			if(cosa.getIdcosa() != null) {
				message = "Alumn@ actualizado correctamente";
				titulo = "Actualizando el registro de " + cosa;
			}
						
			if(result.hasErrors()) {
				model.addAttribute("title", titulo);							
				return "cosa/form";				
			}
								
			srvCosa.save(cosa);	
			status.setComplete();
			flash.addFlashAttribute("success", message);
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", ex.getMessage());
		}				
		return "redirect:/cosa/list";
	}
}
