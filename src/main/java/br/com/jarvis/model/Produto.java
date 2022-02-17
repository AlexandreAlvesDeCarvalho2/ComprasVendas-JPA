package br.com.jarvis.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_produto")
public class Produto {

	@Id
	@SequenceGenerator(name = "produto", sequenceName = "sq_produto", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	@Column(name="id_produto")
	private int id;
	
	@Column(name="nome_produto")
	private String nome;
		
	@Column(name="qnt_min")
	private int qntMin;
	
	@OneToMany(mappedBy = "produto")
	private List<CompraProduto> compras;
	
	@OneToMany(mappedBy = "produto")
	private List<VendaProduto> vendas;

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

	
	public int getQntMin() {
		return qntMin;
	}

	public void setQntMin(int qntMin) {
		this.qntMin = qntMin;
	}

	public List<CompraProduto> getCompras() {
		return compras;
	}

	public void setCompras(List<CompraProduto> compras) {
		this.compras = compras;
	}

	public List<VendaProduto> getVendas() {
		return vendas;
	}

	public void setVendas(List<VendaProduto> vendas) {
		this.vendas = vendas;
	}

	public Produto() {}
	
	public Produto(int id, String nome, int qntMin, List<CompraProduto> compras,
			List<VendaProduto> vendas) {
		super();
		this.id = id;
		this.nome = nome;
		this.qntMin = qntMin;
		this.compras = compras;
		this.vendas = vendas;
	}
		
	
	
	
	
	
	
	
}
