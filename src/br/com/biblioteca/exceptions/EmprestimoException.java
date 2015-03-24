package br.com.biblioteca.exceptions;

public class EmprestimoException extends RuntimeException {

	private String mensagem;

	public EmprestimoException(String msg) {
		mensagem = msg;
	}

	@Override
	public String getMessage() {
		return mensagem;
	}
}
