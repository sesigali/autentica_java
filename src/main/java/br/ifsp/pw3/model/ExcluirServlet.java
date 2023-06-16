package br.ifsp.pw3.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifsp.pw3.model.dao.UsuarioDao;

@WebServlet(name = "excluirUsuario", value = "/excluirUsuario")
public class ExcluirServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // Obtém o ID do usuário a ser excluído a partir dos parâmetros da requisição
        String idString = req.getParameter("id");

        // Verifica se o ID é válido
        if (idString != null && !idString.isEmpty()) {
            int id = Integer.parseInt(idString);

            // Cria uma instância do UsuarioDao
            UsuarioDao usuarioDao = new UsuarioDao();

            // Exclui o usuário do banco de dados
            usuarioDao.excluir(id);
        }

        // Redireciona de volta para a lista de usuários
        resp.sendRedirect("listaUsuario.jsp");
    }
}
