import java.util.*;

public class Solver {
    public static void main(String[] arg) {
        List<Shapes> shapes = new ArrayList<>(); 

        while (true) {
            String line = IO.input();
            IO.println("$" + line);
            String[] args = line.split(" ");

            if      (args[0].equals("end"))       { break; }
            // else if (args[0].equals("circle"))    { shape = new Circle( new Point2D( IO.strToDouble(args[1]), IO.strToDouble(args[2]) ), IO.strToDouble(args[3]) ); }
            // else if (args[0].equals("rect"))      { shape = new Rectangle( new Point2D( IO.strToDouble(args[1]), IO.strToDouble(args[2]) ), new Point2D( IO.strToDouble(args[3]), IO.strToDouble(args[4]) ) ); }
            // else if (args[0].equals("show"))      { IO.println(shape); }
            else if (args[0].equals("circle"))    { shapes.add( new Circle( new Point2D( IO.strToDouble(args[1]), IO.strToDouble(args[2]) ), IO.strToDouble(args[3]) ) ); }
            else if (args[0].equals("rect"))      { shapes.add( new Rectangle( new Point2D( IO.strToDouble(args[1]), IO.strToDouble(args[2]) ), new Point2D( IO.strToDouble(args[3]), IO.strToDouble(args[4]) ) ) ); }
            else if (args[0].equals("show"))      { showAll( shapes ); }
            else if (args[0].equals("info"))      { infoAll( shapes ); }
            else                                  { IO.println("fail: comando invalido"); }
        }
    }

    public static void showAll(List<Shapes> shapes){
        for(Shapes shape : shapes){
            IO.println(shape);
        }
    }

    public static void infoAll(List<Shapes> shapes){
        for(Shapes shape : shapes){
            IO.println(shape.getInfo());
        }
    }
}