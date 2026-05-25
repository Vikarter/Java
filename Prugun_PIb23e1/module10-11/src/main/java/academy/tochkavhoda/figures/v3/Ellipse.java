package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.iface.v3.Stretchable;
import java.util.Objects;

public class Ellipse extends Figure implements Stretchable {
    private Point center;
    private int xAxis;
    private int yAxis;

    public Ellipse(Point center, int xAxis, int yAxis) { this.center = center; this.xAxis = xAxis; this.yAxis = yAxis; }
    public Ellipse(int x, int y, int xAxis, int yAxis) { this(new Point(x, y), xAxis, yAxis); }
    public Ellipse(int xAxis, int yAxis)               { this(new Point(0, 0), xAxis, yAxis); }
    public Ellipse()                                   { this(1, 1); }

    public Point getCenter()            { return center; }
    public void setCenter(Point center) { this.center = center; }
    public int getXAxis()               { return xAxis; }
    public void setXAxis(int xAxis)     { this.xAxis = xAxis; }
    public int getYAxis()               { return yAxis; }
    public void setYAxis(int yAxis)     { this.yAxis = yAxis; }

    @Override public void moveTo(int x, int y)   { center.moveTo(x, y); }
    @Override public void moveRel(int dx, int dy) { center.moveRel(dx, dy); }
    @Override public void resize(double ratio) {
        xAxis = (int)(xAxis * ratio); yAxis = (int)(yAxis * ratio);
    }
    @Override public void stretch(double xRatio, double yRatio) {
        xAxis = (int)(xAxis * xRatio); yAxis = (int)(yAxis * yRatio);
    }

    @Override public double getArea() { return Math.PI * (xAxis / 2.0) * (yAxis / 2.0); }
    @Override public double getPerimeter() {
        double a = xAxis / 2.0, b = yAxis / 2.0;
        return 2 * Math.PI * Math.sqrt((a * a + b * b) / 2);
    }
    @Override public boolean isInside(int x, int y) {
        double a = xAxis / 2.0, b = yAxis / 2.0;
        double dx = x - center.getX(), dy = y - center.getY();
        return (dx * dx) / (a * a) + (dy * dy) / (b * b) <= 1.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ellipse)) return false;
        Ellipse e = (Ellipse) o;
        return xAxis == e.xAxis && yAxis == e.yAxis && Objects.equals(center, e.center);
    }
    @Override public int hashCode() { return Objects.hash(center, xAxis, yAxis); }
}