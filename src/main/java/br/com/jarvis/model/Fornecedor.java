package br.com.jarvis.model;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="TB_FORNECEDOR")
public class Fornecedor {

	@Id
	@Column(name="id_fornecedor")
	@SequenceGenerator(name = "fornecedor", sequenceName = "sq_fornecedor", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fornecedor")
	private int id;
	
	@Column(name="cnpj_fornecedor")
	private String cnpj;
	
	@Column(name="nome_forncedor")
	private String nome;
	
	@Column(name="localizacao_fornecedor")
	private String localizacao;
	
	@Column(name="telefone_fornecedor")
	private String telefone;
		
	@Column(name="dt_cadastro_fornecedor")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dt_cadastro_fornecedor;
	
	
    @OneToMany(mappedBy = "fornecedores")  // sistema registrará "um" fornecedor com uma ou "muitas" compras.
	private Collection<Compra> compras;
	

    
    
    
	// Getters and Setters
        
	public Collection<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Collection<Compra> compras) {
		this.compras = compras;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Calendar getDt_cadastro_fornecedor() {
		return dt_cadastro_fornecedor;
	}

	public void setDt_cadastro_fornecedor(Calendar dt_cadastro_fornecedor) {
		this.dt_cadastro_fornecedor = dt_cadastro_fornecedor;
	}
	
	

	
	
}
