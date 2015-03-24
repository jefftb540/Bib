package br.com.biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.biblioteca.dao.EditoraDao;
import br.com.biblioteca.exceptions.EmprestimoException;
import br.com.biblioteca.model.Editora;

@Controller
@RequestMapping("editora")
public class EditoraController {

	@Autowired
	private EditoraDao dao;
	
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public ModelAndView form() {		
		return new ModelAndView("editora/form", "editora", new Editora());
	}
	
	@RequestMapping(value = "editar", method = RequestMethod.GET)
	public ModelAndView editar(@RequestParam int id) {
		Editora editora = dao.findById(id);
		return new ModelAndView("editora/form", "editora", editora);
	}
		
	@RequestMapping(value = "registrar_atualizar", method = RequestMethod.POST)
	public ModelAndView registrarOuAtualizar(@ModelAttribute Editora editora) {
		dao.createOrUpdate(editora);
		return new ModelAndView("redirect:listar");
	}
	
	@RequestMapping(value = "listar")
	public ModelAndView listar() {		
		return new ModelAndView("editora/listar", "editoras", dao.findAll());
	}
	
}
