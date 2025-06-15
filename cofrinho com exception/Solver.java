public class Solver {
    public static void main(String[] arg) {
        System.out.println("side_by_side=080");
        
        Pig pig = new Pig(0);

        while (true) {
            try{
            String[] line = IO.inputPartsPrintingLine();

            if      (line[0].equals("end") )    { break; }
            else if (line[0].equals("init"))    { pig = new Pig(IO.strToInt(line[1])); }
            else if (line[0].equals("show"))    { IO.print(pig); }
            else                                { IO.println("fail: comando invalido"); }
            }catch(Exception excep){
                String str = excep.getMessage();
                if(str != null){
                    IO.println(str);
                }
            }
        }
    }
}