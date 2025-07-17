class Terceirizado extends Funcionario {
    protected int horas;
    protected boolean isSalubre;

    public Terceirizado(String nome, int horas, String isSalubre) {
        super(nome);
        this.horas = horas;
        if(isSalubre.equals("sim")){
            this.isSalubre = true;
        }else if(isSalubre.equals("nao")){
            this.isSalubre = false;
        }else{
            throw new MsgException("fail: argumento invalido");
        }
    }

    public int getHoras() {
        return horas;
    }

    public String getIsSalubre() {
        return isSalubre ? "sim" : "nao";
    }

    //lance uma MsgException com um texto diferente
    @Override
    public void addDiaria() {
        throw new MsgException("fail: terc nao pode receber diaria");
    }

    //lógica do salário do terceirizado
    //usa o super.getSalario() para pegar bonus e diarias
    @Override
    public int getSalario() {
        return 4 * horas + (isSalubre ? 500 : 0);
    }

    @Override
    public String toString() {
        return "terc:" + getNome() + ":" + getHoras() + ":" + getIsSalubre() + ":" + this.getSalario();
    }
}