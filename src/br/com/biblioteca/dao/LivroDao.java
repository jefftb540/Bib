package br.com.biblioteca.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.biblioteca.model.Livro;

@Repository
@Transactional
public class LivroDao {

	@Autowired
	private SessionFactory factory;

	public void createOrUpdate(Livro livro) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(livro);
		session.flush();
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Livro> findAllByTipo(int tipo) {
		return factory.openSession().createCriteria(Livro.class)
				.createCriteria("editora").add(Restrictions.eq("tipo", tipo))
				.list();
	}

	public Livro findByCodigoBarras(String codigoBarras) {
		return (Livro) factory.openSession()
				.createQuery("from Livro where codigo_barra = " + codigoBarras)				
				.uniqueResult();
	}

	public Livro findByIsbn(int isbn) {
		return (Livro) factory.openSession().createCriteria(Livro.class)
				.add(Restrictions.eq("isbn", isbn)).uniqueResult();
	}

	public void updateQuantidadeExemplaresDisponiveis(Livro livro,
			int quantidade) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		int exemplares = livro.getExemplares() + quantidade;
		int disponiveis = livro.getDisponiveis() + quantidade;
		livro.setExemplares(exemplares);
		livro.setDisponiveis(disponiveis);
		session.update(livro);
		session.flush();
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Livro> findAll() {
		return factory.openSession().createCriteria(Livro.class).list();
	}

}
