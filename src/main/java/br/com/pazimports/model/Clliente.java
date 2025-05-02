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
public class Clliente {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nome;
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Contato> contatos = new ArrayList<Contato>();
	@JoinColumn(name = "estado_id")
	@ManyToOne
	private Estado estado;
	
	public Clliente() {
		
	}
	public Clliente(String nome, List<Contato> contatos, Estado estado) {
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
		return contatos;
	}
	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	public void addContato(Contato contato) {
		
		if(contato == null) {
		   throw new IllegalArgumentException();
		}
		if(this.contatos == null || this.contatos.isEmpty()) {
			this.contatos = new ArrayList<Contato>();
		}else {
			 contato.setCliente(this); 
			 this.contatos.add(contato);
		}	
	}
	
	
	@Override
	public String toString() {
		return "Clliente [id=" + id + ", nome=" + nome + ", contatos" + contatos + ", estado=" + estado + "]";
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
		Clliente other = (Clliente) obj;
		return Objects.equals(id, other.id);
	}
	
}
