package com.planetar.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.planetar.model.Doador;
import com.planetar.model.Empresa;

import com.planetar.services.EmpresaServices;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
	private EmpresaServices empresaService;
	@GetMapping
	public String listDoador(Model model) {
		List<Empresa> empresa = EmpresaServices.getAlLDoador();
		model.addAttribute("empresa", empresa);
		return "ListarEmpresa";
	}
	@GetMapping("/novo")
	public String showFormForAdd(Model model) {
		Doador empresa = new Doador();
		model.addAttribute("empresa", empresa);
		return "empresaForm";
	}
	@PostMapping("/save")
	public String saveCategoria(@ModelAttribute("empresa") Empresa empresa) {
		empresaService.saveEmpresa(empresa, empresa);
		return "redirect:/empresa";
	}
}
