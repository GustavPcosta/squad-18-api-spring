package com.planetar.servicesImpl;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planetar.model.Catadador;
import com.planetar.repositoery.CatadorRepository;
import com.planetar.services.CatadorInterface;

import jakarta.transaction.Transactional;
@Service
public class CatadorImpl implements CatadorInterface{
	
	@Autowired
	private CatadorRepository catadorRepositorio;

	public List<Catadador> getAlLDoador() {
		return catadorRepositorio.findAll();
		}

	@Transactional
	public Catadador getDoadorById(Long id) {
		return catadorRepositorio.findById(id).orElse(null);
	}

	@Transactional
	public Catadador saveDoador(Catadador doador) {
		return catadorRepositorio.save(doador);
	}

	@Override
	public Catadador updateCatador(Long id, Catadador catadorAtualizado) {
		Catadador catadorExistente = catadorRepositorio.findById(id).orElse(null);
		if (catadorExistente != null) { 
			
			catadorExistente.setNome(catadorAtualizado.getNome());
			catadorExistente.setEstado(catadorAtualizado.getEstado());
			catadorExistente.setCidade(catadorAtualizado.getCidade());
			catadorExistente.setBairro(catadorAtualizado.getBairro());
			
			catadorExistente.setTelefone(catadorAtualizado.getTelefone());
			
			
			catadorExistente.setCep(catadorAtualizado.getCep());
			catadorExistente.setDisponibilidade(catadorAtualizado.getDisponibilidade());
			
			
			
			return catadorRepositorio.save(catadorExistente);
		} else { 
			throw new RuntimeException("Doador com o ID" + id + "não encontrada.");
		}
	}

	public void deleteDoador(Long id) {
		catadorRepositorio.deleteById(id);
	}

	@Override
	public List<CatadorInterface> getAllDoador() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Catadador getCatadorById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Catadador saveCatadador(CatadorInterface catador, Set<Long> catadorIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCatador(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveCatador(Catadador catador) {
		// TODO Auto-generated method stub
		
	}
}
