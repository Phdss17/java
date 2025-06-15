import java.text.DecimalFormat;

class Point2D {
    public double x;
    public double y;

    public Point2D( double x, double y ) {
        this.x = x;
        this.y = y;
    }

    public double distance( Point2D p ) {
        double cH = this.x - p.x;
        double cV = this.y - p.y;
        return Math.sqrt( cH*cH + cV*cV );
    }

    @Override
    public String toString() {
        DecimalFormat d = new DecimalFormat("0.00");

        return "(" + d.format(x) + ", " + d.format(y) + ")";
    }
}