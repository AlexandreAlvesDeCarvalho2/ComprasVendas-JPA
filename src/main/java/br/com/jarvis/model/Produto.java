package br.com.jarvis.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PRODUTO")
public class Produto {

	@Id
	@SequenceGenerator(name = "produto", sequenceName = "sq_produto", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	@Column(name="id_produto")
	private int id;
	
	@Column(name="nome_produto")
	private String nome;
	
	@Column(name="preco_produto")
	private double preco;
	
	
	@Column(name="estoque_produto")
	private int estoque;
	
	
	@ManyToMany(mappedBy = "produtosVenda")    // sistema registrará uma venda com um ou vários produtos
	private List<Venda> vendas;
	
		
	@ManyToMany(mappedBy = "produtosCompra")	// sistema registrará uma compra com um ou vários produtos
	private List<Compra> compras;

	
	
	
	
	// Getters and Setter
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getEstoque() {
		return estoque;
	}


	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}


	public List<Venda> getVendas() {
		return vendas;
	}


	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}


	public List<Compra> getCompras() {
		return compras;
	}


	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	
	public Produto() {}
	
	public Produto(int id, String nome, double preco, int estoque, List<Venda> vendas, List<Compra> compras) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
		this.vendas = vendas;
		this.compras = compras;
	}
	
	
	
	
	
}
