<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="br.ifsp.pw3.Usuario, java.util.*"%>
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
		<tr>
			<td><%= session.getAttribute("usuario") %></td>
			<td><%= session.getAttribute("nomeCompleto") %></td>
			<td><%= session.getAttribute("cpf") %></td>
			<td><%= session.getAttribute("email") %></td>
			<td>
				<a href="editarUsuario.jsp">Editar</a>
				<a href="excluirUsuario?usuario=<%= session.getAttribute("usuario") %>">Excluir</a>
			</td>
		</tr>
	</table>
		<a href="index.jsp"><button class="button button2">SAIR</button></a>
    <footer>
        <h2>IFSP São Carlos</h2>
    </footer>  
</body>
</html>