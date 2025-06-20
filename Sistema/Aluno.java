
class Aluno implements Autenticavel {
    private String nome;
    private String curso;
    private int bolsa;

    private String senha;
    private boolean logado;

    public Aluno(String nome, String curso, int bolsa) {
        //...

        this.senha = "indefinida";
        this.logado = false;
    }
    
    public String getNome() {
    }
    public String getCurso() {
    }
    public int getBolsa() {
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

    @Override
    public String toString() {
    }
}