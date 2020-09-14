package com.chachalopez.PryCertificacion.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


import org.springframework.web.bind.annotation.ResponseBody;
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
import com.chachalopez.PryCertificacion.models.entities.Garante;
import com.chachalopez.PryCertificacion.services.IClienteService;

@Controller
@RequestMapping(value="/garante")
public class GaranteController {
	
	@GetMapping(value="/create") 
	public String create(Model model) {
		Garante garante = new Garante();
		model.addAttribute("garante", garante);
		return "garante/form"; 
	}

	  
}

