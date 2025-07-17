class STA extends Funcionario {
    protected int nivel;

    //inicializa nivel e muda maxDiarias para 1
    public STA(String nome, int nivel) {
        super(nome);
        this.nivel = nivel;
        maxDiarias = 1;
    }
    
    public int getNivel() {
        return nivel;
    }

    //lógica do salário do sta
    //usa o super.getSalario() para pegar bonus e diarias
    @Override
    public int getSalario() {
        return 3000 + super.getSalario() + 300 * nivel; 
    }

    @Override
    public String toString() {
        return "sta:" + getNome() + ":" + getNivel() + ":" + getSalario();
    }
}