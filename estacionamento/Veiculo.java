abstract public class Veiculo{
    private String id;
    protected String tipo;
    protected int horaEntrada;

    public Veiculo(String id, String tipo){
        this.id = id;
        this.tipo = tipo;
    }

    public void setEntrada(int horaEntrada){
        this.horaEntrada = horaEntrada;
    } 

    public int getEntrada(){
        return horaEntrada;
    }

    public String getTipo(){
        return tipo;
    }

    public String getId(){
        return id;
    }

    public abstract int calcularValor(int horaSaida);

    @Override
    public String toString(){
        return tipo + " " + id;
    }
}