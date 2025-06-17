public class Moto extends Veiculo{
    Moto(String id){
        super(id, "Moto");
    }

    @Override
    public int calcularValor(int horaSaida){
        int pagar = (horaSaida - getEntrada())/20;
        return pagar;
    }
}