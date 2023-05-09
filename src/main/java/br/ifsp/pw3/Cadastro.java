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

@WebServlet(name = "cadastro", value = "/cadastro")
public class Cadastro extends HttpServlet {

    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //super.doPost(req, resp);

        // Recebe as informações enviadas pelo formulário
        String usuario = req.getParameter("usuario");
        String senha = req.getParameter("senha");
        String nomeCompleto = req.getParameter("nomeCompleto");
        String cpf = req.getParameter("cpf");
        String email = req.getParameter("email");

        // Cria um novo usuário com as informações recebidas
        Usuario novoUsuario = new Usuario(usuario, senha, nomeCompleto, cpf, email);

        // Adiciona o novo usuário à lista de usuários
        usuarios.add(novoUsuario);

        // Armazena as informações do novo usuário em uma variável de sessão
        HttpSession session = req.getSession();
        session.setAttribute("usuario", usuario);
        session.setAttribute("senha", senha);
        session.setAttribute("nomeCompleto", nomeCompleto);
        session.setAttribute("cpf", cpf);
        session.setAttribute("email", email);
        
        // Redireciona para a página de autenticação
        resp.sendRedirect("autenticar.jsp");
    }   
    
}
