package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;

public class PesquisaTeste {
	public static void main(String[] args) {

		// Pesquisar um cliene com código 1
		EntityManagerFactory f = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

		EntityManager em = f.createEntityManager();
		
		//pesquisar o cliente com codigo 1, ele sempre puxa pelo ID
		Cliente cliente=em.find(Cliente.class, 1);
		
		System.out.println(cliente.getNome());
		
		//modificar o nome no banco de dados
		
		cliente.setNome("Francisco");
		
		
		
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		em.close();
		f.close();

	}
}
