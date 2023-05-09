<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estilo.css">
    <title>Editar Usuario</title>
</head>
<body>
    <h1>Editar Usuário</h1>
    <form action="editarUsuario"  id="formulario" method="post">
        <label for="usuario">Usuário:</label>
        <input type="text" id="usuario" name="usuario" value="<%= session.getAttribute("usuario") %>" required><br>
      
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" value="<%= session.getAttribute("senha") %>" required><br>
      
        <label for="nomeCompleto">Nome completo:</label>
        <input type="text" id="nomeCompleto" name="nomeCompleto" value="<%= session.getAttribute("nomeCompleto") %>" required><br>
      
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" value="<%= session.getAttribute("cpf") %>" required><br>
      
        <label for="email">E-mail:</label>
        <input type="email" id="email" name="email" value="<%= session.getAttribute("email") %>" required><br>
      
        <input type="submit" value="Salvar">
      </form>
    <footer>
        <h2>IFSP São Carlos</h2>
    </footer>    
</body>
</html>