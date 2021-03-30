package com.ac75.web.app.intranet.manual.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clasificaciones")
public class Clasificacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idclasificacion;
	
	@Column(name="nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name="descripcion", length = 200)	
	private String descripcion;
	
	@Column(name="fecharegistro")
	private Date fechaRegistro;
	
	@Column(name="fechaactualiacion")
	private Date fechaActualizacion;
	
	@Column(name = "estado")
	private boolean estado;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "clasificacion")
	private List<Manual> manuales;

	public Long getIdClasificacion() {
		return idclasificacion;
	}

	public void setIdClasificacion(Long idclasificacion) {
		this.idclasificacion = idclasificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public List<Manual> getManuales() {
		return manuales;
	}

	public void setManuales(List<Manual> manuales) {
		this.manuales = manuales;
	}
		
}
