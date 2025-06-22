import java.util.*;
public class Sistema {
    private UFC ufc;
    private Map<String, Autenticavel> usuarios;

    public Sistema() {
        this.ufc = new UFC();
        this.usuarios = new TreeMap<String, Autenticavel>();
    }

    public UFC getUFC() {
        return ufc;
    }

    public Autenticavel getUsuario(String nome) {
        return this.usuarios.get(nome);
    }

    public void addUsuario(String nome, String senha) {
        if(this.usuarios.containsKey(nome)){
            return;
        }
        Autenticavel a = new FuncionarioAutenticavel(nome);
        a.setSenha(senha);
        this.usuarios.put(nome, a);
    }

    public void rmUsuario(String nome) {
        this.usuarios.remove(nome);
    }
    
    public void logar(String nome, String senha) {
        this.usuarios.get(nome).logar(senha);
    }

    public void deslogar(String nome) {
        this.usuarios.get(nome).deslogar();
    }

    public void deslogarTodos() {
        this.usuarios.forEach((key, user) -> user.deslogar());
    }

    public String showUser( String nome ) {
        return this.usuarios.get(nome).toString();
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