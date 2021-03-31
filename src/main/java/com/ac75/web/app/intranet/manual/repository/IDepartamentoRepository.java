package com.ac75.web.app.intranet.manual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ac75.web.app.intranet.manual.domain.Departamento;

@Repository
public interface IDepartamentoRepository extends JpaRepository<Departamento, Long>{
	
	Departamento findByCodigo(String codigo);
	
}
