package br.com.jarvis.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="tb_compra_produto")
@IdClass(CompraProdutoId.class)
public class CompraProduto implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@JoinColumn(name="id_compra")
	@ManyToOne(optional= false, cascade = CascadeType.PERSIST )
	private Compra compra;
	
	@Id
	@JoinColumn(name="id_produto")
	@ManyToOne(optional= false, cascade = CascadeType.PERSIST)
	private Produto produto;

	@Column(name="qnt_produto")
	private int qntProduto;
	
	@Column(name="vl_unitario")
	private double vlUnit;

	@Formula(value = "3 * vl_unitario")
	@Column(name= "vl_total")
	private double vlTotal;

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
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

	public double getVlUnit() {
		return vlUnit;
	}

	public void setVlUnit(double vlUnit) {
		this.vlUnit = vlUnit;
	}

	public double getVlTotal() {
		return vlTotal;
	}

	public void setVlTotal(double vlTotal) {
		this.vlTotal = vlTotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CompraProduto() {}
	
	public CompraProduto(Compra compra, Produto produto, int qntProduto, double vlUnit) {
		super();
		this.compra = compra;
		this.produto = produto;
		this.qntProduto = qntProduto;
		this.vlUnit = vlUnit;
	}
	
	
	
	
	

}
