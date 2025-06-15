public class Solver {
    public static void main(String[] arg) {
        System.out.println("side_by_side=080");
        Pig pig = new Pig(0);

        while (true) {
            String[] line = IO.inputPartsPrintingLine();

            if      (line[0].equals("end") )            { break; }
            else if (line[0].equals("init"))            { pig = new Pig(IO.strToInt(line[1])); }
            else if (line[0].equals("break"))           { pig.breakPig(); }
            else if (line[0].equals("addCoin"))         { 
                int aux = IO.strToInt(line[1]);
                if(aux == 10){
                    pig.addCoin(Coin.C10);
                }else if(aux == 25){
                    pig.addCoin(Coin.C25);
                }else if(aux == 50){
                    pig.addCoin(Coin.C50);
                }else if(aux == 100){
                    pig.addCoin(Coin.C100);
                }else{
                    IO.println("fail: invalid coin value");
                }
            }
            else if (line[0].equals("addItem"))         { pig.addItem(new Item(line[1], IO.strToInt(line[2]))); }
            else if (line[0].equals("extractItems"))    { IO.println(pig.extractItems()); }
            else if (line[0].equals("extractCoins"))    { IO.println(pig.extractCoins()); }
            else if (line[0].equals("show"))            { IO.println(pig); }
            else                                        { IO.println("fail: comando invalido"); }
        }
    }
}