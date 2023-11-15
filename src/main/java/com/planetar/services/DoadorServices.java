package com.planetar.services;
import java.util.List;
import java.util.Set;


import com.planetar.model.Doador;

public interface DoadorServices {
	
	

	static List<Doador> getAlLDoador() {
		
		return null;
	}
	static Doador getDoadorById(Long id) {
		
		return null;
	}
	
	
	Doador updateDoador(Long id, Doador doadorAtualizado);
	
	static void deleteDoador(Long id) {
		
		
	}

	Doador updateCategoria(Long id, Doador doadorAtualizado);

	static Doador saveDoador(Doador doador, Set<Long> doadorIds) {
		
		return null;
	}
	Doador saveDoador(Doador doador);
	
	}

