package br.com.biblioteca.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.biblioteca.dao.EmprestimoDao;
import br.com.biblioteca.dao.LivroDao;
import br.com.biblioteca.dao.PessoaDao;
import br.com.biblioteca.exceptions.EmprestimoException;
import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.FormObject;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Pessoa;

@Controller
public class EmprestimoController {
	
	@Autowired
	private EmprestimoDao empDao;
	@Autowired 
	private PessoaDao pessoaDao;
	@Autowired
	private LivroDao livroDao;		
	
	@RequestMapping(value = "emprestimos", method = RequestMethod.GET)
	public ModelAndView listarEmprestimos() {
		return new ModelAndView("emprestimo/listar", "emprestimos", empDao.findEmprestimos());
	}
	
	@RequestMapping(value = "devolucoes", method = RequestMethod.GET)
	public ModelAndView listarDevolucoes() {
		return new ModelAndView("emprestimo/listar", "emprestimos", empDao.findDevolucoes());
	}
	
	@RequestMapping(value = "emprestar", method = RequestMethod.POST)
	public ModelAndView emprestar(@ModelAttribute FormObject form) {
		Pessoa pessoa = pessoaDao.findCpf(form.getCpf());
		if (pessoa == null) throw new EmprestimoException("Usuário não cadastrado!");
		
		Livro livro = livroDao.findByIsbn(form.getIsbn());
		if (livro == null) throw new EmprestimoException("Código ISBN inválido!");						
				
		if (empDao.findDevolucaoPendente(pessoa, livro) != null)
			throw new EmprestimoException("Usuário possui um exemplar!");
		
		if (livro.getDisponiveis() - 1 == -1) throw new EmprestimoException("Livro indisponível");
		
		livro.setDisponiveis(livro.getDisponiveis() - 1);
		empDao.create(pessoa, livro, new Date());
		livroDao.createOrUpdate(livro);
		String msg = "empretismo realizado com sucesso!";
		return new ModelAndView("redirect:/", "mensagem", msg);
	}
	
	@RequestMapping(value = "devolver", method = RequestMethod.POST)
	public ModelAndView devolver(@ModelAttribute FormObject form) {	
		Pessoa pessoa = pessoaDao.findCpf(form.getCpf());
		Livro livro = livroDao.findByCodigoBarras(form.getCodigoBarras());
		Emprestimo emprestimo = empDao.findDevolucaoPendente(pessoa, livro);		
		if (emprestimo == null) throw new EmprestimoException("Código de barras ou CPF inválidos!");
				
		livro.setDisponiveis(livro.getDisponiveis() + 1);
		
		emprestimo.setDataDevolucao(new Date());		
		
		livroDao.createOrUpdate(livro);
		empDao.devolver(emprestimo);				
		
		String msg = "devolução realizada com sucesso!";
		return new ModelAndView("redirect:/", "mensagem", msg);
	}	
	
	@RequestMapping(value = "cancelar", method = RequestMethod.POST)
	public ModelAndView cancelar(@ModelAttribute FormObject form) {		
		
		Pessoa pessoa = pessoaDao.findCpf(form.getCpf());
		Livro livro = livroDao.findByCodigoBarras(form.getCodigoBarras());
		Emprestimo emprestimo = empDao.findDevolucaoPendente(pessoa, livro);		
		if (emprestimo == null) throw new EmprestimoException("Código de barras ou CPF inválidos!");
				
		livro.setDisponiveis(livro.getDisponiveis() + 1);	
		
		livroDao.createOrUpdate(livro);
		
		empDao.remover(emprestimo);
		String msg = "Emprestimo cancelado com sucesso!";
		return new ModelAndView("redirect:/", "mensagem", msg);
	}
	
	@ExceptionHandler({EmprestimoException.class})
	public ModelAndView handleLivroIndiponivel(HttpServletRequest request, Exception ex){        
        return new ModelAndView("redirect:/", "mensagem", ex.getMessage());
	}
}
