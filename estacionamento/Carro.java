public class Carro extends Veiculo{
    Carro(String id){
        super(id, "Carro");
    }

    @Override
    public int calcularValor(int horaSaida){
        int pagar = (horaSaida - getEntrada())/10;
        if(pagar < 5){
            pagar = 5;
        }

        return pagar;
    }
}
