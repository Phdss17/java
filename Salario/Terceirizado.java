class Terceirizado extends Funcionario {
    protected int horas;
    protected boolean isSalubre;

    public Terceirizado(String nome, int horas, String isSalubre) {
    }

    public int getHoras() {
    }

    public String getIsSalubre() {
    }

    //lance uma MsgException com um texto diferente
    @Override
    public void addDiaria() {
    }

    //lógica do salário do terceirizado
    //usa o super.getSalario() para pegar bonus e diarias
    @Override
    public int getSalario() {
    }

    @Override
    public String toString() {
    }
}