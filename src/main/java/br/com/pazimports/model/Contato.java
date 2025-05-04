package br.com.pazimports.model;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String descricao;
	@ManyToOne
	@JoinColumn(name = "clliente_id")
	private Cliente cliente;
	
	
	@OneToMany(mappedBy = "contato" ,orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<TipoContato> tiposContatos = new ArrayList<>();
	
	public Contato() {
		  
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
	    return this.descricao; 
	}

	public List<TipoContato> getTiposContatos() {
		return tiposContatos;
	}

	public void setTiposContatos(List<TipoContato> tiposContatos) {
		this.tiposContatos = tiposContatos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, descricao, id, tiposContatos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(tiposContatos, other.tiposContatos);
	}
	
	
	
	
	
}
