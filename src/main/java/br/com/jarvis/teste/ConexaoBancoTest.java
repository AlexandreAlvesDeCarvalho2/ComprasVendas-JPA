package br.com.jarvis.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.jarvis.model.Compra;
import br.com.jarvis.model.CompraProduto;
import br.com.jarvis.model.Fornecedor;
import br.com.jarvis.model.Produto;

public class ConexaoBancoTest {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("Cap5").createEntityManager();
		
		//Criando 2 fornecedores 
		Fornecedor fornecedor2 = new Fornecedor(0,"18.134.211/0001-82","Skol Bebidas","Avenida Marcelo Scaraficci, 4756, Itabuna, SP","(11) 98042-2833",null, null);
		Fornecedor fornecedor3 = new Fornecedor(0,"97.758.331/0001-27","Distribuidora Barreto","Rua Imirim, 4756, Barueri, SP","(11) 99640-5031",null, null);
		
		//Criando 4 produtos
		Produto produto1 = new Produto(0,"Cerveja Skol 350ml", 120, null, null);
		Produto produto2 = new Produto(0,"Cerveja Itaipava 350ml", 120, null, null);
		Produto produto3 = new Produto(0,"Cerveja Heinekein 350ml", 120, null, null);
		Produto produto4 = new Produto(0,"Cerveja Stella Artois 269ml", 120, null, null);

		// Criando objeto compras 
		Compra compra1 = new Compra(0, 1131.1,"Debito", null,null ,fornecedor2);
		Compra compra2 = new Compra(0, 1184.2,"Credito", null,null, fornecedor3);
		Compra compra3 = new Compra(0, 1184.3,"Debito", null,null, fornecedor3);
		Compra compra4 = new Compra(0, 1184.4,"Dinheiro", null,null, fornecedor2);
		
				
		CompraProduto compraProduto1 = new CompraProduto(compra1, produto4, 12, 2.89);		
		CompraProduto compraProduto2 = new CompraProduto(compra2, produto3, 24, 2.95);		
		CompraProduto compraProduto3 = new CompraProduto(compra3, produto2, 48, 2.43);		
		CompraProduto compraProduto4 = new CompraProduto(compra4, produto1, 96, 2.54);		
		
		
		List<CompraProduto> listCompraProdutos = new ArrayList<>();
		listCompraProdutos.add(compraProduto1);
		listCompraProdutos.add(compraProduto2);
		listCompraProdutos.add(compraProduto3);
		listCompraProdutos.add(compraProduto4);
		
		/*
		Cliente cliente1 = new Cliente(0,"Alexandre","422.665.874-87","(xx)xxxxx-xxxx","Alexandre@gmail",null,null);
		Cliente cliente2 = new Cliente(0,"Pedro","789.789.456-5","(xx)xxxxx-xxxx","Pedro@gmail",null,null);
		Cliente cliente3 = new Cliente(0,"Nathalia","786.456.123-2","(xx)xxxxx-xxxx","Nathalia@gmail",null,null);
		
		Produto produto7 = new Produto(0,"Cerveja Stella Artois 269ml", 60, null, null);
		Produto produto8 = new Produto(0,"Cerveja Premium Budweiser 269ml", 60, null, null);
		Produto produto9 = new Produto(0,"Cerveja Heinekein 350ml", 60, null, null);
		List<Produto> ListaVendaProduto = new ArrayList<>(); 
		ListaVendaProduto.add(produto9);
		ListaVendaProduto.add(produto8);
		ListaVendaProduto.add(produto7);
		
		Venda venda1 = new Venda(0,118.44,"Dinheiro",null,cliente1,null);
		Venda venda2 = new Venda(0,118.44,"Dinheiro",null,cliente2, null);
		Venda venda3 = new Venda(0,118.44,"Dinheiro",null,cliente3, null);
		

		VendaProduto vendaproduto = new VendaProduto(venda1,produto7,12,3.20);
		VendaProduto vendaproduto2 = new VendaProduto(venda2,produto7,12,3.20);
		VendaProduto vendaproduto3 = new VendaProduto(venda1,produto7,12,3.20);
		
		*/
		
		// conectar ao banco e persistir compra1 e compra2 em cascata
		em.persist(compraProduto1);
		em.persist(compraProduto2);
		em.persist(compraProduto3);
		em.persist(compraProduto4);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		em.close();
		
		}
	
}