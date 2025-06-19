public class Solver {
        public static void main(String[] arg) {
                Agency agency = new Agency();

        while (true) {
            String line = IO.input();
            IO.println("$" + line);
            String[] args = line.split(" ");

            try {
                if      (args[0].equals("end"))       { break; }
                else if (args[0].equals("show"))      { IO.print(agency); }
                else if (args[0].equals("addCli"))    { agency.addClient( args[1] ); }
                else if (args[0].equals("deposito"))  { agency.deposit( IO.strToInt(args[1]), IO.strToDouble(args[2]) ); }
                else if (args[0].equals("saque"))     { agency.withdraw( IO.strToInt(args[1]), IO.strToDouble(args[2]) ); }
                else if (args[0].equals("transf"))    { agency.transfer( IO.strToInt(args[1]), IO.strToInt(args[2]), IO.strToDouble(args[3])); }
                else if (args[0].equals("update"))    { agency.updateMonthly(); }
                else                                  { IO.println("fail: comando invalido"); }
            } catch (Exception e) {
                IO.println( e.getMessage() );
            }
        }
    }
}

// import java.util.*;

// public class Solver {
//     public static void main(String[] arg) {
//         Agency agency = new Agency();

//         while (true) {
//             String line = input();
//             println("$" + line);
//             String[] args = line.split(" ");

//             try {
//                 if      (args[0].equals("end")      )       { break; }
//                 else if (args[0].equals("show")     )       { print(agency); }
//                 else if (args[0].equals("addCli")   )       { agency.addClient( args[1] ); }
//                 else if (args[0].equals("deposito") )       { agency.deposit( (int) number(args[1]), number(args[2]) ); }
//                 else if (args[0].equals("saque")    )       { agency.withdraw( (int) number(args[1]), number(args[2]) ); }
//                 else if (args[0].equals("transf")   )       { agency.transfer( (int) number(args[1]), (int) number(args[2]), number(args[3]) ); }
//                 else if (args[0].equals("update")   )       { agency.updateMonthly(); }
//                 else                                        { println("fail: comando invalido"); }
//             } catch (Exception e) {
//                 println( e.getMessage() );
//             }
//         }
//     }

//     private static Scanner scanner = new Scanner(System.in);
//     private static String  input()                { return scanner.nextLine();        }
//     private static double  number(String value)   { return Double.parseDouble(value); }
//     public  static void    println(Object value)  { System.out.println(value);        }
//     public  static void    print(Object value)    { System.out.print(value);          }
// }