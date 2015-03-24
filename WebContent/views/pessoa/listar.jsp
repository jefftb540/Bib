<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuários</title>
</head>
<body>
	<c:if test="${!empty pessoas}">
		<table border="1">
			<tr>
				<td>Nome</td>
				<td>CPF</td>
				<td colspan="2">Telefone</td>
			</tr>
			<c:forEach items="${pessoas}" var="pessoa">
				<tr>
					<td>${pessoa.nome}</td>
					<td>${pessoa.cpf}</td>
					<td>${pessoa.telefone}</td>
					<td><a href="editar?cpf=${pessoa.cpf}">editar</a></td>					
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>