package br.com.pazimports.controller1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.pazimports.model.Cliente;
import br.com.pazimports.model.Contato;
import br.com.pazimports.repositoryy.ClienteRepository;
import br.com.pazimports.repositoryy.ContatoRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;


@Named
@ViewScoped
public class CllienteController {
		
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ContatoRepository contatoRepository;

	
	private List<Contato> contatos = new ArrayList<Contato>();
	private Contato contato;
	private String descricaoContato;
	
	private Cliente cliente = new Cliente();
	private List<Cliente> clientes;
	private boolean modoEdicao=false;
	
	@PostConstruct
	public void init() {
		clientes = clienteRepository.findAll();
		setContatos(contatoRepository.findAll());
	}
	
	
	
	public void adicionarContato() {

		Contato contato = new Contato();
		contato.setDescricao(descricaoContato);
		contato.setCliente(cliente);
		
		cliente.getContatos().add(contato);
		this.descricaoContato = "";
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
		this.cliente = c;
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

	public String getDescricaoContato() {
		return descricaoContato;
	}

	public void setDescricaoContato(String descricaoContato) {
		this.descricaoContato = descricaoContato;
	}



	public List<Contato> getContatos() {
		return contatos;
	}



	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}



	public Contato getContato() {
		return contato;
	}



	public void setContato(Contato contato) {
		this.contato = contato;
	}

}
