package com.ac75.web.app.intranet.manual.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ac75.web.app.intranet.manual.domain.Departamento;
import com.ac75.web.app.intranet.manual.repository.IDepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements IDepartamentoService{

	private static final String MSJ_EL_NOMBRE_DEL_DEPARTAMENTO_ES_REQUERIDO = "El nombre del departamento es requerido";
	private static final String MSJ_EL_CODIGO_DEL_DEPARTAMENTO_ES_REQUERIDO = "El código del departamento es requerido";	
	private static final String MSJ_EL_DEPARTAMENTO_NO_EXISTE = "El departamento no existe";
	private static final String YA_EXISTE_UN_DEPARTAMENTO_REGISTRADO_CON_ESTE_CODIGO = "Ya existe un departamento creado con este código";
	
	@Autowired
	private IDepartamentoRepository departamentoRepository;
	
	@Override
	public Departamento save(Departamento departamento) throws Exception {
		
		if(departamento.getCodigo().isEmpty()) {
			throw new Exception(MSJ_EL_CODIGO_DEL_DEPARTAMENTO_ES_REQUERIDO);
		}
		
		if(departamentoRepository.findByCodigo(departamento.getCodigo())!=null) {
			throw new Exception(YA_EXISTE_UN_DEPARTAMENTO_REGISTRADO_CON_ESTE_CODIGO);
		}
		
		if(departamento.getNombre().isEmpty()) {
			throw new Exception(MSJ_EL_NOMBRE_DEL_DEPARTAMENTO_ES_REQUERIDO);
		}
		
		Date fecha = new Date();
		
		departamento.setFechaRegistro(fecha);
		departamento.setFechaActualizacion(fecha);
		departamento.setEstado(true);		
		
		
		return departamentoRepository.save(departamento);
	}

	@Override
	public Departamento edit(Departamento departamento, Long id) throws Exception {
		
		Departamento departamentobd = departamentoRepository.findById(id).get();
		
		if(departamentobd==null)
			throw new Exception(MSJ_EL_DEPARTAMENTO_NO_EXISTE);
		
		if(departamento.getNombre().isEmpty())
			throw new Exception(MSJ_EL_NOMBRE_DEL_DEPARTAMENTO_ES_REQUERIDO);
		
		if(departamento.getCodigo().isEmpty()){
			throw new Exception(MSJ_EL_CODIGO_DEL_DEPARTAMENTO_ES_REQUERIDO);
		}
		
		departamentobd.setFechaActualizacion(new Date());
		departamentobd.setNombre(departamento.getNombre());
		departamentobd.setCodigo(departamento.getCodigo());
		departamentobd.setEstado(departamento.isEstado());
		
		return departamentoRepository.save(departamentobd);
	}

	@Override
	public List<Departamento> getAllDepartamentos() {
		
		return departamentoRepository.findAll();
	}

	@Override
	public Departamento getDepartamentoById(Long id) throws Exception {
		Departamento departamento = departamentoRepository.findById(id).get();
		if(departamento == null)
			throw new Exception(MSJ_EL_DEPARTAMENTO_NO_EXISTE);
						
		return departamento;
	}
	
	@Override
	public void delete(Long id) throws Exception {
		if(!departamentoRepository.existsById(id))
			throw new Exception(MSJ_EL_DEPARTAMENTO_NO_EXISTE);
		
		departamentoRepository.deleteById(id);		
	}
	
}
