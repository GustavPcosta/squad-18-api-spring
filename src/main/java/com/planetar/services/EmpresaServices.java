package com.planetar.services;
import java.util.List;
import java.util.Set;

import com.planetar.model.Catadador;
import com.planetar.model.Doador;
import com.planetar.model.Empresa;
public interface EmpresaServices {
	List<Empresa> getAllDoador();
	
	 Empresa getEmpresarById(Long id);
	
	Empresa saveEmpresa(Empresa doador, Empresa empresa);
	
	void updateEmpresa(Long id, Empresa doadorAtualizado);
	
	void deleteEmpresa(Long id);

	static List<Empresa> getAlLDoador() {
		// TODO Auto-generated method stub
		return null;
	}

	void saveEmpresa(Catadador catador, Set<Long> empresaIs);

	Empresa saveEmpresa(Empresa empresa);
}
