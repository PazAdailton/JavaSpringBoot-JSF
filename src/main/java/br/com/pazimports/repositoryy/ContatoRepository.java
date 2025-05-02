package br.com.pazimports.repositoryy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.pazimports.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

	
	@Query("SELECT c FROM Contato c WHERE c.cliente.id = :clienteId")
    List<Contato> buscarPorClienteId(@Param("clienteId") Long clienteId);
	
	
}
