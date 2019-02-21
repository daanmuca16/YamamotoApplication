package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Genero;

public class Teste {
	public static void main(String[] args) {
		
		//criar um gerenciador de entidades
		//primeiro cria a fabrica
		//O NOME TA LA NO PERSISTENCE CML
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
			
		
		//depois a fabrica cria os enetity manager
		EntityManager em = f.createEntityManager();
	 

		
		//instaciar o cliente
		
		Cliente cliente = new Cliente ("Marcos", new GregorianCalendar(2000,Calendar.MARCH,2),"123.132.123-99",Genero.MASCULINO,null,true);
		//cadastrar o cliente
		em.persist(cliente);
		
		//avbre uma transalçao e finaliza
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		em.close();
		f.close();
		
	}

}
