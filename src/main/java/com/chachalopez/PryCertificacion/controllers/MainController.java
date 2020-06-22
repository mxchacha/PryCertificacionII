package com.chachalopez.PryCertificacion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value= {"/","/index.html"})
public class MainController {
	
	@GetMapping(value="/")
	  public String home(Model model) {
		  
		  return "index";/*Ubicación de la vista*/
	  }
	
	@GetMapping(value="/tables.html")
	public String tables(Model model) {						
		return "tables";
	}
	
	@GetMapping(value="/register.html")
	public String register(Model model) {						
		return "register";
	}
	/*
	@GetMapping(value="/home.html")
	public String index(Model model) {						
		return "home";
	}*/

}
