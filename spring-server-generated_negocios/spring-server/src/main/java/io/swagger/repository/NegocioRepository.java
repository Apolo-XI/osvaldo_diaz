package io.swagger.repository;

import java.util.List;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import io.swagger.model.RegistrarRequest;

@EnableScan
public interface NegocioRepository extends CrudRepository<RegistrarRequest, String>{
	public List<RegistrarRequest> findByIdadmin(String Idadmin);
	public List<RegistrarRequest> findByIdnegocio(String Idnegocio);
	public List<RegistrarRequest> findByTipo(String tiponegocio);
	
	//public List<RegistrarRequest> findByToken(String token);
}

