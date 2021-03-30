package com.ac75.web.app.intranet.manual.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ac75.web.app.intranet.manual.domain.Clasificacion;
import com.ac75.web.app.intranet.manual.service.IClasificacionService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/clasificacion")
public class ClasificacionController {

	private static final String MSJ_EXITO = "Clasificación actualizada correctamente";
	private static final String MSJ_ELIMINACION = "Se ha eliminado la clasificación con identificador: ";
	
	@Autowired
	private IClasificacionService clasificacionService;
	
	@PostMapping(path="registrarClasificacion")
	public ResponseEntity<Object> saveClasificacion(@RequestBody Clasificacion clasificacion){
		 
		try {
			clasificacionService.save(clasificacion);
			return new ResponseEntity<>("Clasificación creada correctamente", HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error, clasificacion no creada", e);
		}		
		
	}
	
	@PutMapping(path = "editarClasificacion/{id}")
	public ResponseEntity<Object> editClasificacion(@RequestBody Clasificacion clasificacion, @PathVariable Long id){
								
		HashMap datos= new HashMap<>();
		datos.put("msj", MSJ_EXITO);
		
		Gson gson = new Gson(); 		
		
		try {
			datos.put("Clasificacion",clasificacionService.edit(clasificacion, id));
			String json = gson.toJson(datos);
			return new ResponseEntity<>(json, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error, clasificacion no editada", e);
		}
		
	}
	
	@CrossOrigin(origins = "*")	
	@GetMapping(path = "obtenerClasificaciones")
	public ResponseEntity<Object> getAllClasificaciones(HttpServletRequest httpServletRequest){
		
		try {
			List<Clasificacion> clasificaciones = clasificacionService.getAllClasificaciones();
			Gson gson = new Gson(); 
			String json = gson.toJson(clasificaciones);
			return new ResponseEntity<>(json, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error, conexion perdida", e);
		}
		
	}
	
	@DeleteMapping("eliminarClasificacion/{id}")
	public ResponseEntity<Object> deleteClasificacion(@PathVariable Long id){
		
		try {
			clasificacionService.delete(id);
			return new ResponseEntity<>(MSJ_ELIMINACION+id, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error, no se pudo eliminar la clasificacion", e);
		}
				
	}
	
	@GetMapping("getClasificacionById/{id}")
	public ResponseEntity<Clasificacion> getClasificacionById(@PathVariable Long id){
		
		try {
			Clasificacion clasificacion = clasificacionService.getClasificacionById(id);
			return new ResponseEntity<>(clasificacion, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error, no se existe la clasificación", e);
		}
		
	}
	
	
	
	
	
}
