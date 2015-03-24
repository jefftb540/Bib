package br.com.biblioteca.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.biblioteca.model.Pessoa;

@Repository
@Transactional
public class PessoaDao {

	@Autowired
	SessionFactory factory;
	
	public void createOrUpdate(Pessoa pessoa) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(pessoa);
		session.flush();
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> findlAll(){
		return factory.openSession().createCriteria(Pessoa.class).list();
	}
	
	public Pessoa findCpf(Long cpf) {
		return (Pessoa) factory.openSession()
				.createCriteria(Pessoa.class)
				.add(Restrictions.eq("cpf", cpf))
				.uniqueResult();
	}
}
