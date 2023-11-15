package com.planetar.services;
import java.util.List;
import java.util.Set;

import com.planetar.model.Catadador;

public interface CatadorInterface {
	List<CatadorInterface> getAllDoador();
	
	Catadador getCatadorById(Long id);
	
	Catadador saveCatadador(CatadorInterface catador, Set<Long> catadorIds);
	
	Catadador updateCatador(Long id, Catadador doadorAtualizado);
	
	void deleteCatador(Long id);

	static List<Catadador> getAlLDoador() {
		
		return null;
	}

	Catadador getDoadorById(Long id);

	void deleteDoador(Long id);

	void saveCatador(Catadador catador);
}
