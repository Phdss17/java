interface Autenticavel {
    void logar( String senha );
    void deslogar();

    String getNome();
    void setSenha(String senha);
    String getSenha();
    void setLogado(boolean logado);
    String getLogado();
}