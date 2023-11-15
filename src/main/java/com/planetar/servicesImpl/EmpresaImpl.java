package com.planetar.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;


import com.planetar.model.Empresa;

import com.planetar.repositoery.EmpresaRepositorio;
import com.planetar.services.EmpresaServices;

import jakarta.transaction.Transactional;

@Service
public abstract class EmpresaImpl implements EmpresaServices {
	private EmpresaRepositorio empresaRepositorio;
	public List<Empresa> getAlLDoador() {
		return empresaRepositorio.findAll();
		}
	@Transactional
	public Empresa getDoadorById(Long id) {
		return empresaRepositorio.findById(id).orElse(null);
	}
	@Override
	@Transactional
	public Empresa saveEmpresa(Empresa empresa) {
		return empresaRepositorio.save(empresa);
	}
	
	@Override
	public void updateEmpresa(Long id, Empresa empresaAtualizado) {
		Empresa empresaExistente = empresaRepositorio.findById(id).orElse(null);
		if (empresaExistente != null) { 
			
			empresaExistente.setNome(empresaAtualizado.getNome());
			empresaExistente.setCaracteristica_empresa(empresaAtualizado.getCaracteristica_empresa());
			empresaExistente.setCnpj(empresaAtualizado.getCnpj());
			
		}
	}
}
