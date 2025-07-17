class Professor extends Funcionario {
    protected String classe;

    //inicializa classe e muda maxDiarias para 2
    public Professor(String nome, String classe) {
        super(nome);
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
            case "A";
            
        }
    }

    @Override
    public String toString() {
    }
}