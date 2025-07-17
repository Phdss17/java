import java.util.*;
class UFC {
    private Map<String, Funcionario> funcionarios = new TreeMap<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        funcionarios.forEach((k, v) -> sb.append(v.toString() + "\n"));
        return sb.toString();
    }

    public Funcionario getFuncionario(String nome) {
        if(funcionarios.containsKey(nome)){
            return funcionarios.get(nome);
        }else{
            throw new MsgException("fail: funcionario nao encontrado");
        }
    }

    public void addFuncionario(Funcionario funcionario) {
        funcionarios.put(funcionario.getNome(), funcionario);
    }
    
    public void rmFuncionario(String nome) {
        if(funcionarios.containsKey(nome)){
            funcionarios.remove(nome);
        }else{
            throw new MsgException("fail: funcionario nao encontrado");
        }
    }

    //reparte o bonus para todos os funcionarios
    public void setBonus(int bonus) {
        if ( this.funcionarios.size() == 0 ) {
            throw new MsgException("fail: sem funcionarios");
        }else{
            int bonusPorFuncionario = bonus / this.funcionarios.size();
            funcionarios.forEach((k, v) -> v.setBonus(bonusPorFuncionario));
        }
    }
}
