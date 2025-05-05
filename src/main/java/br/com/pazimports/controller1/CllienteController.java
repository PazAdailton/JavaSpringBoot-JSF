package br.com.pazimports.controller1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.pazimports.model.Cliente;
import br.com.pazimports.model.Contato;
import br.com.pazimports.repositoryy.ClienteRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;


@Named
@ViewScoped
public class CllienteController {
		
	@Autowired
	private ClienteRepository clienteRepository;
	
	private Contato contato = new Contato();

	
	private Cliente cliente = new Cliente();
	private List<Cliente> clientes;
	private boolean modoEdicao=false;
	
	@PostConstruct
	public void init() {
		clientes = clienteRepository.findAll();
	}
	
	
	
	public void adicionarContato() {

		contato.setCliente(cliente);
		cliente.getContatos().add(contato);
		contato = new Contato();
	}
	
	public void removerContato(Contato c) {
		cliente.getContatos().remove(c);
	}
	
	public void salvar() {
		clienteRepository.save(cliente);
		if(!isModoEdicao())
		clientes.add(cliente);
		cliente = new Cliente();
		setModoEdicao(false);
	}
	
	public void excluir(Cliente c) {
		clienteRepository.delete(c);
		clientes.remove(c);
	}
	
	public void editar(Cliente c) {
		setModoEdicao(true);
		this.cliente  = clienteRepository.findById(c.getId()).orElse(null);
	}
	
	public void cancelar() {
		cliente = new Cliente();
		modoEdicao = false;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}


	public boolean isModoEdicao() {
		return modoEdicao;
	}

	public void setModoEdicao(boolean modoEdicao) {
		this.modoEdicao = modoEdicao;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}


}
