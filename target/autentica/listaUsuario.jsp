<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="seuPacote.Usuario" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estilo.css">
    <title>Usuários</title>
</head>
<body>
    <h1>Usuário</h1>
	<table>
		<tr>
			<th>Usuário</th>
			<th>Nome Completo</th>
			<th>CPF</th>
			<th>E-mail</th>
			<th>Ações</th>
		</tr>
		<c:forEach var="u" items="${usuario}">
			<tr>
				<td>${u.usuario}</td>
				<td>${u.nomeCompleto}</td>
				<td>${u.cpf}</td>
				<td>${u.email}</td>
				<td>
					<a href="editarUsuario?usuario=${u.usuario}">Editar</a>
					<a href="excluirUsuario?usuario=${u.usuario}">Excluir</a>
				</td>
			</tr>
		</c:forEach>
	</table>
    <footer>
        <h2>IFSP São Carlos</h2>
    </footer>  
</body>
</html>