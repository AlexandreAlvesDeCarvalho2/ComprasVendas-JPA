package br.com.jarvis.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="TB_COMPRA")
public class Compra {
	
	@Id
	@SequenceGenerator(name = "compra", sequenceName = "sq_compra", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compra")
	@Column(name="id_compra")
	private int id;
	
	// sistema registrará uma compra com um ou "muitos" produtos e um produto em uma ou "muitas" compras.
	@ManyToMany
    @JoinTable(	joinColumns = @JoinColumn(name = "id_compras"), 
    			inverseJoinColumns = @JoinColumn(name = "id_produtos"), 
    			name = "itensCompra")
	private List<Produto> produtosCompra;
	
	
	@Column(name="vl_total")
	private double valorTotal;
	
	
	@Column(name="frm_pagamento")
	private String formaDepagamento;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_compra")
	private Calendar dataCompra;
	
	
	// sistema registrará uma ou "muitas" compras para "um" fornecedor.
	@ManyToOne 
	private Fornecedor fornecedores;

	
	
	
	
	
	// Getters and Setters
	
	public int getId() {
		return id;
	}


	public Fornecedor getFornecedores() {
		return fornecedores;
	}


	public void setFornecedores(Fornecedor fornecedores) {
		this.fornecedores = fornecedores;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<Produto> getProdutosCompra() {
		return produtosCompra;
	}


	public void setProdutosCompra(List<Produto> produtosCompra) {
		this.produtosCompra = produtosCompra;
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
	

	
}
