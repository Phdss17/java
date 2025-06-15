class Rectangle extends Shapes{
    public Point2D p1;
    public Point2D p2;

    public Rectangle( Point2D p1, Point2D p2 ) {
        super("rect");
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public boolean inside( Point2D p ) {
        return false;
    }

    @Override
    public double getArea() {
        double large = p1.x - p2.x;
        double high = p1.y - p2.y;

        return high*large;
    }

    @Override
    public double getPerimeter() {
        double large = p1.x - p2.x;
        double high = p1.y - p2.y;

        return Math.abs(2 * (large + high));
    }

    @Override
    public String toString() {
        return "Rect: P1=" + p1 + " P2=" + p2;
    }
}