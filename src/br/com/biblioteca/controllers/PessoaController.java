package br.com.biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.biblioteca.dao.PessoaDao;
import br.com.biblioteca.model.Pessoa;

@Controller
@RequestMapping("pessoa")
public class PessoaController {

	@Autowired
	private PessoaDao dao;
	
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public ModelAndView form() {		
		return new ModelAndView("pessoa/form", "pessoa", new Pessoa());
	}
	
	@RequestMapping(value = "editar", method = RequestMethod.GET)
	public ModelAndView editar(@RequestParam Long cpf) {
		Pessoa pessoa = dao.findCpf(cpf);
		return new ModelAndView("pessoa/form", "pessoa", pessoa);
	}
		
	@RequestMapping(value = "registrar_atualizar", method = RequestMethod.POST)
	public ModelAndView registrarOuAtualizar(@ModelAttribute Pessoa pessoa) {
		dao.createOrUpdate(pessoa);
		return new ModelAndView("redirect:/", "mensagem", "Usuário atualizado!");
	}
	
	@RequestMapping(value = "listar")
	public ModelAndView listar() {		
		return new ModelAndView("pessoa/listar", "pessoas", dao.findlAll());
	}
	
}
