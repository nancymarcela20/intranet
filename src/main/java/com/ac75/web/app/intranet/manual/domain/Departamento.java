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
@Table(name= "departamentos")
public class Departamento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddepartamento;
	
	@Column(name="nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name="fecharegistro", nullable = false)
	private Date fechaRegistro;
	
	@Column(name="fechaactualiacion", nullable = false)
	private Date fechaActualizacion;
	
	@Column(name = "estado")
	private boolean estado;
	
	@Column(name="codigo", nullable = false, length = 45)
	private String codigo;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento") private
	List<Manual> manuales;
	 

	public Long getIdDepartamento() {
		return iddepartamento;
	}

	public void setIdDepartamento(Long iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	
	public String getNombre() { 
		return nombre; 
	}
	
	public void setNombre(String nombre) { 
		this.nombre = nombre; 
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Manual> getManuales() {
		return manuales;
	}

	public void setManuales(List<Manual> manuales) {
		this.manuales = manuales;
	}
	
	
	
}
