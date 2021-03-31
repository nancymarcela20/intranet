package com.ac75.web.app.intranet.manual.service;

import java.util.List;

import com.ac75.web.app.intranet.manual.domain.Clasificacion;

public interface IClasificacionService {

	Clasificacion save(Clasificacion clasificacion) throws Exception;
	
	Clasificacion edit(Clasificacion clasificacion, Long id) throws Exception;
	
	List<Clasificacion> getAllClasificaciones();
	
	Clasificacion getClasificacionById(Long id) throws Exception;
	
	void delete(Long id) throws Exception;
		
	
}
