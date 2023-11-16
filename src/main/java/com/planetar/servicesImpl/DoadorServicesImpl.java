package com.planetar.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planetar.model.Doador;
import com.planetar.repositoery.DoadorRepositorio;
import com.planetar.services.DoadorServices;

@Service
@Transactional
public class DoadorServicesImpl implements DoadorServices {

    @Autowired
    private DoadorRepositorio doadorRepositorio;

    public List<Doador> getAllDoador() {
        return doadorRepositorio.findAll();
    }

    public Doador getDoadorById(Long id) {
        return doadorRepositorio.findById(id).orElse(null);
    }

    public Doador saveDoador(Doador doador) {
        return doadorRepositorio.save(doador);
    }

    public Doador updateCategoria(Long id, Doador doadorAtualizado) {
        Doador doadorExistente = doadorRepositorio.findById(id).orElse(null);
        if (doadorExistente != null) {
            
            doadorExistente.setNome(doadorAtualizado.getNome());
            doadorExistente.setEstado(doadorAtualizado.getEstado());
            doadorExistente.setCidade(doadorAtualizado.getCidade());
            doadorExistente.setBairro(doadorAtualizado.getBairro());
            doadorExistente.setRua(doadorAtualizado.getRua());
            doadorExistente.setTelefone(doadorAtualizado.getTelefone());
            doadorExistente.setCep(doadorAtualizado.getCep());
            doadorExistente.setDisponibilidade(doadorAtualizado.getDisponibilidade());

            return doadorRepositorio.save(doadorExistente);
        } else {
            throw new RuntimeException("Doador com o ID " + id + " não encontrada.");
        }
    }

    public void deleteDoador(Long id) {
        doadorRepositorio.deleteById(id);
    }

	@Override
	public Doador updateDoador(Long id, Doador doadorAtualizado) {
		// TODO Auto-generated method stub
		return null;
	}
}


