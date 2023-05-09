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
import javax.servlet.http.HttpSession;

@WebServlet(name = "excluirUsuario", value = "/excluirUsuario")
public class ExcluirUsuario extends HttpServlet {

    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        // Sessão excluída
        session.invalidate();

        // Redireciona de volta para a lista de usuários
        resp.sendRedirect("index.jsp");
    }
}
