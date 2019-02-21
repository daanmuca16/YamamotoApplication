package br.com.fiap.teste;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Estado;
import br.com.fiap.entity.Produto;

//FAZER DO PRODUTO

public class Exercicio {
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//cadastrar
		
		Produto  produto = new Produto(1, "bolsa", 4, Estado.NOVO, new GregorianCalendar(1999, 05, 16), new GregorianCalendar(1995, 02, 17), 15, null);
		em.persist(produto);
		
		//pesquisar
		
		produto=em.find(Produto.class, 1);
		
		//atualizar
		
		
		
		//remover
		
		
		//fechar
		em.close();
		fabrica.close();
		
		
		
	}

}
