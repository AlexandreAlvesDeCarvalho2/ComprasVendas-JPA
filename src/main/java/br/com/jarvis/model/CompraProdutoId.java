package br.com.jarvis.model;

import java.io.Serializable;

public class CompraProdutoId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int compra;

	private int produto;

	public int getCompra() {
		return compra;
	}

	public void setCompra(int compra) {
		this.compra = compra;
	}

	public int getProduto() {
		return produto;
	}

	public void setProduto(int produto) {
		this.produto = produto;
	}
	
	
	public CompraProdutoId() {}

	public CompraProdutoId(int compra, int produto) {
		super();
		this.compra = compra;
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + compra;
		result = prime * result + produto;
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
		CompraProdutoId other = (CompraProdutoId) obj;
		if (compra != other.compra)
			return false;
		if (produto != other.produto)
			return false;
		return true;
	}
	
	
	
	
}
