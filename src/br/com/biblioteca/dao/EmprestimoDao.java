package br.com.biblioteca.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Pessoa;

@Repository
@Transactional
public class EmprestimoDao {

	@Autowired
	private SessionFactory factory;	
	
	@Autowired
	private PessoaDao pessoaDao;
	
	@Autowired
	private LivroDao livroDao;
	
	public void create(Pessoa pessoa, Livro livro, Date date) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setDataEmprestimo(date);
		emprestimo.setPessoa(pessoa);
		emprestimo.setLivro(livro);
		session.save(emprestimo);
		session.flush();
		tx.commit();
		session.close();
	}

	public Emprestimo findByIndentificador(Long cpf, String codigoBarras) {
		Pessoa pessoa = pessoaDao.findCpf(cpf);
		Livro livro = livroDao.findByCodigoBarras(codigoBarras);
		return getEmprestimo(pessoa, livro);
	}
	
	public Emprestimo findByIndentificador(Pessoa pessoa, Livro livro) {		
		return getEmprestimo(pessoa, livro);
	}

	public void remover(Emprestimo emprestimo) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();		
		session.delete(emprestimo);
		session.flush();
		tx.commit();
		session.close();
	}

	public void devolver(Emprestimo emprestimo) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(emprestimo);
		session.flush();
		tx.commit();
		session.close();
		
	}

	public Emprestimo findDevolucaoPendente(Pessoa pessoa, Livro livro) {
		return (Emprestimo) factory.openSession().createCriteria(Emprestimo.class)
				.add(Restrictions.eq("pessoa", pessoa))
				.add(Restrictions.eq("livro", livro))
				.add(Restrictions.isNull("dataDevolucao"))
				.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Emprestimo> findEmprestimos() {
		return factory.openSession().createQuery("from Emprestimo where data_devolucao is null").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Emprestimo> findEmprestimosAtrasados() {
		return factory.openSession().createQuery("from Emprestimo where data_devolucao < ?").setDate(0, new Date()).list();
	}

	@SuppressWarnings("unchecked")
	public List<Emprestimo> findDevolucoes() {
		return factory.openSession().createQuery("from Emprestimo where data_devolucao is not null").list();
	}

	private Emprestimo getEmprestimo(Pessoa pessoa, Livro livro) {
		return (Emprestimo) factory.openSession().createCriteria(Emprestimo.class)
				.add(Restrictions.eq("pessoa", pessoa))
				.add(Restrictions.eq("livro", livro)).uniqueResult();
	}
	

}
