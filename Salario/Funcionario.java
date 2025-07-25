abstract class Funcionario {
    protected String nome;
    protected int bonus;
    protected int diarias;
    protected int maxDiarias;

    public Funcionario(String nome) {
        this.nome = nome;
        this.bonus = 0;
        this.diarias = 0;
        this.maxDiarias = 0;
    }

    public String getNome() {
        return this.nome;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    //se atingiu o máximo, lance uma MsgException
    //se não atingiu o máximo, adicione mais uma diária
    public void addDiaria() {
        if(diarias == maxDiarias){
            throw new MsgException("fail: limite de diarias atingido");
        }
        diarias++;
    }

    //retorna bonus + diarias * 100
    public int getSalario() {
        return bonus + diarias * 100;
    }
}
