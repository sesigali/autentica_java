<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Usuário</title>
</head>
<body>
    <h1>Cadastro de Usuário</h1>
	<form action="cadastro1" method="post">
		<label for="usuario">Usuário:</label>
		<input type="text" name="usuario" required><br><br>
		
		<label for="senha">Senha:</label>
		<input type="password" name="senha" required><br><br>
		
		<label for="nomeCompleto">Nome Completo:</label>
		<input type="text" name="nomeCompleto" required><br><br>
		
		<label for="cpf">CPF:</label>
		<input type="text" name="cpf" required><br><br>
		
		<label for="email">E-mail:</label>
		<input type="email" name="email" required><br><br>
		
		<input type="submit" value="Cadastrar">
	</form>
</body>
</html>