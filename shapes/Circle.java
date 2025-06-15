import java.text.DecimalFormat;

class Circle extends Shapes{
    public Point2D center;
    public double radius;

    public Circle( Point2D center, double radius ) {
        super("Circ");
        this.center = center;
        this.radius = radius;
    }

    @Override
    public boolean inside( Point2D p ) {
        return false;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        DecimalFormat d = new DecimalFormat("0.00");
        return "Circ: C=" + center + ", R=" + d.format(this.radius);
    }
}