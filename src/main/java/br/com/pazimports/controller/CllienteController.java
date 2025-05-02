package br.com.pazimports.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.pazimports.model.Clliente;
import br.com.pazimports.model.Contato;
import br.com.pazimports.model.Estado;
import br.com.pazimports.repositoryy.CllienteRepository;
import br.com.pazimports.repositoryy.ContatoRepository;
import br.com.pazimports.repositoryy.EstadoRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;


@Named
@ViewScoped
public class CllienteController {

	@Autowired
	private CllienteRepository clienteRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	private Estado estado;
	private List<Estado> estados;
	private Contato cont = new Contato();
	private List<Contato> contatos;
	private String descricaoContato;


	private Clliente cliente = new Clliente();
	private List<Clliente> clientes;
	private boolean modoEdicao = false;
	
	@PostConstruct
	public void init() {
		if (cliente == null) {
	        cliente = new Clliente();
	    }
		 cliente.setEstado(new Estado());
		 cliente.setContatos(new ArrayList<>());
		setClientes(clienteRepository.buscarTodos());
		setEstados(estadoRepository.findAll());
		setContatos(contatoRepository.findAll());
	}
	
	public void adicionarContato() {
		if(cont == null) {
			throw new IllegalArgumentException();
		}
		if (cliente.getEstado() == null) {
	        cliente.setEstado(new Estado()); // 🔧 Garante que não seja nulo
	    }
		cont.setDescricao(this.descricaoContato);
		cont.setCliente(cliente);
	    this.cliente.getContatos().add(cont);
	    this.cont = new Contato();
	    this.descricaoContato = "";
	}
	public void removerContato() {
		List<Contato> lista = cliente.getContatos();
	    if (lista != null && !lista.isEmpty()) {
	        lista.remove(lista.size() - 1);
	    }
	}

	
	public void salvar() {

		if(!isModoEdicao())
		clientes.add(cliente);
		clienteRepository.save(cliente);
		this.clientes = clienteRepository.buscarTodos();
		cliente = new Clliente();
		setModoEdicao(false);
	}
	public void excluir(Clliente cliente) {
		clienteRepository.delete(cliente);
		clientes.remove(cliente);
		cliente = new Clliente();
	}
	
	public void editar(Clliente c) {
		this.cliente = clienteRepository.buscarComContatos(c.getId());
		this.cliente.setContatos( contatoRepository.buscarPorClienteId(c.getId()));
		if(this.cliente.getEstado() == null || this.cliente.getContatos() == null) {
			this.cliente.setEstado(new Estado());
			this.cliente.setContatos(new ArrayList<Contato>());
		}
		System.out.println(cliente.getContatos());
		setModoEdicao(true);
	}
	
	public void cancelar() {
		cliente = new Clliente();
		setModoEdicao(false);
	}

	public Clliente getCliente() {
		return cliente;
	}

	public void setCliente(Clliente cliente) {
		this.cliente = cliente;
	}

	public List<Clliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Clliente> clientes) {
		this.clientes = clientes;
	}

	public boolean isModoEdicao() {
		return modoEdicao;
	}

	public void setModoEdicao(boolean modoEdicao) {
		this.modoEdicao = modoEdicao;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public Contato getCont() {
		return cont;
	}

	public void setCont(Contato contato) {
		this.cont = contato;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getDescricaoContato() {
		return descricaoContato;
	}

	public void setDescricaoContato(String descricaoContato) {
		this.descricaoContato = descricaoContato;
	}

}
