package com.chachalopez.PryCertificacion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chachalopez.PryCertificacion.models.entities.Garantia;

@Controller
@RequestMapping(value="/garantia")  
public class GarantiaController {

	@GetMapping(value="/create") 
	public String create(Model model) {
		Garantia garantia = new Garantia();
		model.addAttribute("garantia", garantia);
		return "garantia/form"; 
	}
}
