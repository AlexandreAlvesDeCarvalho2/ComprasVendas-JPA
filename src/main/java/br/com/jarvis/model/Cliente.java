package br.com.jarvis.model;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name="TB_CLIENTE")
public class Cliente {
	
	@Id
	@Column(name="id_cliente")
	private int id;
	
	@Column(name="nome_cliente")
	private String nome;
	
	@Column(name="cpf_cliente")
	private String cpf;
	
	@Column(name="telefone_cliente")
	private String telefone;
	
	@Column(name="email_cliente")
	private String email;

	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_cadastro_cliente")
	private Calendar dataCadastro;
	
	
    @OneToMany(mappedBy = "clientes")  // sistema registrará "um" cliente com "muitas" compras.
	private List<Venda> vendas;
	
	
	
	// Getters and Setters
	
	public int getId() {
		return id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Collection<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Cliente() {}
	
	public Cliente(int id, String nome, String cpf, String telefone, String email, Calendar dataCadastro,
			List<Venda> vendas) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.dataCadastro = dataCadastro;
		this.vendas = vendas;
	}
	
	
	
	

}
