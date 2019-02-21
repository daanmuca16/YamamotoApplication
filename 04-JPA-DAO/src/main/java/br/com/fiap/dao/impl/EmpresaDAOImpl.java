package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.entity.Empresa;
import br.com.fiap.exception.CommitException;

public class EmpresaDAOImpl implements EmpresaDAO {
	//NO DAO NAO CHAMAMOS O FACTORY
	
	private EntityManager em;
	
	
	//CRIO UM CONSTRUTOR CHEIO , O VAZIO NAO FAZ SENTIDO PQ SENAO ELE SERIA NULO
	public EmpresaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	
	public void cadastrar(Empresa empresa) {
		em.persist(empresa);
		
	}

	public void atualizar(Empresa empresa) {
		em.merge(empresa);
	}

	public void deletar(int codigo) {
		Empresa empresa = new Empresa();
		empresa= em.find(Empresa.class, codigo);
		em.remove(empresa);
	}

	public Empresa pesquisar(int codigo) {
		
		Empresa empresa=em.find(Empresa.class, codigo);
		return empresa;
	}
	public void commit() throws CommitException {
		try {
		em.getTransaction().begin();
		em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}	
}
