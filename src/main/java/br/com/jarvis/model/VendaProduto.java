package br.com.jarvis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="tb_Venda_Produto")
@IdClass(VendaProdutoId.class)
public class VendaProduto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@JoinColumn(name="id_venda")
	@ManyToOne(optional= false )
	private Venda venda;
	
	@Id
	@JoinColumn(name="id_produto")
	@ManyToOne(optional= false)
	private Produto produto;

	@Column(name="qnt_produto")
	private int qntProduto;

	
	@Formula("(select preco_produto from tb_produto where id_produto = produto)* qntProduto")
	private double vl_produto;


	public Venda getVenda() {
		return venda;
	}


	public void setVenda(Venda venda) {
		this.venda = venda;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public int getQntProduto() {
		return qntProduto;
	}


	public void setQntProduto(int qntProduto) {
		this.qntProduto = qntProduto;
	}


	public double getVl_produto() {
		return vl_produto;
	}


	public void setVl_produto(double vl_produto) {
		this.vl_produto = vl_produto;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public VendaProduto() {}
	public VendaProduto(Venda venda, Produto produto, int qntProduto, double vl_produto) {
		super();
		this.venda = venda;
		this.produto = produto;
		this.qntProduto = qntProduto;
		this.vl_produto = vl_produto;
	}


	

}
