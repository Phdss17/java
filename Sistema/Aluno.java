
class Aluno implements Autenticavel {
    private String nome;
    private String curso;
    private int bolsa;

    private String senha;
    private boolean logado;

    public Aluno(String nome, String curso, int bolsa) {
        this.nome = nome;
        this.curso = curso;
        this.bolsa = bolsa;
        this.senha = "indefinida";
        this.logado = false;
    }
    
    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public int getBolsa() {
        return bolsa;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public String getLogado() {
        return this.logado ? "online" : "offline";
    }

    public void logar( String senha ) {
        this.logado = this.senha.equals(senha) ? true : false; 
    }

    public void deslogar() {
        this.logado = false;
    }

    @Override
    public String toString() {
        return nome + ":" + curso + ":" + bolsa;
    }
}