package com.planetar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.planetar.model.Doador;
import com.planetar.services.DoadorServices;

@Controller
@RequestMapping("/doador")
public class ControllerDoador {

	@Autowired
	private DoadorServices doadorService;

	// Listar
	@GetMapping
	public String listCategorias(Model model) {
		List<Doador> doador = DoadorServices.getAlLDoador();
		model.addAttribute("doador", doador);
		return "ListarCategorias";
	}

	// Formulário de criação
	@GetMapping("/novo")
	public String showFormForAdd(Model model) {
		Doador doador = new Doador();
		model.addAttribute("categoria", doador);
		return "doadorForm";
	}

	// Persistencia da criação
	@PostMapping("/save")
	public String saveCategoria(@ModelAttribute("doador") Doador doador) {
		doadorService.saveDoador(doador);
		return "redirect:/doador";
	}

	// Formulário de edição
	@GetMapping("/editar/{id}")
	public String showFormForUpdate(@PathVariable Long id, Model model) {
		Doador doador = DoadorServices.getDoadorById(id);
		model.addAttribute("categoria", doador);
		return "editarDoador";
	}

	// Persistencia da edição
	@PostMapping("/editar/{id}")
	public String updateCategoria(@PathVariable Long id, @ModelAttribute("doador") 
	Doador catador) {
		doadorService.updateCategoria(id, catador);
		return "redirect:/doador";
	}
	
	// Excluir categoria
	@GetMapping("/deletar/{id}")
	public String deleteCategoria(@PathVariable Long id) { 
		DoadorServices.deleteDoador(id);
		return "redirect:/doador";
	}

}