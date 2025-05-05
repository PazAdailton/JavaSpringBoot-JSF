package br.com.pazimports.model;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String descricao;
	@ManyToOne
	@JoinColumn(name = "clliente_id")
	private Cliente cliente;
	
	@Getter @Setter
	@JoinColumn
	@ManyToOne
	private TipoContato tipoContato;
	
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

	@Override
	public int hashCode() {
		return Objects.hash(cliente, descricao, id, tipoContato);
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
				&& Objects.equals(id, other.id) && Objects.equals(tipoContato, other.tipoContato);
	}
	
	
}
