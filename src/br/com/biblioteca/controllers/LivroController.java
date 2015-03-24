package br.com.biblioteca.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.biblioteca.dao.EditoraDao;
import br.com.biblioteca.dao.LivroDao;
import br.com.biblioteca.model.Livro;

@Controller
@RequestMapping("livro")
public class LivroController {
	@Autowired
	private LivroDao livroDao;
	
	@Autowired
	private EditoraDao editoraDao;
	
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public ModelAndView form(@ModelAttribute Livro livro) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("livro", new Livro());
		map.put("editoras", editoraDao.findAll());
		return new ModelAndView("livro/form", map);
	}
	
	@RequestMapping(value = "editar", method = RequestMethod.GET)
	public ModelAndView editar(@RequestParam String codigoBarras) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("livro", livroDao.findByCodigoBarras(codigoBarras));
		map.put("editoras", editoraDao.findAll());
		return new ModelAndView("livro/form", map);
	}		
	
	@RequestMapping(value = "registrar_atualizar", method = RequestMethod.POST)
	public ModelAndView registrarOuAtualizar(@ModelAttribute Livro livro) {
		livroDao.createOrUpdate(livro);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "listar")
	public ModelAndView listar() {		
		return new ModelAndView("livro/listar", "livros", livroDao.findAll());
	}
}
