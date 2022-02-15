package br.com.jarvis.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.jarvis.model.Compra;
import br.com.jarvis.model.Fornecedor;
import br.com.jarvis.model.Produto;

public class ConexaoBancoTest {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("Cap5").createEntityManager();
		
		//Fornecedor fornecedor1 = new Fornecedor(0,"87.513.626/0001-80","Ambar Cervejas Artesanais","Rua Santo André, 4756, Itabuna, BA","(62) (95) 99884-6178",null, null);
		Fornecedor fornecedor2 = new Fornecedor(0,"18.134.211/0001-82","Skol Bebidas","Avenida Marcelo Scaraficci, 4756, Itabuna, SP","(11) 98042-2833",null, null);
		Fornecedor fornecedor3 = new Fornecedor(0,"97.758.331/0001-27","Distribuidora Barreto","Rua Imirim, 4756, Barueri, SP","(11) 99640-5031",null, null);
				
		Produto produto1 = new Produto(0,"Cerveja Skol 350ml",2.99,120, null, null);
		Produto produto2 = new Produto(0,"Cerveja Itaipava 350ml",2.75,120, null, null);
		Produto produto3 = new Produto(0,"Cerveja Heinekein 350ml",3.69,120, null, null);

		Produto produto4 = new Produto(0,"Cerveja Stella Artois 269ml",2.99, 120, null, null);
		Produto produto5 = new Produto(0,"Cerveja Premium Budweiser 269ml",3.19, 120, null, null);
		Produto produto6 = new Produto(0,"Cerveja Heinekein 350ml",3.69, 120, null, null);
		
		List<Produto> listProduto = new ArrayList<>();
		listProduto.add(produto1);
		listProduto.add(produto2);
		listProduto.add(produto3);
		
		List<Produto> listProduto2 = new ArrayList<>();
		listProduto.add(produto4);
		listProduto.add(produto5);
		listProduto.add(produto6);

		Compra compra1 = new Compra(0, listProduto, 1131.6,"Debito", null, fornecedor2);
		Compra compra2 = new Compra(0, listProduto2, 1184.4,"Debito", null, fornecedor3);
		
		em.persist(compra1);
		em.persist(compra2);
	}
}