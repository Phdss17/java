import java.util.ArrayList;
import java.text.DecimalFormat;

public class Estacionamento{
    private ArrayList<Veiculo> estacionamento;
    private int horaAtual;

    public Estacionamento(){
        this.estacionamento = new ArrayList<>();
        this.horaAtual = 0;
    }

    private int procurarVeiculo(String id){
        for(int i = 0; i < estacionamento.size(); i++){
            if(estacionamento.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public void estacionar(Veiculo v){
        estacionamento.add(v);
        v.setEntrada(horaAtual);
    }

    public void pagar(String id){
         int index = procurarVeiculo(id);
        int valor = estacionamento.get(index).calcularValor(horaAtual);
        Veiculo aux = estacionamento.remove(index);
        DecimalFormat d = new DecimalFormat("0.00");

        IO.println(aux.getTipo() + " chegou " + aux.getEntrada() + 
        " saiu " + horaAtual + ". Pagar R$ " + d.format(valor));
    }

    public void sair(String id){
        int index = procurarVeiculo(id);
        int valor = estacionamento.get(index).calcularValor(horaAtual);
        Veiculo aux = estacionamento.remove(index);
        DecimalFormat d = new DecimalFormat("0.00");

        IO.println(aux.getTipo() + " chegou " + aux.getEntrada() + 
        " saiu " + horaAtual + ". Pagar R$ " + d.format(valor));
    }

    public void passarTempo(int tempo){
        this.horaAtual += tempo;
    }

    @Override 
    public String toString(){
        String str = "";
        for(Veiculo v : estacionamento){
            str += String.format(
                "%10s-:-%10s-:-%s", //alinhar a direita 10 caracteres inserindo espaços
                v.getTipo(),
                v.getId(),
                v.getEntrada()
            )
                .replace(' ', '_') //substituir espaço por underline
                .replace('-', ' ');//substituir hífen por espaço
            }
            str += "Hora atual: " + horaAtual;

            return str;
        }
    }