public class Sistema {
    private UFC ufc;
    private Map<String, Autenticavel> usuarios;

    public Sistema() {
    }

    public UFC getUFC() {
    }

    public Autenticavel getUsuario(String nome) {
    }

    public void addUsuario(String nome, String senha) {
    }

    public void rmUsuario(String nome) {
    }
    
    public void logar(String nome, String senha) {
    }
    public void deslogar(String nome) {
    }
    public void deslogarTodos() {
    }

    public String showUser( String nome ) {
    }

    @Override
    public String toString() {
        String s = "";
        for ( Autenticavel u : this.usuarios.values() ) {
            s += u + ":" + u.getSenha() + ":" + u.getLogado() + "\n";
        }
        return s;
    }
}