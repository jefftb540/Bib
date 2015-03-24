<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editoras</title>
</head>
<body>
	<c:if test="${!empty editoras}">
		<table border="1">
			<tr>
				<td>Nome</td>
				<td colspan="3">Tipo</td>				
			</tr>
			<c:forEach items="${editoras}" var="editora">
				<tr>
					<td>${editora.nome}</td>
					<td>${editora.tipo()}</td>					
					<td><a href="editar?id=${editora.id}">editar</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>