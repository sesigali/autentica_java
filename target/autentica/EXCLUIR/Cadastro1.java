package br.ifsp.pw3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "cadastro1", value = "/cadastro1")
public class Cadastro1 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
        String nomeCompleto = request.getParameter("nomeCompleto");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		
		Usuario novoUsuario = new Usuario(usuario, senha, nomeCompleto, cpf, email);
		
		HttpSession session = request.getSession();
		session.setAttribute("usuarioLogado", novoUsuario);
		
		response.sendRedirect("listaUsuarios.jsp");
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("usuarioLogado") != null) {
            // Se há uma sessão válida e o usuário está autenticado, exibe as informações do usuário
            Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
            
            // Simula uma lista de usuários para ser exibida na página
            List<Usuario> usuarios = new ArrayList<>();
            usuarios.add(usuario);
            
            request.setAttribute("usuarios", usuarios);
            RequestDispatcher rd = request.getRequestDispatcher("listaUsuarios.jsp");
            rd.forward(request, response);
        } else {
            // Se o usuário não está autenticado, redireciona para a página de login
            response.sendRedirect("cadastro1.jsp");
        }
    }

}

