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
	<c:if test="${!empty emprestimos}">
		<table border="1">
			<tr>
				<td>Usuário</td>
				<td>Livro</td>
				<td>Data emprestimo</td>
				<td>Data devolução</td>
			</tr>
			<c:forEach items="${emprestimos}" var="emprestimo">
				<tr>
					<td>${emprestimo.pessoa}</td>
					<td>${emprestimo.livro}</td>
					<td>${emprestimo.dataEmprestimo}</td>
					<td>${emprestimo.dataDevolucao}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
