package br.com.pazimports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.pazimports.model.Estado;
import br.com.pazimports.repositoryy.EstadoRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;
	
	private Estado estado = new Estado();
	
	private List<Estado> estados;
	
	
	
	@PostConstruct
	public void init() {
		setEstados(estadoRepository.findAll());
	}
	
	public Estado salvar() {
	Estado estadoSalvo = estadoRepository.save(estado);
	estado = new Estado();
	return estadoSalvo;

	}
	

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
