package br.ifsp.pw3.model.domain;

public class Usuario {

    private int id;
    private String usuario;
    private String senha;
    private String nomeCompleto;
    private String cpf;
    private String email;

    public Usuario(){
        id = -1;
        usuario = "";
        senha = "";
        nomeCompleto = "";
        cpf = "";
        email = "";
    }

    public Usuario(int id, String usuario, String senha, String nomeCompleto, String cpf, String email) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
    }

    public Usuario(String usuario, String senha, String nomeCompleto, String cpf, String email) {
        this.usuario = usuario;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
    }
    
    // Construtor e getters/setters aqui
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }    
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

     @Override
    public String toString() {
        return "Usuario [id=" + id + ", usuario=" + usuario + ", senha=" + senha + ", nomeCompleto=" + nomeCompleto
                + ", cpf=" + cpf + ", email=" + email + "]";
    }
}
