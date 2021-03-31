package com.ac75.web.app.intranet.manual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ac75.web.app.intranet.manual.domain.Manual;

@Repository
public interface IManualRepository extends JpaRepository<Manual, Long>{

	
}
