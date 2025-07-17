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
            throw new MsgException("fail: usuario " + nome + " já existe!");
        }
        
        Funcionario func = this.ufc.getFuncionario(nome);
        if ( func instanceof Terceirizado ) {
            throw new MsgException("fail: terc nao pode ser cadastrado no sistema");
        }

        Autenticavel usu = (Autenticavel) func;
        if (usu == null) {
            usu = this.ufc.getAluno(nome);
            if (usu == null) {
                throw new MsgException("fail: " + nome + " nao encontrado");
            }
        }

        this.usuarios.put(nome, usu);
        usu.setSenha(senha);
    }

    public void rmUsuario(String nome) {
        if(this.usuarios.containsKey(nome)){
            this.usuarios.remove(nome);
        }else{
            throw new MsgException("fail: usuario " + nome + " nao encontrado");
        } 
    }
    
    public void logar(String nome, String senha) {
        if(this.usuarios.containsKey(nome)){
            this.usuarios.get(nome).logar(senha);
        }else{
            throw new MsgException("fail: usuario " + nome + " nao encontrado");
        }
    }

    public void deslogar(String nome) {
        if(this.usuarios.containsKey(nome)){
            this.usuarios.get(nome).deslogar();
        }else{
            throw new MsgException("fail: usuario " + nome + " nao encontrado");
        }
    }

    public void deslogarTodos() {
        this.usuarios.forEach((key, user) -> user.deslogar());
    }

    public String showUser( String nome ) {
        if(this.usuarios.containsKey(nome)){
            Autenticavel aux = this.usuarios.get(nome);
            return aux + ":" + aux.getSenha() + ":" + aux.getLogado();
        }
        return "fail: usuario " + nome + " nao encontrado";
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