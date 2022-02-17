package br.com.jarvis.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="tb_compras")
public class Compra {
	
	@Id
	@SequenceGenerator(name = "compra", sequenceName = "sq_compra", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compra")
	@Column(name="id_compra")
	private int id;
	
	
	@Column(name="vl_total")
	private double valorTotal;
	
	
	@Column(name="frm_pagamento")
	private String formaDepagamento;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_compra")
	private Calendar dataCompra;
	
	
	// registrará uma compra com muitos produtos
	@OneToMany(mappedBy =  "compra")
	private List<CompraProduto> produtos;
	
	
	// sistema registrará uma ou "muitas" compras para "um" fornecedor.
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Fornecedor fornecedores;



	// Getters and Setters
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public String getFormaDepagamento() {
		return formaDepagamento;
	}


	public void setFormaDepagamento(String formaDepagamento) {
		this.formaDepagamento = formaDepagamento;
	}


	public Calendar getDataCompra() {
		return dataCompra;
	}


	public void setDataCompra(Calendar dataCompra) {
		this.dataCompra = dataCompra;
	}


	public List<CompraProduto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<CompraProduto> produtos) {
		this.produtos = produtos;
	}


	public Fornecedor getFornecedores() {
		return fornecedores;
	}


	public void setFornecedores(Fornecedor fornecedores) {
		this.fornecedores = fornecedores;
	}

	public Compra() {}
	
	public Compra(int id, double valorTotal, String formaDepagamento, Calendar dataCompra, List<CompraProduto> produtos,
			Fornecedor fornecedores) {
		super();
		this.id = id;
		this.valorTotal = valorTotal;
		this.formaDepagamento = formaDepagamento;
		this.dataCompra = dataCompra;
		this.produtos = produtos;
		this.fornecedores = fornecedores;
	}

	
	
	
	
	

	
}
