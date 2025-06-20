
class FuncionarioAutenticavel extends Funcionario implements Autenticavel {
    private String senha;
    private boolean logado;

    public FuncionarioAutenticavel(String nome) {
        this.senha = "indefinida";
        this.logado = false;
    }
    
    public void setSenha(String senha) {
    }
    public String getSenha() {
    }
    public void setLogado(boolean logado) {
    }
    public String getLogado() {
        return this.logado ? "online" : "offline";
    }

    public void logar( String senha ) {
    }
    public void deslogar() {
    }
}