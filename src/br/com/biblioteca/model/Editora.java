package br.com.biblioteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Editora {

	@Id
	@Column(name="id_editora")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="nome")
	private String nome;

	@Column(name="tipo")
	private int tipo;
	
	public static final int TIPO_NACIONAL = 1;
	public static final int TIPO_INTERNACIONAL = 2;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public String tipo() {
		return (tipo == 1) ? "Nacional" : "Internacional";
	}
	
	@Override
	public String toString() {	
		return nome + " " + tipo();
	}
}
