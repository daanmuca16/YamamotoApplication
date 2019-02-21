package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;

public class RefreshTeste {
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		//atualizar o objeto com os valores do banco
		
		
			//pesquisar um cliente
		Cliente cliente = em.find(Cliente.class, 1);
		System.out.println("valor do banco: "+cliente.getNome());
		
		//alterar o valor do nome no java
		cliente.setNome("Nilson");
		System.out.println("nome modificado no java "+cliente.getNome());
		
		//realizar o refresh
		em.refresh(cliente);
		
		//exibir o nome
		System.out.println("nome após o refresh: "+cliente.getNome());
		
		em.close();
		
		fabrica.close();
		
		
		
		
	}
}
