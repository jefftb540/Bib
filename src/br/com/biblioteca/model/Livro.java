package br.com.biblioteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_livro")
	private int id;
	
	@Column(name="isbn", unique = true, nullable=false)
	private int isbn;
	
	@Column(name="titulo", nullable=false)
	private String titulo;
	
	@Column(name="codigo_barra", unique = true,  nullable=false)
	private String codigoBarra;
	
	@Column(name="estante", nullable=false)
	private int estante;
	
	@Column(name="exemplares", nullable=false)
	private int exemplares;
	
	@Column(name="disponiveis", nullable=false)
	private int disponiveis;
	
	@Column(name="ano")
	private int ano;
	
	@Column(name="volume")
	private int volume;
	
	@Column(name="edicao")
	private int edicao;
	
	@ManyToOne
	@JoinColumn(name = "editora", nullable = false)
	private Editora editora;
	
	/*private List<Autor> autores;*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public int getEstante() {
		return estante;
	}

	public void setEstante(int estante) {
		this.estante = estante;
	}

	public int getExemplares() {
		return exemplares;
	}

	public void setExemplares(int exemplares) {
		this.exemplares = exemplares;
	}

	public int getDisponiveis() {
		return disponiveis;
	}

	public void setDisponiveis(int disponiveis) {
		this.disponiveis = disponiveis;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	/*public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}*/
	
	@Override
	public String toString() {	
		return "ISBN " + isbn + "  título " + titulo;
	}
}
