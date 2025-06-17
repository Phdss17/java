public class Solver {
    public static void main(String[] arg) {
        Estacionamento e = new Estacionamento();
        while (true) {
            String line = IO.input();
            IO.println("$" + line);
            String[] args = line.split(" ");

            if      (args[0].equals("end"))             { break; }
            else if (args[0].equals("show"))            { IO.println(e); }
            else if (args[0].equals("estacionar"))      { if(args[1].equals("moto")){e.estacionar(new Moto(args[2])); } 
                                                          else if(args[1].equals("carro")){ e.estacionar(new Carro(args[2])); }
                                                          else{ e.estacionar(new Bike(args[2])); } }          
            else if (args[0].equals("tempo"))           { e.passarTempo(IO.strToInt(args[1])); }
            else if (args[0].equals("pagar"))           { e.pagar(args[1]); }
            else if (args[0].equals("sair"))            { e.sair(args[1]); }
            else if (args[0].equals("show"))            { IO.println(e); }
            else                                        { IO.println("fail: comando invalido"); }
        }
    }
}