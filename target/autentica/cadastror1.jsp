<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Cadastro de Usuário</h1>
	<form action="cadastrarUsuario" method="post">
		<label for="usuario">Usuário:</label>
		<input type="text" name="usuario" required><br><br>
		
		<label for="senha">Senha:</label>
		<input type="password" name="senha" required><br><br>
		
		<label for="nome">Nome Completo:</label>
		<input type="text" name="nome" required><br><br>
		
		<label for="cpf">CPF:</label>
		<input type="text" name="cpf" required><br><br>
		
		<label for="email">E-mail:</label>
		<input type="email" name="email" required><br><br>
		
		<input type="submit" value="Cadastrar">
	</form>

    <h1>Lista de Usuários</h1>
	<table>
		<tr>
			<th>Usuário</th>
			<th>Nome Completo</th>
			<th>CPF</th>
			<th>E-mail</th>
			<th>Ações</th>
		</tr>
		
		<c:forEach var="usuario" items="${usuarios}">
			<tr>
				<td>${usuario.usuario}</td>
				<td>${usuario.nome}</td>
				<td>${usuario.cpf}</td>
				<td>${usuario.email}</td>
				<td>
					<a href="editarUsuario?usuario=${usuario.usuario}">Editar</a>
					<a href="excluirUsuario?usuario=${usuario.usuario}">Excluir</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	<a href="cadastro1">Cadastrar novo usuário</a>
</body>
</html>