package Calculadora.src;

class Solver {
    public static void main (String[] arg) {
        Calculator calc = new Calculator(0);

        while (true) {
            String line = IO.input();
            IO.println("$" + line);
            String[] args = line.split(" ");

            if      (args[0].equals("end"))   { break;                                 }
            else if (args[0].equals("init"))  { calc = new Calculator(IO.strToInt(args[1]));  }
            else if (args[0].equals("sum"))   { calc.sum(IO.strToInt(args[1]), IO.strToInt(args[2]));  }
            else if (args[0].equals("div"))   { calc.div(IO.strToFloat(args[1]), IO.strToInt(args[2]));}
            else if (args[0].equals("charge")){ calc.charge(IO.strToInt(args[1]));            }
            else if (args[0].equals("show"))  { IO.println( calc.toString() );         }
            else                              { IO.println("fail: comando invalido");  }
        }
    }
}
