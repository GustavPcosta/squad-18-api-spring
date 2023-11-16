package com.planetar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.planetar.model.Doador;
import com.planetar.services.DoadorServices;

@Controller
@RequestMapping("/doador")
public class ControllerDoador {

    @Autowired
    private DoadorServices doadorService;

    // Listar
    @GetMapping
    public String listDoador(Model model) {
        List<Doador> doadorList = DoadorServices.getAlLDoador();
        model.addAttribute("doadorList", doadorList);
        return "ListarDoador";
    }

    // Formulário de criação
    @GetMapping("/novo")
    public String showFormForAdd(Model model) {
        Doador doador = new Doador();
        model.addAttribute("doador", doador);
        return "doadorForm";
    }

    // Persistencia da criação
    @PostMapping("/save")
    public String saveDoador(@ModelAttribute("doador") Doador doador) {
        doadorService.saveDoador(doador);
        return "redirect:/doador";
    }

    // Formulário de edição
    @GetMapping("/editar/{id}")
    public String showFormForUpdate(@PathVariable Long id, Model model) {
        Doador doador = DoadorServices.getDoadorById(id);
        model.addAttribute("doador", doador);
        return "editarDoador";
    }

    // Persistencia da edição
    @PostMapping("/editar/{id}")
    public String updateDoador(@PathVariable Long id, @ModelAttribute("doador") Doador doador) {
        doadorService.updateCategoria(id, doador);
        return "redirect:/doador";
    }

    // Excluir doador
    @GetMapping("/deletar/{id}")
    public String deleteDoador(@PathVariable Long id) {
        DoadorServices.deleteDoador(id);
        return "redirect:/doador";
    }
}