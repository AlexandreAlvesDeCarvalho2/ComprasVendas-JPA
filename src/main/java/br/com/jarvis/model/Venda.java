package br.com.jarvis.model;

import java.util.Calendar;
import java.util.List;

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
@Table(name = "tb_vendas")
public class Venda {

	@Id
	@SequenceGenerator(name = "Venda", sequenceName = "sq_venda", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Venda")
	@Column(name = "id_vendas")
	private int id;
	
	
	
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
	
	@OneToMany(mappedBy =  "venda")
	private List<VendaProduto> produtos;

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

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public Calendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}

	public List<VendaProduto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<VendaProduto> produtos) {
		this.produtos = produtos;
	}

	public Venda() {}
	
	public Venda(int id, double valorTotal, String formaDePagamento, Calendar dataVenda, Cliente clientes,
			List<VendaProduto> produtos) {
		super();
		this.id = id;
		this.valorTotal = valorTotal;
		this.formaDePagamento = formaDePagamento;
		this.dataVenda = dataVenda;
		this.clientes = clientes;
		this.produtos = produtos;
	}
	
	
	// Getters and Setters 	

	
	
	
	

}
