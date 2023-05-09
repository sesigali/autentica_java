package br.ifsp.pw3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "autenticar", value = "/autenticar")
public class Autentica extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        String usuarioSessao = (String)session.getAttribute("usuario");
        String senhaSessao = (String)session.getAttribute("senha");
        
        // Recebe as informações enviadas pelo formulário
        String usuario = req.getParameter("usuario");
        String senha = req.getParameter("senha");

        // Verifica se o usuário está cadastrado
        boolean autenticado = false;
        if (usuarioSessao != null && senhaSessao != null && usuarioSessao.equals(usuario) && senhaSessao.equals(senha)) {
            autenticado = true;
        }
        // Redireciona o usuário para a página correta de acordo com o resultado da autenticação
        if (autenticado) {
            resp.sendRedirect("listaUsuario.jsp");
        } else {
            resp.sendRedirect("erro.jsp");
        }
    }
}
