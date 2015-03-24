<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro Editora</title>
</head>
<body>
	<form:form id="editoraForm" method="post" action="registrar_atualizar" modelAttribute="editora">
		<form:hidden path="id" value="${editora.id}"/>
		<label>nome</label>
		<form:input path="nome" value="${editora.nome}"/>
		<label>tipo</label>
		<form:select path="tipo">
			<form:option value="1">Nacional</form:option>
			<form:option value="2">Internacional</form:option>
		</form:select>
		
	
		<input type="submit" value="Registrar" />
	</form:form>
</body>
</html>