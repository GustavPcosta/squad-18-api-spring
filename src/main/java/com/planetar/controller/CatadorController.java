package com.planetar.controller;

import org.springframework.stereotype.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.planetar.model.Catadador;
//import com.planetar.model.Doador;
import com.planetar.services.CatadorInterface;
//import com.planetar.services.DoadorServices;
@Controller
@RequestMapping("/catador")
public class CatadorController {
	

		@Autowired
		private CatadorInterface catadorService;

		// Listar
		@GetMapping
		public String listDoador(Model model) {
			List<Catadador> doador = CatadorInterface.getAlLDoador();
			model.addAttribute("doador", doador);
			return "ListarCatador";
		}

		// Formulário de criação
		@GetMapping("/novo")
		public String showFormForAdd(Model model) {
			Catadador doador = new Catadador();
			model.addAttribute("categoria", doador);
			return "CatadorForm";
		}

		// Persistencia da criação
		@PostMapping("/save")
		public String saveCategoria(@ModelAttribute("doador") Catadador catador) {
			catadorService.saveCatador(catador);
			return "redirect:/doador";
		}

		// Formulário de edição
		@GetMapping("/editar/{id}")
		public String showFormForUpdate(@PathVariable Long id, Model model) {
			Catadador catador = catadorService.getDoadorById(id);
			model.addAttribute("catador", catador);
			return "editarCatador";
		}

		// Persistencia da edição
		@PostMapping("/editar/{id}")
		public String updateCategoria(@PathVariable Long id, @ModelAttribute("doador") 
		Catadador doador) {
			catadorService.updateCatador(id, doador);
			return "redirect:/catador";
		}
		
		// Excluir categoria
		@GetMapping("/deletar/{id}")
		public String deleteCategoria(@PathVariable Long id) { 
			catadorService.deleteDoador(id);
			return "redirect:/catador";
		}
}
