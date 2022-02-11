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
@Table(name = "TB_VENDAS")
public class Venda {

	@Id
	@SequenceGenerator(name = "Venda", sequenceName = "sq_venda", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Venda")
	@Column(name = "id_vendas")
	private int id;
	
	// sistema registrará uma venda com um ou vários produtos e um produto em uma ou várias vendas.
	@ManyToMany
    @JoinTable(	joinColumns = @JoinColumn(name = "id_vendas"), 
    			inverseJoinColumns = @JoinColumn(name = "id_produtos"), 
    			name = "itensVendas")
	private List<Produto> produtosVenda;
	
	
	@Column(name = "vl_total", length=20, nullable=false)
	private double valorTotal;
	
	
	@Column(name="frm_pagamento")
	private String formaDePagamento;
	
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_venda")
	private Calendar dataVenda;
		
	@ManyToOne         					 // sistema registrará muitas vendas para um cliente
	private Cliente clientes;
	
	
	
	
	// Getters and Setters 	

	public int getId() {
		return id;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}

	public void setId(int id) {
		this.id = id;
	}


	public List<Produto> getProdutosVenda() {
		return produtosVenda;
	}

	public void setProdutosVenda(List<Produto> produtosVenda) {
		this.produtosVenda = produtosVenda;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Calendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}

}
