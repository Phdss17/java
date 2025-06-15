import java.text.DecimalFormat;

class Shapes {
    public String name;

    public Shapes( String name ) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean inside( Point2D p ) {
        return false;
    }
    public double getArea() {
        return 0.0;
    }
    public double getPerimeter() {
        return 0.0;
    }

    public String getInfo() {
        DecimalFormat d = new DecimalFormat("0.00"); //double x = 4.3; System.out.println( d.format(x) ); //4.30
        return getName() + ": A=" + d.format(getArea()) + " P=" + d.format(getPerimeter());

    }

    @Override
    public String toString() {
        return "";
    }
}