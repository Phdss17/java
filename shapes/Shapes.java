import java.text.DecimalFormat;

abstract class Shapes {
    private static final DecimalFormat d = new DecimalFormat("0.00");
    public String name;

    public Shapes( String name ) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    abstract public boolean inside( Point2D p );

    abstract public double getArea();

    abstract public double getPerimeter();

    public final String getInfo() {
        return getName() + ": A=" + d.format(getArea()) + " P=" + d.format(getPerimeter());
 
    }

    @Override
    abstract public String toString();
}