package br.com.pazimports.controller1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import br.com.pazimports.model.Contato;
import br.com.pazimports.repositoryy.ContatoRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ContatoController {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	
	private List<Contato> contatos = new ArrayList<Contato>();
	private Contato contato;
	
	@PostConstruct
	public void init() {
		this.contatos = contatoRepository.findAll();
	}
	
	public void adicionarContato() {
		contatos.add(contato);
		contato = new Contato();
	}
	public void removerContato() {
		contatos.remove(contato);
		contato = new Contato();
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
