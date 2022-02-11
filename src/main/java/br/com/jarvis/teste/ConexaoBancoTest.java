package br.com.jarvis.teste;

import javax.persistence.Persistence;

public class ConexaoBancoTest {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("Cap5").createEntityManager();
	}
	
}