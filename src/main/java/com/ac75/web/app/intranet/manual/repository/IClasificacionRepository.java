package com.ac75.web.app.intranet.manual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ac75.web.app.intranet.manual.domain.Clasificacion;

@Repository
public interface IClasificacionRepository extends JpaRepository<Clasificacion, Long>{

	
}
