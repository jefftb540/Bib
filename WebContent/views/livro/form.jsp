<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Livro</title>
</head>
<body>

	
	
	<form:form id="livroForm" method="post" action="registrar_atualizar/" modelAttribute="livro">
		<form:hidden path="id" value="${livro.id}" />
		<br><label>ISBN</label><form:input path="isbn" value="${livro.isbn}" />
		<br><label>titulo</label><form:input path="titulo" value="${livro.titulo}" />
		<br><label>codigo barra</label><form:input path="codigoBarra" value="${livro.codigoBarra}" />
		<br><label>estante</label><form:input path="estante" value="${livro.estante}" />
		<br><label>exemplares</label><form:input path="exemplares" value="${livro.exemplares}" />
		<br><label>disponiveis</label><form:input path="disponiveis" value="${livro.disponiveis}" />
		<br><label>ano</label><form:input path="ano" value="${livro.ano}" />
		<br><label>volume</label><form:input path="volume" value="${livro.volume}" />
		<br><label>edicao</label><form:input path="edicao" value="${livro.edicao}" />
		<br><label>Editora</label>
			<form:select path="editora.id">
				<c:forEach items="${editoras}" var="editora">
					<form:option value="${editora.id}">${editora.nome} - ${editora.tipo()}</form:option>
				</c:forEach>
			</form:select>
		<br><input type="submit" value="Registrar" />
	</form:form>

</body>
</html>