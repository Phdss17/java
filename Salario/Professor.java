import java.util.*;
class Professor extends Funcionario {
    protected String classe;

    //inicializa classe e muda maxDiarias para 2
    public Professor(String nome, String classe) {
        super(nome);
        super.maxDiarias = 2;
        ArrayList<String> classes = new ArrayList<>();
        classes.add("A");classes.add("B");classes.add("C");classes.add("D");classes.add("E");    
        if(!classes.contains(classe)){
            throw new MsgException("fail: classe invalida");
        }
        this.classe = classe;
    }

    public String getClasse() {
        return this.classe;
    }
    
    //lógica do salário do professor
    //usa o super.getSalario() para pegar bonus e diarias
    @Override
    public int getSalario() {
        int salario = super.getSalario();
        switch(classe){
            case "A":
            return salario + 3000;
            case "B":
            return salario + 5000;
            case "C":
            return salario + 7000;
            case "D":
            return salario + 9000;
            case "E":
            return salario + 11000;
            default:
            throw new MsgException("fail: classe invalida");
        }
    }

    @Override
    public String toString() {
        return "prof:" + getNome() + ":" + getClasse() + ":" + getSalario();
    }
}