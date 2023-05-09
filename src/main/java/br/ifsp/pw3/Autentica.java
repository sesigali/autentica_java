package br.ifsp.pw3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "autenticar", value = "/autenticar")
public class Autentica extends HttpServlet {

    private List<Usuario> usuarios;

    @Override
    public void init() throws ServletException {
        Object usuariosObj = getServletContext().getAttribute("usuarios");
        if (usuariosObj instanceof List) {
            usuarios = (List<Usuario>) usuariosObj;
        } else {
            usuarios = new ArrayList<>();
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Recebe as informações enviadas pelo formulário
        String usuario = req.getParameter("usuario");
        String senha = req.getParameter("senha");

        // Verifica se o usuário está cadastrado
        boolean autenticado = false;
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario) && u.getSenha().equals(senha)) {
                autenticado = true;
                break;
            }
        }

        // Redireciona o usuário para a página correta de acordo com o resultado da autenticação
        if (autenticado) {
            req.getRequestDispatcher("listaUsuario.jsp").forward(req, resp);
            //resp.sendRedirect("listaUsuario.jsp");
        } else {
            resp.sendRedirect("erro.jsp");
        }
    }
}
