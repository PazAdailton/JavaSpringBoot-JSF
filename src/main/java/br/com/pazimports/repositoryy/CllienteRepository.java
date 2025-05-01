package br.com.pazimports.repositoryy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.pazimports.model.Clliente;

@Repository
public interface CllienteRepository extends JpaRepository<Clliente, Long> {
	
	@Query("select c from Clliente c where c.email=:email")
	public Clliente buscarPorEmail(@Param("email")String email);
	
	@Query("select c from Clliente c")
	public List<Clliente> buscarTodos();
	
	//@Query("select c from Clliente c join estado e ")
	//public List<Clliente> clientesComEstado();
	

		
	
}
