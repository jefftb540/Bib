package br.com.biblioteca.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.biblioteca.model.Editora;

@Repository
@Transactional
public class EditoraDao {

	@Autowired
	private SessionFactory factory;	

	public void createOrUpdate(Editora editora) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(editora);
		session.flush();		
		tx.commit();
		session.close();
	}
	
	public void delete(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(findById(id));
		session.flush();
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Editora> findAll() {
		return factory.openSession().createCriteria(Editora.class).list();
	}
	
	public Editora findById(int id) {
		return (Editora)factory.openSession().get(Editora.class, id);
	}
}
