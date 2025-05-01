package br.com.pazimports.model;



import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class Clliente {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nome;
	private String email;
	@JoinColumn(name = "estado_id")
	@ManyToOne
	private Estado estado;
	
	public Clliente() {
		
	}
	public Clliente(String nome, String email) {
		setEmail(email);
		setNome(nome);
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, estado, id, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clliente other = (Clliente) obj;
		return Objects.equals(email, other.email) && Objects.equals(estado, other.estado)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	
	
	
	

}
