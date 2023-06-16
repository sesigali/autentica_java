package br.ifsp.pw3.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ifsp.pw3.model.dao.UsuarioDao;
import br.ifsp.pw3.model.domain.Usuario;

@WebServlet(name = "editarUsuario", value = "/editarUsuario")
public class EditarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String usuario = req.getParameter("usuario");

        // Busca o usuário com o nome de usuário especificado
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuarioEditado = usuarioDao.getUsuarioByUsuario(usuario);

        // Verifica se o usuário existe
        if (usuarioEditado != null) {
            // Armazena as informações do usuário em uma variável de sessão
            HttpSession session = req.getSession();
            session.setAttribute("usuarioEditado", usuarioEditado);

            // Redireciona para a página de edição de usuário
            resp.sendRedirect("editarUsuario.jsp");
        } else {
            // Caso o usuário não exista, redireciona de volta para a página de lista de usuários
            resp.sendRedirect("listaUsuario.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //HttpSession session = req.getSession();
        //Usuario usuarioEditado = (Usuario) session.getAttribute("usuarioEditado");
        //System.out.println(usuarioEditado.toString());
        Usuario usuarioEditado = new Usuario();

        // Atualiza as informações atualizadas do usuário
        usuarioEditado.setId(Integer.parseInt(req.getParameter("id")));
        usuarioEditado.setUsuario(req.getParameter("usuario"));
        usuarioEditado.setSenha(req.getParameter("senha"));
        usuarioEditado.setNomeCompleto(req.getParameter("nomeCompleto"));
        usuarioEditado.setCpf(req.getParameter("cpf"));
        usuarioEditado.setEmail(req.getParameter("email"));

        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.alterar(usuarioEditado);

        // Redireciona para a página de lista de usuários
        resp.sendRedirect("listaUsuario.jsp");
    }
}
