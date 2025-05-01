package br.com.pazimports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.pazimports.model.Clliente;
import br.com.pazimports.model.Estado;
import br.com.pazimports.repositoryy.CllienteRepository;
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
	
	private List<Estado> estados;


	private Clliente cliente = new Clliente();
	private List<Clliente> clientes;
	private boolean modoEdicao = false;
	
	@PostConstruct
	public void init() {
		if (cliente == null) {
	        cliente = new Clliente();
	    }
		setClientes(clienteRepository.buscarTodos());
		setEstados(estadoRepository.findAll());
	}
	
	public void salvar() {
		if (cliente.getId() == null) {
		if(!isModoEdicao())
		clientes.add(cliente);
		clienteRepository.save(cliente);
		}else {
			clienteRepository.save(cliente);
		}
		cliente = new Clliente();
		setModoEdicao(false);
	}
	public void excluir(Clliente cliente) {
		clienteRepository.delete(cliente);
		clientes.remove(cliente);
	}
	
	public void editar(Clliente c) {
		this.cliente = c;
		if(this.cliente.getEstado() == null) {
			this.cliente.setEstado(new Estado());
		}
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

	


	
	
	
	
	
	
}
