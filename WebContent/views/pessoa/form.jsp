<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro Usuário</title>
</head>
<body>
	<form:form id="pessoaForm" method="post" action="/Bib/pessoa/registrar_atualizar" modelAttribute="pessoa">
		<form:hidden path="id" value="${pessoa.id}"/>
		<label>nome</label>
		<form:input path="nome" value="${pessoa.nome}"/>

		<label>cpf</label>
		<form:input path="cpf" value="${pessoa.cpf}" />

		<label>telefone</label>
		<form:input path="telefone" value="${pessoa.telefone}"/>

		<input type="submit" value="Registrar" />
	</form:form>
</body>
</html>