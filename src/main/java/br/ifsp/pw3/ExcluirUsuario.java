package br.ifsp.pw3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "excluirUsuario", value = "/excluirUsuario")
public class ExcluirUsuario extends HttpServlet {

    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recebe o usuário a ser excluído
        String usuarioExcluir = req.getParameter("usuario");

        // Percorre a lista de usuários procurando pelo usuário a ser excluído
        Iterator<Usuario> iterator = usuarios.iterator();
        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();
            if (usuario.getUsuario().equals(usuarioExcluir)) {
                // Remove o usuário da lista
                iterator.remove();
                break;
            }
        }

        // Redireciona de volta para a lista de usuários
        resp.sendRedirect("cadastro.jsp");
    }
}
