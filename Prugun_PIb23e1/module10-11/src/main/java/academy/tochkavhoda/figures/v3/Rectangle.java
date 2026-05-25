package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.iface.v3.Stretchable;
import java.util.Objects;

public class Rectangle extends Figure implements Stretchable {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) { this.topLeft = topLeft; this.bottomRight = bottomRight; }
    public Rectangle(int x1, int y1, int x2, int y2)  { this(new Point(x1, y1), new Point(x2, y2)); }
    public Rectangle(int length, int width)            { this(new Point(0, -width), new Point(length, 0)); }
    public Rectangle()                                 { this(1, 1); }

    public Point getTopLeft()             { return topLeft; }
    public void setTopLeft(Point p)       { this.topLeft = p; }
    public Point getBottomRight()         { return bottomRight; }
    public void setBottomRight(Point p)   { this.bottomRight = p; }
    public int getLength() { return bottomRight.getX() - topLeft.getX(); }
    public int getWidth()  { return bottomRight.getY() - topLeft.getY(); }

    @Override public void moveTo(int x, int y) {
        int len = getLength(), wid = getWidth();
        topLeft.moveTo(x, y);
        bottomRight.moveTo(x + len, y + wid);
    }
    @Override public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy); bottomRight.moveRel(dx, dy);
    }
    @Override public void resize(double ratio) {
        bottomRight.moveTo(topLeft.getX() + (int)(getLength() * ratio),
                topLeft.getY() + (int)(getWidth()  * ratio));
    }
    @Override public void stretch(double xRatio, double yRatio) {
        bottomRight.moveTo(topLeft.getX() + (int)(getLength() * xRatio),
                topLeft.getY() + (int)(getWidth()  * yRatio));
    }

    @Override public double getArea()      { return (double) getLength() * getWidth(); }
    @Override public double getPerimeter() { return 2.0 * (getLength() + getWidth()); }

    @Override public boolean isInside(int x, int y) {
        return x >= topLeft.getX() && x <= bottomRight.getX()
                && y >= topLeft.getY() && y <= bottomRight.getY();
    }

    public boolean isIntersects(Rectangle other) {
        return !(other.getBottomRight().getX() < getTopLeft().getX()
                || other.getTopLeft().getX()     > getBottomRight().getX()
                || other.getBottomRight().getY() < getTopLeft().getY()
                || other.getTopLeft().getY()     > getBottomRight().getY());
    }
    public boolean isInside(Rectangle other) {
        return other.topLeft.getX()     >= topLeft.getX()
                && other.bottomRight.getX() <= bottomRight.getX()
                && other.topLeft.getY()     >= topLeft.getY()
                && other.bottomRight.getY() <= bottomRight.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle r = (Rectangle) o;
        return Objects.equals(topLeft, r.topLeft) && Objects.equals(bottomRight, r.bottomRight);
    }
    @Override public int hashCode() { return Objects.hash(topLeft, bottomRight); }
}