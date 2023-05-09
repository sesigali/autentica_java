package br.ifsp.pw3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "editarUsuario", value = "/editarUsuario")
public class EditarUsuario extends HttpServlet {

    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // super.doGet(req, resp);

        String usuario = req.getParameter("usuario");

        // Busca o usuário com o nome de usuário especificado
        Usuario usuarioEditado = null;
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario)) {
                usuarioEditado = u;
                break;
            }
        }

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
        // TODO Auto-generated method stub
        // super.doPost(req, resp);

        HttpSession session = req.getSession();

        // Recupera o usuário a ser editado da variável de sessão
        Usuario usuarioEditado = (Usuario) session.getAttribute("usuarioEditado");

        // Recupera as informações atualizadas do usuário
        String senha = req.getParameter("senha");
        String nomeCompleto = req.getParameter("nomeCompleto");
        String cpf = req.getParameter("cpf");
        String email = req.getParameter("email");

        // Atualiza as informações do usuário
        usuarioEditado.setSenha(senha);
        usuarioEditado.setNomeCompleto(nomeCompleto);
        usuarioEditado.setCpf(cpf);
        usuarioEditado.setEmail(email);

        // Redireciona para a página de lista de usuários
        resp.sendRedirect("listaUsuario.jsp");
    }
}
