package br.com.jarvis.model;

import java.io.Serializable;

public class VendaProdutoId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int venda;
	
	private int produto;
	
	
	
	// Getters and Setters

	public int getVenda() {
		return venda;
	}

	public void setVenda(int venda) {
		this.venda = venda;
	}

	public int getProduto() {
		return produto;
	}

	public void setProduto(int produto) {
		this.produto = produto;
	}
	
	
	
	// Construtores 
	
	public VendaProdutoId() {}
		
	public VendaProdutoId(int venda, int produto) {
		super();
		this.venda = venda;
		this.produto = produto;
	}
	
	
	// hashCode and equals	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + produto;
		result = prime * result + venda;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendaProdutoId other = (VendaProdutoId) obj;
		if (produto != other.produto)
			return false;
		if (venda != other.venda)
			return false;
		return true;
	}	
}
