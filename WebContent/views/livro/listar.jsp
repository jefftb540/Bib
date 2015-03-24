<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Livros</title>
</head>
<body>
	<c:if test="${!empty livros}">
		<table border="1">
			<tr>
				<td>ISBN</td>
				<td>Titulo</td>
				<td>Codigo Barra</td>
				<td>Estante</td>
				<td>Exemplares</td>
				<td>Disponiveis</td>
				<td>Ano</td>
				<td>Volume</td>
				<td>Edição</td>
				<td>Editora</td>								
			</tr>
			<c:forEach items="${livros}" var="livro">
				<tr>
					<td>${livro.isbn}</td>
					<td>${livro.titulo}</td>
					<td>${livro.codigoBarra}</td>
					<td>${livro.estante}</td>
					<td>${livro.exemplares}</td>
					<td>${livro.disponiveis}</td>
					<td>${livro.ano}</td>
					<td>${livro.volume}</td>
					<td>${livro.edicao}</td>
					<td>${livro.editora}</td>
					<td><a href="editar?codigoBarras=${livro.codigoBarra}">editar</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>