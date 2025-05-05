package br.com.pazimports.controller1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.pazimports.model.TipoContato;
import br.com.pazimports.repositoryy.TipoContatoRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;


@Named
@ViewScoped
public class TipoContatoController {
		
	@Autowired
	private TipoContatoRepository tipoContatoRepository;
	
	private List<TipoContato> tiposContatos = new ArrayList<TipoContato>();
	private TipoContato tipoContato = new TipoContato();
	
	@PostConstruct
	public void init() {
		setTiposContatos(tipoContatoRepository.findAll());
	}

	public TipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}

	public List<TipoContato> getTiposContatos() {
		return tiposContatos;
	}

	public void setTiposContatos(List<TipoContato> tiposContatos) {
		this.tiposContatos = tiposContatos;
	}
	
}
