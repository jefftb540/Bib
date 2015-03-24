package br.com.biblioteca.atrasados;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;

import br.com.biblioteca.EnviarEmail;
import br.com.biblioteca.dao.EmprestimoDao;
import br.com.biblioteca.model.Emprestimo;



public class Atrasados {
	
	EmprestimoDao dao = new EmprestimoDao();
	
	@Scheduled(cron="0 0 4 * * *")
	public void notificarAtraso(){
		List<Emprestimo> atrasados = dao.findEmprestimosAtrasados();
		String texto = gerarTextoEmail(atrasados);
	}

	private String gerarTextoEmail(List<Emprestimo> atrasados) {
		String str = "Relaçao de Livros atrasados\n";
		for (Emprestimo emprestimo : atrasados) {
			str+= "Aluno: "+emprestimo.getPessoa().getNome()+"\n";
			str+= "Livro: "+emprestimo.getLivro().getTitulo()+"\n";
			str+= "Data de Emprestimo: "+emprestimo.getDataEmprestimo().toString()+"\n";
			str+= "Data de devolução: "+emprestimo.getDataDevolucao().toString()+"\n";
			EnviarEmail e = new EnviarEmail();
			e.enviar("bibliotecario@biblioteca.com", "Empréstimos atrasados", str);
			
		}
		
		return str;
		
	}

}
