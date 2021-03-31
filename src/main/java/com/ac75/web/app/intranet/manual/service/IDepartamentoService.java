package com.ac75.web.app.intranet.manual.service;

import java.util.List;

import com.ac75.web.app.intranet.manual.domain.Departamento;

public interface IDepartamentoService {

	Departamento save(Departamento departamento) throws Exception;
	
	Departamento edit(Departamento departamento, Long id) throws Exception;
	
	List<Departamento> getAllDepartamentos();
	
	Departamento getDepartamentoById(Long id) throws Exception;
	
	void delete(Long id) throws Exception;
	
}
