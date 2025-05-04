package br.com.pazimports.repositoryy;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.pazimports.model.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
//	@Query("select c from Clliente c where c.email=:email")
//	public Clliente buscarPorEmail(@Param("email")String email);
	
	@Query("select c from Cliente c")
	public List<Cliente> buscarTodos();
	
	@Query("SELECT c FROM Cliente c LEFT JOIN FETCH c.contatos WHERE c.id = :id")
	public Cliente buscarComContatos(@Param("id") Long id);
	
	@Query("SELECT DISTINCT c FROM Cliente c LEFT JOIN FETCH c.contatos LEFT JOIN FETCH c.estado")
	List<Cliente> buscarTodosComContatosEEstado();
	
	


	//@Query("select c from Clliente c join estado e ")
	//public List<Clliente> clientesComEstado();
	

		
	
}
