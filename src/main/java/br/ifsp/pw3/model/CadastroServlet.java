package br.ifsp.pw3.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifsp.pw3.model.dao.UsuarioDao;
import br.ifsp.pw3.model.domain.Usuario;

@WebServlet(name = "cadastro", value = "/cadastro")
public class CadastroServlet extends HttpServlet {
    
    //private List<Usuario> usuarios = new ArrayList<>();
    
    @Override
    public void init() throws ServletException {
        UsuarioDao dao = new UsuarioDao();
    
        dao.criarTabela();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // Recebe as informações enviadas pelo formulário
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String usuario = req.getParameter("usuario");
        String senha = req.getParameter("senha");
        String nomeCompleto = req.getParameter("nomeCompleto");
        String cpf = req.getParameter("cpf");
        String email = req.getParameter("email");



        // Cria um novo usuário com as informações recebidas
        Usuario novoUsuario = new Usuario(id, usuario, senha, nomeCompleto, cpf, email);
                //System.out.println(novoUsuario.toString());
        UsuarioDao dao = new UsuarioDao();

        // Adiciona o novo usuário à lista de usuários
        dao.inserir(novoUsuario);
        
        // Redireciona para a página de autenticação
        resp.sendRedirect("autenticar.jsp");
    }

    
}
