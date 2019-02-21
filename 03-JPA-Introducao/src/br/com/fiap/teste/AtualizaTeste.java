package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Genero;

public class AtualizaTeste {
	
	public static void main(String[] args) {
		// atualizar um cliente
		
		EntityManagerFactory fabrica= Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		Cliente cliente = new Cliente(1, "Xuxa", new GregorianCalendar(1970, Calendar.AUGUST,2), "456.564.123-78", Genero.MASCULINO, null, false);
		
		//USAMOS MERGE PRA ATUALIZAR
		
		em.merge(cliente);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
		
	}
	

}
