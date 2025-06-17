public class Bike extends Veiculo{
    Bike(String id){
        super(id, "Bike");
    }

    @Override
    public int calcularValor(int horaSaida){
        return 3;
    }
}
