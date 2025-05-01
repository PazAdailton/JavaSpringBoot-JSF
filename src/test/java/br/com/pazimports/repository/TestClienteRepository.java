package br.com.pazimports.repository;


import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pazimports.model.Clliente;
import br.com.pazimports.repositoryy.CllienteRepository;
import jakarta.persistence.EntityManager;

@SpringBootTest
@Runwith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestClienteRepository {

	@Autowired
	private CllienteRepository clienteRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	public void testSalvar() {
		
		Clliente cli = new Clliente("Maria", "maria@gmail.com");
		Clliente cliSalvo =  clienteRepository.save(cli);
		
		Assert.assertNotNull(cliSalvo.getId());
		
	}
	
	@Test
	public void testBuscarPorEmail() {
		Clliente cli = new Clliente("João", "João@gmail.com");
		entityManager.persist(cli);
		
	Clliente cliEncontrado =	clienteRepository.buscarPorEmail("João@gmail.com");
	
	assertThat(cliEncontrado.getEmail()).isEqualTo(cli.getEmail());
	assertThat(cliEncontrado.getNome()).isEqualTo(cli.getNome());
		
	}
	
	
	@Test
	public void testBuscarTodos(){
		
		Clliente cli = new Clliente("João", "João@gmail.com");
		entityManager.persist(cli);
		
		Clliente cliJão = new Clliente("Jão", "jao@gmail.com");
		entityManager.persist(cliJão);
		
		List<Clliente> lista = clienteRepository.buscarTodos();
		
		assertThat(lista.get(0).getNome()).isEqualTo(cli.getNome());
		assertThat(lista.get(1).getNome()).isEqualTo(cliJão.getNome());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
