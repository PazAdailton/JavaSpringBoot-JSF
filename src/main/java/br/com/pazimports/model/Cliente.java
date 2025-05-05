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
import lombok.Data;



@Entity
@Data
public class Cliente {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@OneToMany(mappedBy = "cliente", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Contato> contatos = new ArrayList<Contato>();
	@JoinColumn(name = "estado_id")
	@ManyToOne
	private Estado estado;
	
	public Cliente() {
		
	}
	public Cliente(String nome, List<Contato> contatos, Estado estado) {
		setContatos(contatos);
		setNome(nome);
		setEstado(estado);
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public List<Contato> getContatos() {
		 if (contatos == null) {
	            contatos = new ArrayList<>();
	        }
		return contatos;
	}
	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
	
}
