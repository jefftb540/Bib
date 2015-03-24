<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Livro</title>
</head>
<body>

	<p><% if (request.getParameter("mensagem") != null)
		out.println(request.getParameter("mensagem"));%>
	</p>
	
	${mensagem}
	
	<h5>Emprestar</h5>
	<form:form method="post" action="/Bib/emprestar" modelAttribute="formObject">
    	<br><label>CPF</label><form:input path="cpf" />
    	<br><label>ISBN</label><form:input path="isbn" />
    	<input type="submit" value="Register"/>
	</form:form>
	
	
	<h5>Devolver</h5>
	
	<form:form method="post" action="/Bib/devolver" modelAttribute="formObject">
    	<br><label>CPF</label><form:input path="cpf" />
    	<br><label>Código de Barras</label><form:input path="codigoBarras" />
    	<input type="submit" value="Register"/>
	</form:form>
	
	<h5>Cancelar</h5>
	
	<form:form method="post" action="/Bib/cancelar" modelAttribute="formObject">
    	<br><label>CPF</label><form:input path="cpf" />
    	<br><label>Código de Barras</label><form:input path="codigoBarras" />
    	<input type="submit" value="Register"/>
	</form:form>			
	
	<a href="/Bib/pessoa/form">cadastrar usuário</a><br>	
	<a href="/Bib/pessoa/listar">usuários cadastrados</a><br>
	<a href="/Bib/livro/form">casdastrar livro</a><br>
	<a href="/Bib/livro/listar">livros cadastrados</a><br>
	<a href="/Bib/editora/form">casdastrar editora</a><br>
	<a href="/Bib/editora/listar">editoras cadastradas</a><br>
	
	<a href="emprestimos">Livros emprestados</a><br>
	<a href="devolucoes">Livros devolvidos</a><br>
	
	

</body>
</html>
