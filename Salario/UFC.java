class UFC {
    private Map<String, Funcionario> funcionarios = new TreeMap<>();

    @Override
    public String toString() {
    }

    public Funcionario getFuncionario(String nome) {
    }

    public void addFuncionario(Funcionario funcionario) {
    }
    
    public void rmFuncionario(String nome) {
    }

    //reparte o bonus para todos os funcionarios
    public void setBonus(int bonus) {
        if ( this.funcionarios.size() == 0 ) {
            throw new MsgException("fail: sem funcionarios");
        }
    }
}
