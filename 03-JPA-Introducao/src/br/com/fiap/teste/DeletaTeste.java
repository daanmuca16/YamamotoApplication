package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;

public class DeletaTeste {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//remover cluiente ID
		
		Cliente cliente = em.find(Cliente.class, 1);
		em.remove(cliente);
		
		//dar o commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//ORDEM IMPORTA
		em.close();
		fabrica.close();
	}
}
